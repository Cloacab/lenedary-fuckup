package command;

import service.Service;
import service.VehicleReader;

import java.util.Scanner;

public abstract class CommandImp implements Command {

    protected Service service;
    protected Scanner scanner;
    protected VehicleReader reader = new VehicleReader();

    public CommandImp(Service service, Scanner scanner){
        this.service = service;
        this.scanner = scanner;
    }

}
