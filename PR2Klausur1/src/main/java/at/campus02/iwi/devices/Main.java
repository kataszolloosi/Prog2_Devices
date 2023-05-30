package at.campus02.iwi.devices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // you can test your stuff however you like - it is not evaluated
        Processor p1 = new Processor("p1", 1, 1);
        Processor p2 = new Processor("p2", 2, 2);
        Processor p3 = new Processor("p3", 3, 1);
        Processor p4 = new Processor("p4", 4, 3);

        Smartwatch sw1 = new Smartwatch("Samsung", p1, 2011, 3, 22);
        Smartwatch sw2 = new Smartwatch("Apple", p2, 2017, 5, 25);
        Smartphone sp1 = new Smartphone("Sony", p3, 2009, 1, 19);
        Tablet t1 = new Tablet("fd", p4, 2, 2008, true);



        DeviceDatabase db = new DeviceDatabase();
        db.addDevice(sw1);
        db.addDevice(sw2);
        db.addDevice(sp1);
        db.addDevice(t1);

        System.out.println(db);
        db.sortedPrint();

    }
}
