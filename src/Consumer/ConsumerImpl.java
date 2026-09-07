package Consumer;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ConsumerImpl implements Consumer<ArrayList<Integer>> {

    @Override
    public void accept(ArrayList<Integer> list){
        for(int i = 0; i < 10; i++){
            list.add(i + 1);
        }
    }

    public static void main(String[] args) {
        Consumer<String> consumer1 = (value) -> System.out.println("First : " + value);
        Consumer<String> consumer2 = (value) -> System.out.println("Second : " + value);
        Consumer<String> consumer3 = (value) -> System.out.println("Third : " + value);
        Consumer<String> combinedConsumer = consumer1.andThen(consumer2).andThen(consumer3);
        combinedConsumer.accept("Value");


    }
}
