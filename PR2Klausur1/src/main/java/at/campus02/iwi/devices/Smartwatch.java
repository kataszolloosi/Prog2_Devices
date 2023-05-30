package at.campus02.iwi.devices;

public class Smartwatch extends Device {
    protected int nrWristSizes;

    public Smartwatch(String name, Processor processor, int releaseYear, int nrProduced,int nrWristSizes) {
        super(name, processor, releaseYear, nrProduced);
        this.nrWristSizes = nrWristSizes;
    }


    @Override
    public double calculateProductionCost() {
        return nrProduced * (100 + ((nrWristSizes - 1) * 10 ));
    }

    @Override
    public double calculateSupportCostForAYear(int year) {
        return nrProduced*processor.getNrCores()*10;
    }

    public int getNrWristSizes() {
        return nrWristSizes;
    }

    public void setNrWristSizes(int nrWristSizes) {
        this.nrWristSizes = nrWristSizes;
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
        return "Smartwatch{" +
                "name='" + name + '\'' +
                ", processor=" + processor +
                ", releaseYear=" + releaseYear +
                ", nrProduced=" + nrProduced +
                ", nrWristSizes=" + nrWristSizes +
                '}';
    }
}