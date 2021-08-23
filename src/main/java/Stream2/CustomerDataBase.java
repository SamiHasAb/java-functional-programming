package Stream2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerDataBase {

    public static List<Customer> getAll() {

        Customer c1 = new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725"));
        Customer c2 = new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947"));
        Customer c3 = new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236"));
        Customer c4 = new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"));

        List<Customer> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);

        return list;
    }
}
