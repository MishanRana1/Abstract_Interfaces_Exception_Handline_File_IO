interface MeasurableEnergy {
    public double watts();
    
    default double kWhPerDay(){
        return (watts() * 24.0) / 1000.0;
    }

}