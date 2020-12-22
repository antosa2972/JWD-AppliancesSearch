package by.tc.task02.entity;

import java.util.Objects;

public class Laptop extends Appliance
{
    private float BATTERY_CAPACITY;
    private String OS;
    private int ROM;
    private int SYSTEM_MEMORY;
    private float CPU;
    private int DISPLAY;

    public Laptop(float batteryCapacity, String os, int memoryRom, int systemMemory, float cpu, int display) {
        this.BATTERY_CAPACITY = batteryCapacity;
        this.OS = os;
        this.ROM = memoryRom;
        this.SYSTEM_MEMORY = systemMemory;
        this.CPU = cpu;
        this.DISPLAY = display;
    }

    @Override
    public String toString() {
        return "Laptop : " +
                "batteryCapacity = " + BATTERY_CAPACITY +
                ", os = " + OS +
                ", memoryRom = " + ROM +
                ", systemMemory = " + SYSTEM_MEMORY +
                ", cpu = " + CPU +
                ", display = " + DISPLAY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return BATTERY_CAPACITY == laptop.BATTERY_CAPACITY &&
                ROM == laptop.ROM &&
                SYSTEM_MEMORY == laptop.SYSTEM_MEMORY &&
                Double.compare(laptop.CPU, CPU) == 0 &&
                DISPLAY == laptop.DISPLAY &&
                Objects.equals(OS, laptop.OS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(BATTERY_CAPACITY, OS, ROM, SYSTEM_MEMORY, CPU, DISPLAY);
    }

    public float getBATTERY_CAPACITY() {
        return BATTERY_CAPACITY;
    }

    public void setBATTERY_CAPACITY(int BATTERY_CAPACITY) {
        this.BATTERY_CAPACITY = BATTERY_CAPACITY;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getROM() {
        return ROM;
    }

    public void setROM(int ROM) {
        this.ROM = ROM;
    }

    public int getSYSTEM_MEMORY() {
        return SYSTEM_MEMORY;
    }

    public void setSYSTEM_MEMORY(int SYSTEM_MEMORY) {
        this.SYSTEM_MEMORY = SYSTEM_MEMORY;
    }

    public double getCPU() {
        return CPU;
    }

    public void setCPU(float CPU) {
        this.CPU = CPU;
    }

    public int getDISPLAY() {
        return DISPLAY;
    }

    public void setDISPLAY(int DISPLAY) {
        this.DISPLAY = DISPLAY;
    }
}
