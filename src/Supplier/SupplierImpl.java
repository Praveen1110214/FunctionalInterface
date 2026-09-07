package Supplier;

import java.util.function.Supplier;

public class SupplierImpl implements Supplier<String> {

    @Override
    public String get() {
        return "Supplied";
    }
}