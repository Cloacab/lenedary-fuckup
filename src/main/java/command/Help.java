package command;

import service.Service;

import java.util.Scanner;

public class Help extends CommandImp{
    public Help(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.help();
    }

}
