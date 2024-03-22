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
 * Multiplication should implement {@link Operator}, and will be used to construct {@link Operation} objects.
 * All operands are instances of {@link IntNumber}.
 * Hint: Use the constant BigInteger.ONE and the method BigInteger.multiply(BigInteger) to implement the eval method
 */
public class Multiplication implements Operator {
    @Override
    public Value operate(List<Expression> operands) {
        BigInteger result = BigInteger.ONE;
        for (Expression operand : operands) {
            if (operand instanceof IntNumber) {
                IntNumber intNumber = (IntNumber) operand;
                result = result.multiply(intNumber.getVal());
            } else {
                throw new IllegalArgumentException("All operands of Multiplication must be IntNumber");
            }
        }
        return new IntNumber(result);
    }

    @Override
    public String symbol() {
        return "*";
    }
}
