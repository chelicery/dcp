import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import problems.Dcp4;

import java.util.stream.Stream;

class Dcp4Test {

    private static Stream<Arguments> getArraysAndExpectedInt() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, -1, 1, 2 , 3, 4, 5, 6, 8}, 7),
                Arguments.of(new int[]{44, 3, 2, -1, 2 , 3, 4, 5, 6, 8}, 1),
                Arguments.of(new int[]{-4, -8, -2, -1}, 1),
                Arguments.of(new int[]{}, 1),
                Arguments.of(new int[]{99999214, 321312311, 123312122, -1, 213312, 213,31231, 1}, 2),
                Arguments.of(new int[]{-1, -3, 0, 1, 2, 5, 6, 8}, 3));
    }

    @ParameterizedTest
    @MethodSource("getArraysAndExpectedInt")
    void findLowestMissingIntegerTest(int[] arr, int expected) {

        Assertions.assertThat(Dcp4.findLowestMissingInt(arr)).isEqualTo(expected);

    }


}
