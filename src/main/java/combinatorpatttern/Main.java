package combinatorpatttern;

import java.time.LocalDate;

import static combinatorpatttern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {

        Customer customer1 = new Customer(
                "Faisel",
                "aisel@gmail.com",
                "+0898787",
                LocalDate.of(2000, 1,1)
        );

        Customer customer2 = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0898787879878",
                LocalDate.of(2015, 1,1)
        );

        // by CustomerValidatorService
        System.out.println("is customer 1 valid");
        System.out.println(new CustomerValidatorService().isValid(customer1));

        // if valid we can store customer in db

        System.out.println("is customer 2 valid");

        // Using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer2);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }
}
