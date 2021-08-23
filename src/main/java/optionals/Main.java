package optionals;

import org.w3c.dom.ls.LSOutput;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        System.out.println(Optional.empty().isPresent()); //false

        System.out.println(Optional.empty().isEmpty());  // true


        System.out.println(
                Optional.ofNullable(null)
                .orElseGet(()->"default value is null"));

        System.out.println(
                 Optional.ofNullable("hello")
                .orElseGet(()->"default value is null"));

        System.out.println(
                Optional.ofNullable("hello")
                        .map(String::toUpperCase));

        System.out.println(
                Optional.ofNullable("hello").toString().toUpperCase());


        Optional<String> hello = Optional.ofNullable("hello");
        System.out.println(hello.map(String::toUpperCase).orElse("other"));


        Optional.ofNullable("john@gmail.com")
                .ifPresent(System.out::println);

        Optional.ofNullable("john@gmail.com")
                .ifPresent(email -> System.out.println("sending email to "+email));

        Optional.ofNullable("test@mail.com")
                .ifPresentOrElse(
                        email -> System.out.println("can send email to " + email),
                        () -> System.out.println("Cannot send email"));

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email"));

        System.out.println(
                Optional.ofNullable("hello")
                        .orElseThrow(()-> new IllegalStateException("write exception message here.....")));
        System.out.println(
                Optional.ofNullable(null)
                .orElseThrow(()-> new IllegalStateException("I WROTE THIS ERROR HAHAHAHAHAHAHAHAHAHA")));




    }
}
