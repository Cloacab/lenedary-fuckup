package command;

import exceptions.InvalidCoordinatesException;
import exceptions.StopReadingException;
import service.Service;

import java.util.Scanner;

public class ExecuteScript extends CommandImp {
    public ExecuteScript(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        try {
            service.add(reader.read(scanner, true));
        } catch (StopReadingException | InvalidCoordinatesException e) {
            e.printStackTrace();
        }
    }
}
