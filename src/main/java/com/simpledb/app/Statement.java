package com.simpledb.app;

import java.util.Objects;

/**
 * A container for a prepared statement.
 *
 * @author Abhinav Tripathi
 */
public class Statement {

    public enum StatementType {
        STATEMENT_INSERT, STATEMENT_SELECT
    }

    private StatementType type;

    public Statement(StatementType type) {
        this.type = type;
    }

    public StatementType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return type == statement.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Statement{" +
                "type=" + type +
                '}';
    }

}
