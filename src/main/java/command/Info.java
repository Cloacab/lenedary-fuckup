package command;

import service.Service;
import java.util.Scanner;

public class Info extends CommandImp {

    public Info(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.info();
    }
}
