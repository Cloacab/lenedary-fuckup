package command;

import service.Service;

import java.util.Scanner;

public class Exit extends CommandImp {

    public Exit(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.exit();
    }
}
