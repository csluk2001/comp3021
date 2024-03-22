package hk.ust.cse.comp3021.lab5.structure;

/**
 * This interface should extend {@link Expression} because a value is also a kind of expression in our calculator.
 */
public interface Value extends Expression {
    @Override
    default Value eval() {
        return this;
    }

    @Override
    String toString();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
}
