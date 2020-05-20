package command;

import service.Service;
import java.util.Scanner;

public class PrintDescending extends CommandImp {

    public PrintDescending(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.printDescending();
    }
}
