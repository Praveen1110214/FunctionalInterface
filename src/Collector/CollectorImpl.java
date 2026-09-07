package Collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorImpl {
    public static void main(String[] args) {
        Supplier<ArrayList<Integer>> supplier = ArrayList::new;
        BiConsumer<ArrayList<Integer>, Integer> accumulator = ArrayList::add;
        BinaryOperator<ArrayList<Integer>> combiner = (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
        Function<ArrayList<Integer>, ArrayList<Integer>> finisher = Function.identity();
        Collector<Integer, ArrayList<Integer>, ArrayList<Integer>> collector=
                Collector.of(supplier, accumulator, combiner, finisher);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ArrayList<Integer> result = list.stream().collect(collector);
        List<Integer> result1 = list.stream().collect(Collectors.toList());
        System.out.println(result);
        System.out.println(result1);
    }
}