package dev.entringer.operator;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Compound {

    public static void main( String[] args )
    {
        System.out.println(new Compound().compoundOperators());

    }

    public String compoundOperators() {
        int camel = 2;
        int giraffe = 3;

        camel += ++giraffe;

        return  String.valueOf(camel);
    }

}
