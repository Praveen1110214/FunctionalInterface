package BiFunction;

import java.util.function.BiFunction;

public class BiFunctionImpl implements BiFunction<Integer, Integer, String> {

    @Override
    public String apply(Integer num1, Integer num2) {
        return "SUM is " + (num1 + num2);
    }
}
