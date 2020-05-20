package command;

import service.Service;
import exceptions.InvalidCoordinatesException;
import exceptions.StopReadingException;
import service.Service;

import java.util.Scanner;

public class AddIfMax extends CommandImp {
    public AddIfMax(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        try {
            service.addIfMax(reader.read(scanner, true));
        } catch (StopReadingException | InvalidCoordinatesException e) {
            e.printStackTrace();
        }
    }

}
