package at.campus02.iwi.devices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class DeviceDatabase {
    private ArrayList<Device> devices;

    public DeviceDatabase() {
        this.devices = new ArrayList<Device>();
    }

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

    //Liefert das Gerät als Rückgabewert, welches die niedrigsten Herstellungskosten aufweist
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

    //Für das im Parameter angegebene Gerät soll berechnet (=aufsummiert) werden wie viel
    //Supportkosten zwischen dem Veröffentlichungsjahr und dem im Parameter spezifizierten
    //Jahr (inklusive) entstehen. Falls das Jahr im Parameter vor Veröffentlichung liegt 0
    //zurückliefern.
    public double calculateSupportCostUntilYear(Device device, int year) {
        if (year < device.releaseYear) {
            return 0;
        }
        double erg = 0;
        for (int y = device.releaseYear; y <= year; ++y) {
            erg += device.calculateSupportCostForAYear(y);
        }
        return erg;
    }

    //Sie suchen das Gerät mit den in Summe höchsten Supportkosten zwischen Veröffentlichung
    //und dem im Parameter spezifizierten Jahr. Die Methode soll das Gerät zurückliefern
    Device findDeviceWithHighestSupportCostUntil(int year) {
        Device highestD = null;
        double highestCost = -1;

        for (Device d : devices) {
            double cost = calculateSupportCostUntilYear(d, year);
            if (cost > highestCost) {
                highestCost = cost;
                highestD = d;
            }
        }
        return highestD;
    }

    public ArrayList<Device> findDevicesThatFulfillMinimumPerformance(HashMap<Integer, Integer> minimum) {
        ArrayList<Device> erg = new ArrayList<>();

        for (Device d : devices) {
            Integer cores = minimum.get(d.getProcessor().getGeneration());
            if (cores != null && d.getProcessor().getNrCores() >= cores) {
                erg.add(d);
            }
        }

        return erg;
    }

    HashMap<String, Integer> numberDevicesGroupedByConstructionCost(double lowBorder, double mediumBorder) {
        HashMap<String, Integer> erg = new HashMap<>();
        erg.put("low", 0);
        erg.put("medium", 0);
        erg.put("high", 0);

        for (Device d : devices) {
            double price = d.calculateProductionCost() / d.getNrProduced();
            if (price < lowBorder) {
                erg.put("low", erg.get("low") + 1);
            } else {
                if (price < mediumBorder) {
                    erg.put("medium", erg.get("medium") + 1);
                } else {
                    erg.put("high", erg.get("high") + 1);
                }
            }
        }
        return erg;
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }


    public void sortedPrint() {
        DeviceComparator c = new DeviceComparator();
        Collections.sort(devices, c);
        System.out.println(devices.toString());

    }

    @Override
    public String toString() {
        return "DeviceDatabase{" +"\n"+
        "devices=" + devices +
                '}';
    }
}