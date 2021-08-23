package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        // takes no argumment but supplies a value
        //supplier.get
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionsUrlsSupplier.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/users";
    }

    static Supplier<String> getDBConnectionUrlsSupplier = ()
            -> "jdbc://localhost:5432/users";


    static Supplier<List<String>> getDBConnectionsUrlsSupplier = ()
            -> List.of(
            "jdbc://localhost:5432/users",
            "jdbc://localhost:5432/customer");

}
