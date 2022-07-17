import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import problems.Dcp5;

public class Dcp5Test {

    @ParameterizedTest
    @CsvSource({"1, 2", "-1, 1", "3, 1212"})
    void carTest(int a, int b){

        Dcp5 p = new Dcp5();

        Assertions.assertThat(p.car(new Dcp5.Cons(a, b))).isEqualTo(a);
    }

    @ParameterizedTest
    @CsvSource({"1, 2", "-1, 1", "3, 1212"})
    void cdrTest(int a, int b){

        Dcp5 p = new Dcp5();

        Assertions.assertThat(p.cdr(new Dcp5.Cons(a, b))).isEqualTo(b);
    }

}
