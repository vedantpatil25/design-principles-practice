package org.sample;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main (String[] args) {
        System.out.println("Hello World!");

        Optional<String> curr = Optional.ofNullable(null);
        Optional<String> currEmpty = Optional.empty();

        String currString = curr.orElse("default");
        System.out.println(currString);

        curr.map(x -> x.toUpperCase()).orElse("default22");

        Integer i = 2;
        Long i2 = 2L;

        if (currEmpty.isPresent()) {
            System.out.println(curr.get());
        }
        curr.ifPresent(x -> System.out.println(x));

        Predicate<String> isSmall = (String x) -> {
            if (x.length() < 2) {
                return true;
            } else return false;
        };


        System.out.println(isSmall.test("hello"));
        System.out.println(isSmall.test("w"));


        Function<Integer, String> convertToString = (Integer x) -> {
            return String.valueOf(x);
        };
        Object temp = convertToString.apply(11313);
        if (temp instanceof Integer) {
            System.out.println("aklhfgalsdf");
        } else if (temp instanceof String) {
            System.out.println("sdosdkg");
        }

    }
}
