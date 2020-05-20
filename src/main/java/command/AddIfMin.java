package command;

import service.Service;
import exceptions.InvalidCoordinatesException;
import exceptions.StopReadingException;

import java.util.Scanner;

public class AddIfMin extends CommandImp {
    public AddIfMin(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        try {
            service.addIfMin(reader.read(scanner, true));
        } catch (StopReadingException | InvalidCoordinatesException e) {
            e.printStackTrace();
        }

    }

}
