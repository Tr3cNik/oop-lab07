package it.unibo.inner.test.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyClass<T> implements IterableWithPolicy<T> {
    
    private final T[] elements;
    private Predicate<T> policyUsed;

    /**
     * @param elements
     * @param elem
     */
    public IterableWithPolicyClass(T[] elem) {
        this(elem, new Predicate<T>() {
            @Override
            public boolean test(T elem) {
                return true;
            }
        });
    }

    public IterableWithPolicyClass(T[] elem, Predicate<T> policy) {
        this.elements = elem;
        this.policyUsed = policy;
    }

    /*
     * {@inheritDoc}
     */
    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.policyUsed = filter;
    }

    /*
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    public String toString() {
        return Arrays.toString(elements);
    }

    class Iter implements Iterator<T> {

        private int currentIndex = 0;

        /*
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            for(T elem: elements) {
                if(policyUsed.test(elem)) {
                    return true;
                }
            }
            return false;
        }

        /*
         * {@inheritDoc}
         */
        @Override
        public T next() {
            while(this.hasNext()) {
                return elements[currentIndex++];
            }
            throw new NoSuchElementException();
        }
    }
}