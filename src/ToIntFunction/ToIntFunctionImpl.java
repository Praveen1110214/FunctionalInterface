package ToIntFunction;

import java.util.function.ToIntFunction;

public class ToIntFunctionImpl implements ToIntFunction<String> {

    @Override
    public int applyAsInt(String str){
        return str.length();
    }

    public static void main(String[] args) {
        String str = "Praveen";
        ToIntFunction<String> toIntFunction = (string) -> string.length();
        System.out.println(toIntFunction.applyAsInt(str));
    }
}