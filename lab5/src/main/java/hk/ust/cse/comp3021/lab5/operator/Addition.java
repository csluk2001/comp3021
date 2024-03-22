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
 * Addition should implement {@link Operator}, and will be used to construct {@link Operation} objects.
 * All operands are instances of {@link IntNumber}.
 */
public class Addition implements Operator {
    @Override
    public Value operate(List<Expression> operands) {
        BigInteger sum = BigInteger.ZERO;
        for (Expression operand : operands) {
            if (operand instanceof IntNumber intNumber) {
                sum = sum.add(intNumber.getVal());
            }
        }
        return new IntNumber(sum);
    }

    @Override
    public String symbol() {
        return "+";
    }
}
