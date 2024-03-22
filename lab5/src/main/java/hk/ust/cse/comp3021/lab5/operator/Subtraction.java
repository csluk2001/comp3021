package hk.ust.cse.comp3021.lab5.operator;

import hk.ust.cse.comp3021.lab5.structure.Expression;
import hk.ust.cse.comp3021.lab5.structure.Operation;
import hk.ust.cse.comp3021.lab5.structure.Operator;
import hk.ust.cse.comp3021.lab5.structure.Value;
import hk.ust.cse.comp3021.lab5.value.IntNumber;

import java.math.BigInteger;
import java.util.List;

/**
 * TODO implement this class as needed.
 * Subtraction should implement {@link Operator}, and will be used to construct {@link Operation} objects.
 * All operands are instances of {@link IntNumber}.
 * Hint: BigInteger.subtract(BigInteger) are useful for implementing eval()
 * Note: If the number of operands is 1, return the negation. Otherwise, subtract the rest of the operands from
 * the first operand
 */

public class Subtraction implements Operator {
    @Override
    public Value operate(List<Expression> operands) {
        if (operands.size() == 1) {
            IntNumber operand = (IntNumber) operands.get(0);
            BigInteger result = operand.getVal().negate();
            return new IntNumber(result);
        } else {
            IntNumber firstOperand = (IntNumber) operands.get(0);
            BigInteger result = firstOperand.getVal();

            for (int i = 1; i < operands.size(); i++) {
                IntNumber operand = (IntNumber) operands.get(i);
                result = result.subtract(operand.getVal());
            }

            return new IntNumber(result);
        }
    }

    @Override
    public String symbol() {
        return "-";
    }
}
