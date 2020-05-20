package command;

import service.Service;

import java.util.Scanner;

public class RemoveFirst extends CommandImp {
    public RemoveFirst(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.removeFirst();
    }
}
