package service;

import vehicle.Vehicle;

public interface Service {
    @Help(help = "help : вывести справку по доступным командам")
    void help();

    @Help(help = "info : вывести в стандартный поток вывода информацию о коллекции")
    void info();

    @Help(help = "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении")
    void show();

    @Help(help = "add {element} : добавить новый элемент в коллекцию")
    void add(Vehicle vehicle);

    @Help(help = "update id {element} : обновить значение элемента коллекции, id которого равен заданному")
    void updateId(long id, Vehicle vehicle);

    @Help(help = "remove_by_id id : удалить элемент из коллекции по его id")
    void removeById(long id);

    @Help(help = "clear : очистить коллекцию")
    void clear();

    @Help(help = "save : сохранить коллекцию в файл")
    void save();

    @Help(help = "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.")
    void executeScript(String file);

    @Help(help = "exit : завершить программу (без сохранения в файл)")
    void exit();

    @Help(help = "remove_first : удалить первый элемент из коллекции")
    void removeFirst();

    @Help(help = "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции")
    void addIfMax(Vehicle vehicle);

    @Help(help = "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции")
    void addIfMin(Vehicle vehicle);

    @Help(help = "count_less_than_fuel_type fuelType : вывести количество элементов, значение поля fuelType которых меньше заданного")
    void countLessThanFuelType(String fuelType);

    @Help(help = "print_descending : вывести элементы коллекции в порядке убывания")
    void printDescending();

    @Help(help = "print_field_ascending_engine_power : вывести значения поля enginePower всех элементов в порядке возрастания")
    void printFieldAscendingEnginePower();
}
