package command;

import exceptions.InvalidCoordinatesException;
import exceptions.StopReadingException;
import service.Service;

import java.util.Scanner;

public class RemoveById extends CommandImp {
    public RemoveById(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.removeById(Integer.parseInt(args[0]));
    }
}
