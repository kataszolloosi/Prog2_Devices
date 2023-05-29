package at.campus02.iwi.devices;


public class Tablet extends Device {
    protected String name;
    protected Processor processor;
    protected int releaseYear;
    protected int nrProduced;

    protected boolean arCamera;

    public Tablet(String name, Processor processor, int releaseYear, int nrProduced, boolean arCamera) {
        super(name, processor, releaseYear, nrProduced);
        this.arCamera = arCamera;
    }


    @Override
    public double calculateProductionCost() {
        double cost = 0;

        if (getProcessor().getGeneration() == 1 && getProcessor().getNrCores() <= 2) {
            if (getProcessor().getNrCores() == 1) {
                cost = 150.0 * getNrProduced();
            } else {
                cost = 200 * getNrProduced();
            }
        }
        if (getProcessor().getGeneration() == 2 && getProcessor().getNrCores() <= 8) {
            if (getProcessor().getNrCores() <= 3) {
                cost = 300 * getNrProduced();
            } else if (getProcessor().getNrCores() <= 7) {
                cost = 400 * getNrProduced();
            } else if (getProcessor().getNrCores() <= 8) {
                cost = 450 * getNrProduced();
            }
        }
        if (getProcessor().getGeneration() == 3) {
            cost = 700 * getNrProduced();
        }
        if (arCamera == true) {
            cost = (cost + 50) * getNrProduced();
        }
        return cost * nrProduced;
    }

    @Override
    public double calculateSupportCostForAYear(int year) {
        int diffYear = year - releaseYear;

        return nrProduced * (50 * (1 - diffYear * 0.1));
    }

    public boolean isArCamera() {
        return arCamera;
    }

    public void setArCamera(boolean arCamera) {
        this.arCamera = arCamera;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getNrProduced() {
        return nrProduced;
    }

    public void setNrProduced(int nrProduced) {
        this.nrProduced = nrProduced;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "name='" + name + '\'' +
                ", processor=" + processor +
                ", releaseYear=" + releaseYear +
                ", nrProduced=" + nrProduced +
                ", arCamera=" + arCamera +
                '}';
    }
}