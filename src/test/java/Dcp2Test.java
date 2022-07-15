import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import problems.Dcp2;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Dcp2Test {

    public static Stream<Arguments> getDecodedArrays() {
        return Stream.of(
                Arguments.of(new Dcp2(new int[]{1, 2, 3, 4, 5}).getEncodedArray(), new int[]{120, 60, 40, 30, 24}),
                Arguments.of(new Dcp2(new int[]{}).getEncodedArray(), new int[]{}),
                Arguments.of(new Dcp2(new int[]{-1, -2, -3, -4}).getEncodedArray(), new int[]{-24, -12, -8, -6}),
                Arguments.of(new Dcp2(new int[]{0, 2, 3, 4, 5}).getEncodedArray(), new int[]{120, 0, 0, 0, 0}),
                Arguments.of(new Dcp2(new int[]{1, 2, 3, 4, 5, -1}).getEncodedArray(), new int[]{-120, -60, -40, -30, -24, 120}));

    }

    @ParameterizedTest
    @MethodSource("getDecodedArrays")
    void isArrayEncodedProperly(int[] arr, int[] expect ){
        assertArrayEquals(expect, arr);
    }

}
