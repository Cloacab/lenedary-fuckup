package command;

import service.Service;

import java.util.Scanner;

public class Save extends CommandImp {
    public Save(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.save();
    }
}
