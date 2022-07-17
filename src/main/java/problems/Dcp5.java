package problems;
/*
cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair.
For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair

Implement car and cdr.
 */

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Dcp5 {

    @Getter
    @RequiredArgsConstructor
    public static class Cons{

        private final int a;
        private final int b;

    }

    public int car(Cons c){
        return c.getA();
    }

    public int cdr(Cons c){
        return c.getB();
    }

}
