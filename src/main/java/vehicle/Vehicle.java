package vehicle;

import com.sun.istack.internal.NotNull;
import exceptions.InvalidCoordinatesException;

import java.time.LocalDateTime;
import java.util.Random;

public class Vehicle implements Comparable {

    static private long counter = 0L;

    private long id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private long enginePower;
    private VehicleType vehicleType;
    private FuelType fuelType;

    public Vehicle(@NotNull String name, @NotNull double x, @NotNull int y,
                   long enginePower, @NotNull String vehicleType,
                   @NotNull String fuelType) {

        this.setId(++counter);

        this.setName(name);
        this.setCoordinates(x, y);
        this.setEnginePower(enginePower);
        this.setVehicleType(vehicleType);
        this.setFuelType(fuelType);
        this.creationDate = LocalDateTime.now();

    }

    public Vehicle(@NotNull String name, @NotNull Coordinates coordinates,
                   long enginePower, @NotNull String vehicleType,
                   @NotNull String fuelType) {

        this.setId(++counter);

        this.setName(name);
        this.coordinates = coordinates;
        this.setEnginePower(enginePower);
        this.setVehicleType(vehicleType);
        this.setFuelType(fuelType);
        this.creationDate = LocalDateTime.now();

    }

    public Vehicle() {
        generateRandomValues();
    }

    private void generateRandomValues() {
        this.setId(++counter);

        String chars = "abcdefghijklmnopqrstuvwxyz";
        String name = "";

        for (int i = 0; i < 6; i++) {
            int index = new Random().nextInt(26);
            name = name.concat(String.valueOf(chars.charAt(index)));
        }

        this.name = name;

        Random rnd = new Random();

        this.setCoordinates(rnd.nextDouble() * 100, rnd.nextInt(200));
        this.setEnginePower(rnd.nextInt(500));
        this.setFuelType("GASOLINE");
        this.setVehicleType("CAR");
        this.creationDate = LocalDateTime.now();
    }

    @Override
    public int compareTo(Object o) {
        Vehicle other = (Vehicle) o;
        return (int) (other.getEnginePower() - this.getEnginePower());
    }

    @Override
    public String toString() {
        return "Vehicle:\n" +
                "\tId: " + this.getId() + "\n" +
                "\tName: " + this.getName() + "\n" +
                "\tCoordinates: " + this.getCoordinates() + "\n" +
                "\tCreation date: " + this.getCreationDate() + "\n" +
                "\tEngine power: " + this.getEnginePower() + "\n" +
                "\tVehicle type: " + this.getVehicleType() + "\n" +
                "\tFuel type: " + this.getFuelType() + "\n";

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double x, int y) {

        try {
            coordinates = new Coordinates(x, y);
        } catch (InvalidCoordinatesException e) {
            e.printStackTrace();
        }

    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public long getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(long enginePower) {
        this.enginePower = enginePower;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = VehicleType.valueOf(vehicleType);
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = FuelType.valueOf(fuelType);
    }

    public enum VehicleType {
        CAR,
        SHIP,
        MOTORCYCLE,
        HOVERBOARD,
        SPACESHIP;

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public enum FuelType {
        GASOLINE(1),
        MANPOWER(2),
        NUCLEAR(3),
        PLASMA(4),
        ANTIMATTER(5);

        private int value;
        private Object o;

        FuelType(int value) {
            this.value = value;
        }

        public int getValue(){return value;}

        @Override
        public String toString() {
            return super.toString();
        }
    }

}
