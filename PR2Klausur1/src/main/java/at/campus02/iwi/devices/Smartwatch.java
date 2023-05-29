package at.campus02.iwi.devices;

public class Smartwatch extends Device {
    protected String name;
    protected Processor processor;
    protected int releaseYear;
    protected int nrProduced;

    protected int nrWristSizes;

    public Smartwatch(String name, Processor processor, int releaseYear, int nrProduced,int nrWristSizes) {
        super(name, processor, releaseYear, nrProduced);
        this.nrWristSizes = nrWristSizes;
    }


    @Override
    public double calculateProductionCost() {
        double cost=100.0;//per Stück
        double costPlus=0;
        if(getNrWristSizes()==1){
            cost=100.0;
        }else if(getNrWristSizes()==2){
            costPlus=cost*0.1;
            cost+=costPlus;
        }else if(getNrWristSizes()==3){
            costPlus=cost*0.2;
            cost+=costPlus;
        }return cost * nrProduced;
    }

    @Override
    public double calculateSupportCostForAYear(int year) {
        return nrProduced*processor.getGeneration()*10;
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