package command;

import service.Service;

import java.util.Scanner;

public class Clear extends CommandImp {
    public Clear(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.clear();
    }
}
