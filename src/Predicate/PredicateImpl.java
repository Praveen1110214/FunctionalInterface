package Predicate;

import java.util.function.Predicate;

public class PredicateImpl implements Predicate<Integer> {

    @Override
    public boolean test(Integer value){
        return  value > 18;
    }
}
