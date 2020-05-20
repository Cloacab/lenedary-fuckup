package command;

import service.Service;

import java.util.Scanner;

public class PrintFieldAscendingEnginePower extends CommandImp {
    public PrintFieldAscendingEnginePower(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.printFieldAscendingEnginePower();
    }
}
