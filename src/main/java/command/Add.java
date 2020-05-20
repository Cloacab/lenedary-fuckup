package command;

import service.Service;
import exceptions.InvalidCoordinatesException;
import exceptions.StopReadingException;

import java.util.Scanner;

public class Add extends CommandImp {
    public Add(Service service, Scanner scanner) {
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
