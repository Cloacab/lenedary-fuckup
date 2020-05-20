package command;

import exceptions.InvalidCoordinatesException;
import exceptions.StopReadingException;
import service.Service;

import java.util.Scanner;

public class Update extends CommandImp {
    public Update(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        try {
            service.updateId(Integer.parseInt(args[0]) ,reader.read(scanner, true));
        } catch (StopReadingException | InvalidCoordinatesException e) {
            e.printStackTrace();
        }
    }
}
