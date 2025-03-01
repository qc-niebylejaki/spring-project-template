package pl.qc.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void shouldAddNumbersCorrectly() {
        assertThat(calculator.add(10, 5)).isEqualTo(15);
        assertThat(calculator.add(-10, 5)).isEqualTo(-5);
        assertThat(calculator.add(0, 0)).isEqualTo(0);
    }

    @Test
    public void shouldSubtractNumbersCorrectly() {
        assertThat(calculator.subtract(10, 5)).isEqualTo(5);
        assertThat(calculator.subtract(-10, 5)).isEqualTo(-15);
        assertThat(calculator.subtract(5, 5)).isEqualTo(0);
    }

    @Test
    public void shouldMultiplyNumbersCorrectly() {
        assertThat(calculator.multiply(10, 5)).isEqualTo(50);
        assertThat(calculator.multiply(-10, 5)).isEqualTo(-50);
        assertThat(calculator.multiply(0, 5)).isEqualTo(0);
    }

    @Test
    public void shouldDivideNumbersCorrectly() {
        assertThat(calculator.divide(10, 5)).isEqualTo(2);
        assertThat(calculator.divide(-10, 5)).isEqualTo(-2);
        assertThat(calculator.divide(0, 5)).isEqualTo(0);

        // Testing division by zero - should throw an exception
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.divide(10, 0))
                .withMessage("Cannot divide by zero");
    }
}
