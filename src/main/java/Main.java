import controller.Controller;
import controller.ControllerImp;
import manager.VehicleManager;
import parser.Parser;
import service.Service;
import service.ServiceImp;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws  IOException {
        VehicleManager repository = new VehicleManager();
        repository.addAll(Parser.read("test.xml"));
        Service service = new ServiceImp(repository, "test.xml");
        Controller controller = new ControllerImp(service);
        controller.startListening();
    }
}
