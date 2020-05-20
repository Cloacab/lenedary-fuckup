package service;

import manager.VehicleManager;
import parser.Parser;
import vehicle.Vehicle;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceImp implements Service {

    private String helpInfo = "";
    private VehicleManager vehicles;
    private String file;

    public ServiceImp(VehicleManager vehicles, String file){
        this.vehicles = vehicles;
        this.file = file;
    }

    {
        helpInfo += Stream.of(Service.class.getMethods())
                .filter(method -> method.isAnnotationPresent(Help.class))
                .map(method -> method.getAnnotation(Help.class).help())
                .collect(Collectors.joining("\n"));
    }

    @Override
    public void help() {
        System.out.println(helpInfo);
    }

    @Override
    public void info() {
        System.out.println("Дата создания: " + vehicles.getCreationDate() +
                "\n" + "Количество элементов: " +
                vehicles.getVehicles().size());
    }

    @Override
    public void show() {
        System.out.println(vehicles.getVehicles());
    }

    @Override
    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println(vehicles + "\n элемент добавлен в коллекцию \n");
    }

    @Override
    public void updateId(long id, Vehicle vehicle) {
        vehicles.removeById(id);
        vehicle.setId(id);
        vehicles.add(vehicle);
    }

    @Override
    public void removeById(long id) {
        vehicles.removeById(id);
    }

    @Override
    public void clear() {
        vehicles.clear();
    }

    @Override
    public void save() {
        try {
            Parser.write(vehicles.getVehicles(), file);
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
            System.out.println("Не удалось записать коллекцию в файл.");
        }
    }

    @Override
    public void executeScript(String file) {

    }

    @Override
    public void exit() {
        System.out.println("завершение работы");
        System.exit(0);
    }

    @Override
    public void removeFirst() {
        vehicles.removeById(vehicles.getVehicles().getFirst().getId());
    }

    @Override
    public void addIfMax(Vehicle vehicle) {
        Vehicle maxVehicle = vehicles.getVehicles().stream().max(Vehicle::compareTo).get();
        if (vehicle.compareTo(maxVehicle) > 0){
            vehicles.add(vehicle);
            System.out.println("элемент добавлен в коллекцию");
        }else {
            System.out.println("элемент не добавлен в коллекцию");
        }
    }

    @Override
    public void addIfMin(Vehicle vehicle) {
        Vehicle maxVehicle = vehicles.getVehicles().stream().max(Vehicle::compareTo).get();
        if (vehicle.compareTo(maxVehicle) < 0){
            vehicles.add(vehicle);
            System.out.println("элемент добавлен в коллекцию");
        }else {
            System.out.println("элемент не добавлен в коллекцию");
        }
    }

    @Override
    public void countLessThanFuelType(String fuelType) {
        int counter = (int) vehicles.getVehicles()
                .stream()
                .filter(vehicle -> vehicle.getFuelType().getValue()
                        < Vehicle.FuelType.valueOf(fuelType).getValue())
                .count();
        System.out.println(counter + " элементов меньше заданного");
    }

    @Override
    public void printDescending() {
        LinkedList<Vehicle> newVehicles = vehicles.getVehicles()
                .stream()
                .sorted(Vehicle::compareTo)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(newVehicles);
    }

    @Override
    public void printFieldAscendingEnginePower() {
        LinkedList<Vehicle> newVehicles = vehicles.getVehicles()
                .stream()
                .sorted((a, b) -> (int)(a.getEnginePower()-b.getEnginePower()))
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(newVehicles);
    }
}
