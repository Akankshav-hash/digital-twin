package digitaltwin;

public class EnvironmentModel {

    private double temperature = 25;

    public void update(int students, boolean fanOn,
                       boolean projectorOn,
                       boolean lightOn,
                       boolean acOn) {

        temperature = 25 + students * 0.15;

        if (projectorOn)
            temperature += 1;

        if (lightOn)
            temperature += 0.5;

        if (fanOn)
            temperature -= 2;

        if (acOn)
            temperature -= 5;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getComfortLevel() {

        if (temperature < 24)
            return "Cold";

        if (temperature > 30)
            return "Hot";

        return "Comfortable";
    }
}
