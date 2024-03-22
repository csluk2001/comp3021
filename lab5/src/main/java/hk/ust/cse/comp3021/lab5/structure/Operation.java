package hk.ust.cse.comp3021.lab5.structure;

import java.util.List;


/**
 * TODO implement this class as needed.
 * Operation should implement {@link Expression}.
 * Operation consists of {@link Operator} and a list of {@link Expression} as its operands.
 */


public class Operation implements Expression {
    private Operator operator;
    private List<Expression> operands;

    public Operation(Operator operator, List<Expression> operands) {
        this.operator = operator;
        this.operands = operands;
    }

    @Override
    public Value eval() {
        return operator.operate(operands);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("(");
        sb.append(operator.symbol());
        sb.append(" ");

        for (int i = 0; i < operands.size(); i++) {
            sb.append(operands.get(i).toString());
            if (i != operands.size() - 1) {
                sb.append(" ");
            }
        }

        sb.append(")");

        return sb.toString();
    }
}