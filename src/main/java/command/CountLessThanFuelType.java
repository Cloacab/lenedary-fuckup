package command;

import exceptions.InvalidCoordinatesException;
import exceptions.StopReadingException;
import service.Service;

import javax.swing.*;
import java.util.Scanner;

public class CountLessThanFuelType extends CommandImp {
    public CountLessThanFuelType(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {

        try {
            service.countLessThanFuelType(reader.readFuelType(scanner, true));
        } catch (StopReadingException e) {
            e.printStackTrace();
        }
    }
}
