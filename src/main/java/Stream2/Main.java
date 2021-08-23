package Stream2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------------------");


        // Filter

        List<Employee> emps = DataBase.getEmployees().stream()
                .filter(emp -> emp.getSalary() > 5000)
                .collect(Collectors.toList());

        emps.forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------");

        // Sort  a list

        List<Employee> emps2 = DataBase.getEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());

        emps2.forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------");

        // sort a Map

        Map<Integer, Employee> employeeMap = new TreeMap<>();
        employeeMap.put(50, new Employee(176, "Roshan", "IT", 600000));
        employeeMap.put(40, new Employee(388, "Bikash", "CIVIL", 900000));
        employeeMap.put(30, new Employee(470, "Bimal", "DEFENCE", 500000));
        employeeMap.put(20, new Employee(624, "Sourav", "CORE", 400000));
        employeeMap.put(10, new Employee(284, "Prakash", "SOCIAL", 1200000));

        employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        System.out.println("****************************");
        employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getSalary).reversed())).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------");


        //get list of emails
        //map

        List<String> emails = CustomerDataBase.getAll().stream()
                .map(Customer::getEmail)
                .collect(Collectors.toList());

        emails.forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------");

        //list of object
        List<List<String>> phoneNumbers = CustomerDataBase.getAll().stream()
                .map(Customer::getPhoneNumbers)
                .collect(Collectors.toList());
        System.out.println(phoneNumbers);

        System.out.println("--------------------------------------------------------------------");

        // flat-map
        List<String> phones = CustomerDataBase.getAll().stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());

        phones.forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------");

        // out put
/*
        --------------------------------------------------------------------
        Empolyee{id=176, name='Peter', dept='IT', salary=600000}
        Empolyee{id=388, name='Osam', dept='CIVIL', salary=900000}
        Empolyee{id=470, name='Khaleed', dept='DEFENCE', salary=500000}
        Empolyee{id=624, name='Sami', dept='CORE', salary=400000}
        Empolyee{id=176, name='Nada', dept='SOCIAL', salary=1200000}
        --------------------------------------------------------------------
        Empolyee{id=470, name='Khaleed', dept='DEFENCE', salary=500000}
        Empolyee{id=176, name='Nada', dept='SOCIAL', salary=1200000}
        Empolyee{id=388, name='Osam', dept='CIVIL', salary=900000}
        Empolyee{id=176, name='Peter', dept='IT', salary=600000}
        Empolyee{id=624, name='Sami', dept='CORE', salary=400000}
        --------------------------------------------------------------------
        10=Empolyee{id=284, name='Prakash', dept='SOCIAL', salary=1200000}
        20=Empolyee{id=624, name='Sourav', dept='CORE', salary=400000}
        30=Empolyee{id=470, name='Bimal', dept='DEFENCE', salary=500000}
        40=Empolyee{id=388, name='Bikash', dept='CIVIL', salary=900000}
        50=Empolyee{id=176, name='Roshan', dept='IT', salary=600000}
        ****************************
        10=Empolyee{id=284, name='Prakash', dept='SOCIAL', salary=1200000}
        40=Empolyee{id=388, name='Bikash', dept='CIVIL', salary=900000}
        50=Empolyee{id=176, name='Roshan', dept='IT', salary=600000}
        30=Empolyee{id=470, name='Bimal', dept='DEFENCE', salary=500000}
        20=Empolyee{id=624, name='Sourav', dept='CORE', salary=400000}
        --------------------------------------------------------------------
        john@gmail.com
        smith@gmail.com
        peter@gmail.com
        kely@gmail.com
        --------------------------------------------------------------------
        [[397937955, 21654725], [89563865, 2487238947], [38946328654, 3286487236], [389246829364, 948609467]]
        --------------------------------------------------------------------
        397937955
        21654725
        89563865
        2487238947
        38946328654
        3286487236
        389246829364
        948609467
        --------------------------------------------------------------------

*/
    }
}
