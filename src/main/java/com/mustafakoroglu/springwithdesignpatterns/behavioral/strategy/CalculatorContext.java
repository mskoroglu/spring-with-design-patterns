package com.mustafakoroglu.springwithdesignpatterns.behavioral.strategy;

import com.mustafakoroglu.springwithdesignpatterns.behavioral.strategy.calculator.Calculator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * @author Mustafa Köroğlu
 */
@Service
public final class CalculatorContext {

  private final Map<Operation, Calculator> calculatorMap = new EnumMap<>(
    Operation.class
  );

  public CalculatorContext(final List<Calculator> calculators) {
    for (final var calculator : calculators) {
      final var operation = calculator
        .getClass()
        .getAnnotation(CalculatorOperation.class)
        .value();
      calculatorMap.put(operation, calculator);
    }
  }

  public double calculate(
    final Operation operation,
    final double a,
    final double b
  ) {
    final var calculator = calculatorMap.get(operation);
    return calculator.calculate(a, b);
  }
}
