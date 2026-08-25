package digitaltwin;

public class EnergyManager {

    private boolean lightOn;
    private boolean fanOn;
    private boolean projectorOn;
    private boolean acOn;

    private double energyConsumed;

    public void update(int students, boolean lectureOn, double temperature) {

        if (students == 0) {

            lightOn = false;
            fanOn = false;
            projectorOn = false;
            acOn = false;
        }
        else {

            lightOn = true;

            projectorOn = lectureOn;

            fanOn = (students > 20 || temperature > 28);

            acOn = (temperature > 30);
        }

        energyConsumed = 0;

        if (lightOn)
            energyConsumed += 5;

        if (fanOn)
            energyConsumed += 3;

        if (projectorOn)
            energyConsumed += 6;

        if (acOn)
            energyConsumed += 10;
    }

    public boolean isLightOn() { return lightOn; }
    public boolean isFanOn() { return fanOn; }
    public boolean isProjectorOn() { return projectorOn; }
    public boolean isAcOn() { return acOn; }

    public double getEnergyConsumed() { return energyConsumed; }
}
