package com.mustafakoroglu.springwithdesignpatterns.behavioral.strategy.calculator;

import com.mustafakoroglu.springwithdesignpatterns.behavioral.strategy.CalculatorOperation;
import com.mustafakoroglu.springwithdesignpatterns.behavioral.strategy.Operation;
import org.springframework.stereotype.Service;

/**
 * @author Mustafa Köroğlu
 */
@Service
@CalculatorOperation(Operation.MULTIPLY)
public final class Multiplication implements Calculator {

  @Override
  public double calculate(final double a, final double b) {
    return a * b;
  }
}
