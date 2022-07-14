package problems;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Dcp1 {

    public static boolean isAnyPairSumUpTo(int[] arr, int k) {

        for(int i : arr){
            if (Arrays.stream(arr).anyMatch(n->(i+n)==k)) return true;
        }

        return false;
    }
}
