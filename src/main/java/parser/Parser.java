package parser;

import vehicle.Vehicle;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.LinkedList;

public class Parser {

    static public void write(LinkedList<Vehicle> vehicles, String file) throws ParserConfigurationException, IOException {

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));

        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("vehicles");
            doc.appendChild(rootElement);

            for (Vehicle v :
                    vehicles) {
                String id = String.valueOf(v.getId());
                String name = v.getName();
                String coordinates = v.getCoordinates().toString();
                String enginePower = String.valueOf(v.getEnginePower());
                String vehicleType = v.getVehicleType().toString();
                String fuelType = v.getFuelType().toString();

                Element vehicle = doc.createElement("vehicle");
                rootElement.appendChild(vehicle);

                Element idE = doc.createElement("id");
                idE.appendChild(doc.createTextNode(id));
                vehicle.appendChild(idE);

                Element nameE = doc.createElement("name");
                nameE.appendChild(doc.createTextNode(name));
                vehicle.appendChild(nameE);

                Element coordinatesE = doc.createElement("coordinates");
                coordinatesE.appendChild(doc.createTextNode(coordinates));
                vehicle.appendChild(coordinatesE);

                Element enginePowerE = doc.createElement("enginePower");
                enginePowerE.appendChild(doc.createTextNode(enginePower));
                vehicle.appendChild(enginePowerE);

                Element vehicleTypeE = doc.createElement("vehicleType");
                vehicleTypeE.appendChild(doc.createTextNode(vehicleType));
                vehicle.appendChild(vehicleTypeE);

                Element fuelTypeE = doc.createElement("fuelType");
                fuelTypeE.appendChild(doc.createTextNode(fuelType));
                vehicle.appendChild(fuelTypeE);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(out);
            transformer.transform(source, result);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }

    }


    static public LinkedList<Vehicle> read(String file) throws IOException {

        
        ;

        LinkedList<Vehicle> vehicles = new LinkedList<>();

        long id;
        String name;
        double x;
        int y;
        long enginePower;
        String vehicleType;
        String fuelType;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(in);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("vehicle");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    id = Long.parseLong(element.getElementsByTagName("id").item(0).getTextContent());
                    name = element.getElementsByTagName("name").item(0).getTextContent();
                    x = Double.parseDouble(element.getElementsByTagName("coordinates").item(0).getTextContent().split(" ")[2]);
                    y = Integer.parseInt(element.getElementsByTagName("coordinates").item(0).getTextContent().split(" ")[5]);
                    enginePower = Long.parseLong(element.getElementsByTagName("enginePower").item(0).getTextContent());
                    vehicleType = element.getElementsByTagName("vehicleType").item(0).getTextContent();
                    fuelType = element.getElementsByTagName("fuelType").item(0).getTextContent();

                    Vehicle v = new Vehicle(name, x, y, enginePower, vehicleType, fuelType);
                    v.setId(id);
                    vehicles.add(v);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
            return vehicles;
        }

    }

}
