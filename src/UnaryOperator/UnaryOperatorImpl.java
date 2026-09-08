package UnaryOperator;

import java.util.function.UnaryOperator;

public class UnaryOperatorImpl implements UnaryOperator<String> {
    @Override
    public String apply(String str) {
        return str;
    }
}
