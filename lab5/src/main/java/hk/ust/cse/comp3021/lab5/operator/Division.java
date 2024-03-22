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
 * Division should implement {@link Operator}, and will be used to construct {@link Operation} objects.
 * All operands are instances of {@link IntNumber}.
 * Note: if there is only one operand, return 1 / the operand (integer division).
 * Otherwise, divide the first operand by the rest of operands.
 */

public class Division implements Operator {
    @Override
    public Value operate(List<Expression> operands) {
        if (operands.size() == 1) {
            Expression firstOperand = operands.get(0);
            if (firstOperand instanceof IntNumber) {
                IntNumber intNumber = (IntNumber) firstOperand;
                BigInteger result = BigInteger.ONE.divide(intNumber.getVal());
                return new IntNumber(result);
            }
        } else if (operands.size() > 1) {
            Expression firstOperand = operands.get(0);
            if (firstOperand instanceof IntNumber) {
                IntNumber intNumber = (IntNumber) firstOperand;
                BigInteger result = intNumber.getVal();

                for (int i = 1; i < operands.size(); i++) {
                    Expression operand = operands.get(i);
                    if (operand instanceof IntNumber) {
                        IntNumber nextNumber = (IntNumber) operand;
                        result = result.divide(nextNumber.getVal());
                    }
                }
                return new IntNumber(result);
            }
        }
        return null;
    }

    @Override
    public String symbol() {
        return "/";
    }
}