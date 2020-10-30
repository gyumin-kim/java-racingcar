package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = "3 + 5 / 2 * 5 + 10 - 5")
    public void calculate(String inputData) {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(inputData);
        assertThat(result).isEqualTo(25);
    }

    @DisplayName("단일 계산 사칙연산 테스트")
    @ParameterizedTest
    @CsvSource(value = "10, 2")
    public void eachOperatorTest(int first, int second) {

        assertThat(Operator.PLUS.calculate(first, second)).isEqualTo(first + second);

        assertThat(Operator.MINUS.calculate(first, second)).isEqualTo(first - second);

        assertThat(Operator.MULTIPLE.calculate(first, second)).isEqualTo(first * second);

        assertThat(Operator.DIVIDE.calculate(first, second)).isEqualTo(first / second);

    }








}