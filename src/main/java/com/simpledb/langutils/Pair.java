package com.simpledb.langutils;

import java.util.Objects;

/**
 * A very simple container to hold a pair of values (which could be of different types).
 *
 * @param <U> type of the first value
 * @param <V> type of the second value
 * @author Abhinav Tripathi
 */
public class Pair<U, V> {

    private U first;
    private V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return first.equals(pair.first) &&
                second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

}