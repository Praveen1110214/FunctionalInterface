package BiConsumer;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class BiConsumerImpl implements BiConsumer<ArrayList<Integer>, Integer> {
    @Override
    public void accept(ArrayList<Integer> list, Integer number) {
        list.add(number);
    }
}
