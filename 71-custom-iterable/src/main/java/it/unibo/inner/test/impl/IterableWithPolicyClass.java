package it.unibo.inner.test.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyClass<T> implements IterableWithPolicy<T> {
    
    private final T[] elements;

    /**
     * @param elements
     * @param elem
     */
    public IterableWithPolicyClass(T[] elem) {
        this.elements = elem;
    }

    /*
     * {@inheritDoc}
     */
    public void setIterationPolicy(Predicate<T> filter) {
    
    }

    /*
     * {@inheritDoc}
     */
    public Iterator<T> iterator() {
        return new Iter();
    }

    public String toString() {
        return Arrays.toString(elements);
    }

    class Iter implements Iterator<T> {

        private int currentIndex;

        /*
         * {@inheritDoc}
         */
        public boolean hasNext() {
            while(currentIndex < elements.length) {
                currentIndex++;
                return true;
            }
            return false;
        }

        /*
         * {@inheritDoc}
         */
        public T next() {
            while(this.hasNext()) {
                return elements[currentIndex++];
            }
            throw new NoSuchElementException();
        }
    }
}