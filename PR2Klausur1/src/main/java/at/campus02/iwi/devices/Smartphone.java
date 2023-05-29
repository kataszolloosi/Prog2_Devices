package at.campus02.iwi.devices;


public class Smartphone extends Device {
    protected String name;
    protected Processor processor;
    protected int releaseYear;
    protected int nrProduced;
    protected int nrCameras;

    public Smartphone(String name, Processor processor, int releaseYear, int nrProduced, int nrCameras) {
        super(name, processor, releaseYear, nrProduced);
        this.nrCameras = nrCameras;
    }


    @Override
    public double calculateProductionCost() {
        double cameraCost = 20.0;
        double processorCost = 100;
        double sum = 0;
        double discount = 0;

        for (int i = 0; i < getProcessor().getGeneration() + 1; i++) {
            processorCost *= i;
            sum = (processorCost + (cameraCost * getNrCameras()) * getNrProduced());
        }
        if (getNrProduced() > 100000) {
            discount = sum / 100 * 10;
        } else if (getNrProduced() > 1000000) {
            discount = sum / 100 * 20;
        } else {
            discount = 0;
        }
        return (sum + discount)*nrProduced;
    }

    @Override
    public double calculateSupportCostForAYear(int year) {
        double supportKosten = 0;
        if (releaseYear == year || releaseYear==year+1 ) {
            return supportKosten*nrProduced;
        } else {
            return getProcessor().getGeneration()*40*nrProduced;
        }
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

    public int getNrCameras() {
        return nrCameras;
    }

    public void setNrCameras(int nrCameras) {
        this.nrCameras = nrCameras;
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
        return "Smartphone{" +
                "name='" + name + '\'' +
                ", processor=" + processor +
                ", releaseYear=" + releaseYear +
                ", nrProduced=" + nrProduced +
                ", nrCameras=" + nrCameras +
                '}';
    }
}