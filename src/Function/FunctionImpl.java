package Function;

import java.util.function.Function;

public class FunctionImpl implements Function<String, Integer> {

    @Override
    public Integer apply(String value) {
        return value.length();
    }

    public static void main(String[] args) {
        Function<Integer, Integer> function1 = (n) -> n * 2;
        Function<Integer, Integer> function2 = (n) -> n + 10;
        Function<Integer, Integer> combinedFunction = function1.andThen(function2);
        System.out.println(combinedFunction.apply(2));
        System.out.println(function1.compose(function2).apply(2));

        Function<String, String> identity = Function.identity();
        System.out.println(identity.apply("Praveen"));
    }
}
