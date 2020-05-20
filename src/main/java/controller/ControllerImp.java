package controller;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import command.Command;
import service.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ControllerImp implements Controller {

    private Scanner scanner;
    private Service service;

    public ControllerImp(Service service){
        this.service = service;
        this.scanner = new Scanner(System.in);
    }
    @Override
    public void execute(String command) {
        String[] args = command.split(" ");
        if (args[0].equals("execute_script")) {
            Scanner oldScanner = scanner;
            try {
                scanner = new Scanner(new FileReader(new File(args[1])));
                startListening();
                scanner = oldScanner;
                System.out.println("Скрипт выполнен");
            } catch (IOException e) {
                System.out.println("Скрипт не найден");
            }
            return;
        }
        try {
            Command cmd = (Command) Class.forName("command." + translateCommand(args[0]))
                    .getConstructor(Service.class, Scanner.class).newInstance(service, scanner);
            try {
                cmd.execute(Arrays.copyOfRange(args, 1, args.length));
            } catch (IllegalArgumentException e) {
                cmd.execute(args);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println("Такой команды нет");
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startListening() {
        System.out.println("Введите команду");
        while (scanner.hasNext()) {
            execute(scanner.nextLine());
            System.out.println("Введите команду");
        }
    }

    private String  translateCommand(String command){
        return Stream.of(command.split("_"))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.joining());
    }
}
