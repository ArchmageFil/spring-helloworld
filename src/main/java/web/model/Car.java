package web.model;

public class Car {
    private String model;
    private String drive_unit;
    private int speed;

    public Car(String model, String drive_unit, int speed) {
        this.model = model;
        this.drive_unit = drive_unit;
        this.speed = speed;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDrive_unit() {
        return drive_unit;
    }

    public void setDrive_unit(String drive_unit) {
        this.drive_unit = drive_unit;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Машина " +
                "модели '" + model + '\'' +
                ", привод '" + drive_unit + '\'' +
                ", скорость: " + speed;
    }
}
