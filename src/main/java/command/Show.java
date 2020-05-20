package command;

import service.Service;

import java.util.Scanner;

public class Show extends CommandImp {
    public Show(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.show();
    }
}
