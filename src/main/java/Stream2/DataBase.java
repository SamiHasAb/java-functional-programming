package Stream2;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(176, "Peter", "IT", 600000));
        list.add(new Employee(388, "Osam", "CIVIL", 900000));
        list.add(new Employee(470, "Khaleed", "DEFENCE", 500000));
        list.add(new Employee(624, "Sami", "CORE", 400000));
        list.add(new Employee(176, "Nada", "SOCIAL", 1200000));
        return list;
    }
}
