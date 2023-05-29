package at.campus02.iwi.devices;

import java.util.ArrayList;

public class DeviceDatabase {
    private ArrayList<Device> devices = new ArrayList<>();

    public void addDevice(Device d) {
        devices.add(d);
    }

    public double calculateSumOfProductionCosts() {
        double sum = 0;
        for (Device d : devices) {
            sum = sum + d.calculateProductionCost();
        }
        return sum;
    }

    public Device findDeviceWithCheapestProductionCost() {
        double cheapest = 0;
        Device cDevice = null;

        for (Device d : devices) {
            double cost = d.calculateProductionCost();
            if (cDevice == null || cost < cheapest) {
                cDevice = d;
                cheapest = cost;
            }
        }
        return cDevice;
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }
}