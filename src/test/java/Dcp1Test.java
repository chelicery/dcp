import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import problems.Dcp1;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dcp1Test {

    public static Stream<Arguments> getArraysAndKs() {
        return Stream.of(
                Arguments.of(new int[] {10, 15, 3, 7}, 17, true),
                Arguments.of(new int[] {1, 13, 2, 7}, 3, true),
                Arguments.of(new int[] {0, 15, 3, 7}, 1, false),
                Arguments.of(new int[] {0, 7}, 2, false),
                Arguments.of(new int[] {0, 0}, 0, true),
                Arguments.of(new int[] {1, 1, 1, 1, 1}, 3, false),
                Arguments.of(new int[] {-1, 2, 5, 9, 0}, 8, true),
                Arguments.of(new int[] {}, 8, false),
                Arguments.of(new int[] {3, 1, 2, 99, -1}, 100, true));
    }

    @ParameterizedTest
    @MethodSource("getArraysAndKs")
    void isSumUpToK(int[] arr, int k, boolean expect){
        assertEquals(expect, Dcp1.isAnyPairSumUpTo(arr, k));
    }

}
