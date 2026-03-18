package com.mycompany.iteratorbasics;

/**
 * Interfaz iterator personalizada.
 * Extiende java.util.Iterator<Film> para que MyMarvelCollection pueda
 * usar un único método iterator() que sirva tanto para:
 *   - recorrido manual:  while (iterator.hasNext()) { iterator.next(); }
 *   - ciclo for-each:    for (var film : myCol) { ... }
 */
public interface MyIterator extends java.util.Iterator<Film> {

    @Override
    boolean hasNext();

    @Override
    Film next();
}
