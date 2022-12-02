package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        //  throw new UnsupportedOperationException("You should implement this method.");
        return strings -> {
            for (String text:strings) {
                if(!Character.isUpperCase(text.charAt(0))){
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return numbers -> {
            List<Integer> result = new ArrayList<>();
            for (Integer number: numbers) {
                if (number%2 == 0){
                    result.add(number);
                }
            }
            numbers.addAll(result);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            for (String value: values) {
                int size = value.split(" ").length;
                boolean isUpperCase = Character.isUpperCase(value.charAt(0));

                 if( value.split(" ").length > 3 && Character.isUpperCase(value.charAt(0)) && value.charAt(value.length() - 1) == '.'){
                     result.add(value);
                 }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> result = new HashMap<>();
            for (String text : list) {
                result.put(text, text.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>(list1);
            result.addAll(list2);
            return result;
        };
    }
}
