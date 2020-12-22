package by.tc.task02.main;
import static by.tc.task02.entity.criteria.SearchCriteria.*;
import by.tc.task02.entity.Appliance;
import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.service.ApplianceService;
import by.tc.task02.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {

		Appliance appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaRefrigerator = new Criteria("Refrigerator");
		criteriaRefrigerator.add(RefrigeratorCriteria.FREEZER_CAPACITY.toString(), 10);

		appliance = service.find(criteriaRefrigerator);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		criteriaRefrigerator = new Criteria("Refrigerator");
		criteriaRefrigerator.add(RefrigeratorCriteria.HEIGHT.toString(), 200);
		criteriaRefrigerator.add(RefrigeratorCriteria.POWER_CONSUMPTION.toString(), 100);

		appliance = service.find(criteriaRefrigerator);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaTabletPC = new Criteria("TabletPC");
		criteriaTabletPC.add(TabletPCCriteria.COLOR.toString(), "blue");
		criteriaTabletPC.add(TabletPCCriteria.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPCCriteria.MEMORY_ROM.toString(), 8000);

		appliance = service.find(criteriaTabletPC);// find(Object...obj)

		PrintApplianceInfo.print(appliance);

	}

}
