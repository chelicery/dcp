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

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.BiFunction;
import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Dcp5 {

    public static <T, U, R> Function<BiFunction<T, U, R>, R> cons(T a, U b) {
        return f -> f.apply(a, b);
    }

    public static <T, U> T car(Function<BiFunction<T, U, T>, T> f){
        return f.apply((a,b) -> a);
    }

    public static <T, U> U cdr(Function<BiFunction<T, U, U>, U> f){
        return f.apply((a,b) -> b);
    }

}