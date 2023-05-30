package at.campus02.iwi.devices;

import java.util.Comparator;

public class DeviceComparator implements Comparator<Device> {
    //Die Devices sollen nach zwei Kriterien aufsteigend sortiert werden:
    //Die Prozessorgeneration
    //und falls gleich als zweites Kriterium die Anzahl der Prozessorkerne

    @Override
    public int compare(Device o1, Device o2) {
        int s = Integer.compare(o1.getProcessor().getGeneration(), o2.getProcessor().getGeneration());
        if(s == 0){
            // nach prozessorkernen sortieren
            return Integer.compare(o1.getProcessor().getNrCores(), o2.getProcessor().getNrCores());
        }
        // weil erstes kriterium (prozessorgeneration) schon eindeutig sortier vorgibt
        return s;
    }
}