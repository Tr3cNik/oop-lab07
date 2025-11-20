package it.unibo.inner.test.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyClass<T> implements IterableWithPolicy<T> {
    
    private T[] elements;
    private Predicate<T> iterationPolicy;

    /**
     * @param elements
     * @param elem
     */
    public IterableWithPolicyClass(T[] elem, Predicate<T> policy) {
        this.elements = elem;
        this.iterationPolicy = policy;
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
        return new Iter(this.elements);
    }

    class Iter implements Iterator<T> {

        private T[] array;
        private int currentIndex;

        public Iter(T[] array) {
            this.array = array;
            this.currentIndex = 0;
        }

        /*
         * {@inheritDoc}
         */
        public boolean hasNext() {
            for(; currentIndex < this.array.length; currentIndex++) {
                if(iterationPolicy.test(array[currentIndex])) {
                    return true;
                } 
            }
            return false;
        }

        /*
         * {@inheritDoc}
         */
        public T next() {
            while(this.hasNext()) {
                if(iterationPolicy.test(array[currentIndex])) {
                    return this.array[currentIndex++];
                }
            }
            throw new NoSuchElementException();
        }
    }
}