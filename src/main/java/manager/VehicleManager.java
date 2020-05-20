package manager;

import vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class VehicleManager {
    private LocalDateTime creationDate;
    private LinkedList<Vehicle> vehicles = new LinkedList<>();

    public VehicleManager(){
        this.creationDate = LocalDateTime.now();
    }

    public void add(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void addAll(LinkedList<Vehicle> vehicles){this.vehicles.addAll(vehicles);}

    public void removeById(long id){
        vehicles.remove(getById(id));
    }

    public Vehicle getById(long id){
        for (Vehicle v :
                vehicles) {
            if (v.getId() == id){
                return v;
            }
        }
        System.out.println(String.format("Element with id = %s was not found", id));
        return null;
    }

    public LinkedList<Vehicle> getVehicles() {
        return vehicles;
    }

    public String getCreationDate(){
        return creationDate.toString();
    }

    public void clear(){
        vehicles.clear();
    }
}
