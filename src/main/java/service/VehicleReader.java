package service;

import exceptions.InvalidCoordinatesException;
import exceptions.StopReadingException;
import vehicle.Coordinates;
import vehicle.Vehicle;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;

public class VehicleReader {
    private Scanner scanner;
    private boolean verbose;

    public VehicleReader(){

    }

    private Object readField(String fieldName, Function<Scanner, Object> callback) throws StopReadingException {
        if (verbose) {
            System.out.println("Введите " + fieldName);
        }
        Object res;
        while (true) {
            try {
                res = callback.apply(scanner);
                if (res.equals("break")) {
                    throw new StopReadingException("Отмена");
                }
                break;
            } catch (IllegalArgumentException e) {
                scanner.nextLine();
                if (verbose) {
                    System.out.println(e.getMessage());
                    System.out.println("Попробуйте еще раз");
                }
            } catch (NoSuchElementException e) {
                throw new StopReadingException("неверный ввод");
            }
        }
        return res;
    }

    public Vehicle read(Scanner scanner, boolean verbose) throws StopReadingException, InvalidCoordinatesException {
        this.scanner = scanner;
        this.verbose = verbose;

        return new Vehicle(
                readName(),
                readCoordinates(),
                readEnginePower(),
                readVehicleType(),
                readFuelType()
        );
    }

    public String readFuelType(Scanner scanner, boolean verbose) throws StopReadingException {

        this.scanner = scanner;
        this.verbose = verbose;

        return this.readFuelType();
    }

    private String  readFuelType() throws StopReadingException {
        String fieldName = String.format("тип топлива: %s", Arrays.toString(Vehicle.FuelType.values()));
//        scanner.nextLine();
        return (String) readField(fieldName, (scanner) -> Vehicle.FuelType.valueOf(scanner.nextLine()).toString());
    }

    private String  readVehicleType() throws StopReadingException {
        String fieldName = String.format("тип транспорта: %s", Arrays.toString(Vehicle.VehicleType.values()));
//        scanner.nextLine();
        return (String) readField(fieldName, (scanner) -> Vehicle.VehicleType.valueOf(scanner.nextLine()).toString());
    }

    private int readEnginePower() throws StopReadingException {
        return (int) readField("мощность транспортного средства", Scanner::nextInt);
    }

    private Coordinates readCoordinates() throws StopReadingException, InvalidCoordinatesException {
        return new Coordinates(
                (double) readField("Х координата", Scanner::nextDouble),
                (int) readField("Y координата", Scanner::nextInt)
        );
    }

    private String readName() throws StopReadingException {
        return (String) this.readField("название транспортного средства", Scanner::nextLine);
    }
}
