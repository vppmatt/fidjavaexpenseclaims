package utils;

import java.util.function.Function;

public class ECProcessor {

    public static String getVersionNumber() {
        return "1.0";
    }

    public void printTotalValueOfClaims() {
        System.out.println("The claims total $0");
    }

    Function<Integer, Integer> increaseAValueBy3 = value -> value * 3;

    private void testing() {
        increaseAValueBy3.apply(12);
    }

    private Integer manipulate(Integer value, Function<Integer,Integer> fn) {
        return fn.apply(value);
    }


}
