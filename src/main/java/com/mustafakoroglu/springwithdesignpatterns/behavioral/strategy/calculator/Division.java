package com.mustafakoroglu.springwithdesignpatterns.behavioral.strategy.calculator;

import com.mustafakoroglu.springwithdesignpatterns.behavioral.strategy.CalculatorOperation;
import com.mustafakoroglu.springwithdesignpatterns.behavioral.strategy.Operation;
import org.springframework.stereotype.Service;

/**
 * @author Mustafa Köroğlu
 */
@Service
@CalculatorOperation(Operation.DIVIDE)
public final class Division implements Calculator {

  @Override
  public double calculate(final double a, final double b) {
    return a / b;
  }
}
