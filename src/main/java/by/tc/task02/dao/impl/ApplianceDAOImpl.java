package by.tc.task02.dao.impl;

import by.tc.task02.dao.ApplianceDAO;
import by.tc.task02.entity.Appliance;
import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.factories.FactoryAppliance;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public Appliance find(Criteria criteria)
	{
		Appliance res = null;

		File file = new File("src\\main\\resources\\appliances_db.txt");

		try(Scanner scnr = new Scanner(file))
		{
			while(scnr.hasNextLine())
			{
				String line = scnr.nextLine();
				String[] cols = null;

				if(!line.isEmpty())
					cols = line.split(" : ");

				if(cols[0].compareTo(criteria.getGroupSearchName()) != 0)
				{
					continue;
				}

				HashMap<String, String> searchMap = new HashMap<String, String>();

				String[] parametres = cols[1].split(", ");

				for(int i = 0; i < parametres.length; i++)
				{
					String paramsValues[] = parametres[i].split("=");

					for(int j = 0; j < paramsValues.length; j += 2)
					{
						searchMap.put(paramsValues[j], paramsValues[j+1]);
					}
				}

				boolean found = true;

				for(HashMap.Entry<String, Object> criteriaEntry: criteria.getCriteria().entrySet())
				{
					if(!(searchMap.containsKey(criteriaEntry.getKey()) && searchMap.get(criteriaEntry.getKey()).equals(criteriaEntry.getValue())))
						found = false;

				}

				if(found)
				{
					FactoryAppliance applianceFactory = new FactoryAppliance();
					ArrayList<String> parameters = new ArrayList<String>();

					for(int i = 0; i < parametres.length; i++)
					{
						String paramsValues[] = parametres[i].split("=");

						for(int j = 1; j < paramsValues.length; j += 2)
						{
							parameters.add(paramsValues[j]);
						}
					}

					res = applianceFactory.create(criteria.getGroupSearchName(), parameters);
					return res;
				}
			}
		}
		catch (Exception ex)
		{
			ex.getMessage();
		}

		return res;
	}
}