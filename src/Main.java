import Comparator.ComparatorImpl;
import Consumer.ConsumerImpl;
import Function.FunctionImpl;
import Predicate.PredicateImpl;
import Supplier.SupplierImpl;
import BiConsumer.BiConsumerImpl;
import BiFunction.BiFunctionImpl;
import BinaryOperator.BinaryOperatorImpl;
import ToIntFunction.ToIntFunctionImpl;
import UnaryOperator.UnaryOperatorImpl;

import java.util.ArrayList;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        PredicateImpl predicate = new PredicateImpl();
        System.out.println(predicate.test(55));

        Predicate<Integer> p = (value) -> value > 18;
        System.out.println(p.test(55));

        Predicate<Integer> p1 = (value) -> value % 2 == 0;
        System.out.println(p1.test(50));

        Predicate<Integer> predicateResult = p.and(p1);
        System.out.println(predicateResult.test(20));

        //Predicate.not() is for predicate that does not present
        Predicate<Integer> p2 = Predicate.not(v -> v % 2 == 0);
        System.out.println(p2.test(5));

        Predicate<Integer> p3 = p1.negate();
        System.out.println(p3.test(5));


        FunctionImpl function = new FunctionImpl();
        System.out.println(function.apply("praveen"));

        Function<String, Integer> f = String::length;
        System.out.println(f.apply("praveend"));

        ConsumerImpl consumer = new ConsumerImpl();
        ArrayList<Integer> list = new ArrayList<>();
        consumer.accept(list);
        System.out.println(list);

        ArrayList<Integer> result = new ArrayList<>();
        Consumer<ArrayList<Integer>> c = (value) -> {
            for(int i = 0; i < 10; i++) {
                value.add(i + 1);
            }
        };
        consumer.accept(result);
        System.out.println(result);

        SupplierImpl supplier = new SupplierImpl();
        System.out.println(supplier.get());

        Supplier<String> s = () -> "Supplied";
        System.out.println(s.get());

        BiConsumerImpl biConsumer = new BiConsumerImpl();
        ArrayList<Integer> addElement = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            biConsumer.accept(addElement, i + 1);
        }
        System.out.println(addElement);

        ArrayList<Integer> addElement1 = new ArrayList<>();
        BiConsumer<ArrayList<Integer>, Integer> biConsumer1 =
                (container, element) -> {
                        container.add(element);
                };
        for(int i = 0; i < 10; i++) {
            biConsumer1.accept(addElement1, i + 1);
        }

        System.out.println(addElement1);

        BiFunctionImpl biFunction = new BiFunctionImpl();
        System.out.println(biFunction.apply(1, 2));

        BiFunction<ArrayList<Integer>, ArrayList<Integer>, ArrayList<Integer>> biFunction1 =
                (list1, list2) -> {
                    ArrayList<Integer> combinedList = new ArrayList<>();
                    combinedList.addAll(list1);
                    combinedList.addAll(list2);
                    return combinedList;
                };
        System.out.println(biFunction1.apply(addElement, addElement1));

        BinaryOperatorImpl binaryOperator = new BinaryOperatorImpl();
        System.out.println(binaryOperator.apply(1, 2));

        BinaryOperator<Integer> binaryOperator1 = (num1, num2) -> num1 > num2 ? num1 : num2;
        System.out.println(binaryOperator1.apply(45, 26));

        ToIntFunctionImpl toIntFunction = new ToIntFunctionImpl();
        int count = toIntFunction.applyAsInt("Praveen");

        UnaryOperatorImpl unaryOperator = new UnaryOperatorImpl();
        System.out.println(unaryOperator.apply("Praveen"));
    }
}