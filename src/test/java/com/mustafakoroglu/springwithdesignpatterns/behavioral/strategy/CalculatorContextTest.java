package com.mustafakoroglu.springwithdesignpatterns.behavioral.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import com.mustafakoroglu.springwithdesignpatterns.behavioral.strategy.calculator.Addition;
import com.mustafakoroglu.springwithdesignpatterns.behavioral.strategy.calculator.Division;
import com.mustafakoroglu.springwithdesignpatterns.behavioral.strategy.calculator.Multiplication;
import com.mustafakoroglu.springwithdesignpatterns.behavioral.strategy.calculator.Subtraction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Mustafa Köroğlu
 */
@SpringBootTest(
  classes = {
    CalculatorContext.class,
    Addition.class,
    Subtraction.class,
    Multiplication.class,
    Division.class,
  }
)
class CalculatorContextTest {

  @Autowired
  private CalculatorContext calculatorContext;

  @ParameterizedTest
  @CsvSource({ "1,5,6", "-10,2,-8", "-5,-10,-15" })
  void returnsAdditionResult(
    final double a,
    final double b,
    final double expected
  ) {
    final var result = calculatorContext.calculate(Operation.ADD, a, b);
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({ "1,5,-4", "-10,2,-12", "-5,-10,5" })
  void returnsSubtractionResult(
    final double a,
    final double b,
    final double expected
  ) {
    final var result = calculatorContext.calculate(Operation.SUBTRACT, a, b);
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({ "1,5,5", "-10,2,-20", "-5,-10,50" })
  void returnsMultiplicationResult(
    final double a,
    final double b,
    final double expected
  ) {
    final var result = calculatorContext.calculate(Operation.MULTIPLY, a, b);
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({ "1,5,0.2", "-10,2,-5", "-5,-10,0.5" })
  void returnsDivisionResult(
    final double a,
    final double b,
    final double expected
  ) {
    final var result = calculatorContext.calculate(Operation.DIVIDE, a, b);
    assertThat(result).isEqualTo(expected);
  }
}
