package problems;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.util.Arrays;
import java.util.stream.IntStream;

/*
Given an array of integers, find the first missing positive integer in linear time and constant space.
In other words, find the lowest positive integer that does not exist in the array.
The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Dcp4 {

    public static int findLowestMissingInt(int[] integers) {

        IntStream k = Arrays.stream(integers)
                .filter(s -> s >= 0)  //O(n)
                .distinct()          //O(n)
                .sorted();          //Timsort:  best: O(n) | worst: O(n log n)

        return getMissingInDistance(k);
    }

    private static int getMissingInDistance(IntStream stream) {
        int[] s = stream.toArray();
        if(s.length <= 0) return 1; //Technically, this is the only positive integer
        //that is not in the array  ¯\_(ツ)_/¯
        for (int i = 0; i < s.length; i++) { //O(n)

            if (((s[i] >= 0) && s[0] > 1 )) return s[i] - 1;

            if (i + 1 < s.length && distanceIsBiggerThanOne(s[i], s[i + 1])) {
                return s[i] + 1;
            }
        }
        return -1;
    }

    private static boolean distanceIsBiggerThanOne(int first, int second) {
        return Math.abs(first - second) > 1;
    }

}