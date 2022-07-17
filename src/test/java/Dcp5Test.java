import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import problems.Dcp5;

class Dcp5Test {

    @ParameterizedTest
    @CsvSource({"1, 2", "-1, 1", "3, 1212"})
    void carTest(int a, int b){
         Assertions.assertThat(Dcp5.car(Dcp5.cons(a, b))).isEqualTo(a);
    }

    @ParameterizedTest
    @CsvSource({"1, 2", "-1, 1", "3, 1212"})
    void cdrTest(int a, int b){
        Assertions.assertThat(Dcp5.cdr(Dcp5.cons(a, b))).isEqualTo(b);
    }

}
