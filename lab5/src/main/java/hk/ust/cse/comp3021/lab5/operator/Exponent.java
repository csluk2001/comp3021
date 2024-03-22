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
 * Exponent should implement {@link Operator}, and will be used to construct {@link Operation} objects.
 * All operands are instances of {@link IntNumber}.
 * Hint: BigInteger.pow(int)
 */

public class Exponent implements Operator {
    @Override
    public Value operate(List<Expression> operands) {
        if (operands.size() == 2) {
            Expression base = operands.get(0);
            Expression exponent = operands.get(1);

            if (base instanceof IntNumber && exponent instanceof IntNumber) {
                IntNumber baseNumber = (IntNumber) base;
                IntNumber exponentNumber = (IntNumber) exponent;

                BigInteger result = baseNumber.getVal().pow(exponentNumber.getVal().intValue());
                return new IntNumber(result);
            } else {
                throw new IllegalArgumentException("Operands of Exponent must be IntNumber");
            }
        } else {
            throw new IllegalArgumentException("Exponent requires exactly two operands");
        }
    }

    @Override
    public String symbol() {
        return "^";
    }
}