package com.mycompany.iteratorbasics;

/**
 * Colección personalizada de objetos Film.
 * - Usa únicamente arrays internos (sin ArrayList, LinkedList, etc.)
 * - Implementa Iterable<Film> para soportar el ciclo for-each
 * - Expone iterator() que retorna un MyIterator para recorrido manual
 *
 * NOTA: existe un conflicto de nombres entre MyIterator (nuestro) e
 * Iterable<Film> (Java), ambos requieren un método iterator().
 * La solución es que MyIterator extienda java.util.Iterator<Film>,
 * así un solo método iterator() satisface ambos contratos.
 */
public class MyMarvelCollection implements Iterable<Film> {

    private Film[] films;
    private int size;

    // ── Constructor ──────────────────────────────────────────────────────────

    // Acepta un array inicial de Films (puede ser null o vacío)
    public MyMarvelCollection(Film[] initialFilms) {
        if (initialFilms != null && initialFilms.length > 0) {
            films = new Film[initialFilms.length + 10];
            for (int i = 0; i < initialFilms.length; i++) {
                films[i] = initialFilms[i];
            }
            size = initialFilms.length;
        } else {
            films = new Film[10];
            size = 0;
        }
    }

    // ── Métodos públicos ─────────────────────────────────────────────────────

    // Agrega un Film; expande el array interno al doble si se llena
    public void add(Film film) {
        if (size == films.length) {
            Film[] expanded = new Film[films.length * 2];
            for (int i = 0; i < films.length; i++) {
                expanded[i] = films[i];
            }
            films = expanded;
        }
        films[size] = film;
        size++;
    }

    // Retorna la cantidad de Films almacenados
    public int size() {
        return size;
    }

    // ── Iterator ─────────────────────────────────────────────────────────────

    // Único método iterator() que satisface tanto el uso manual
    // (while iterator.hasNext()) como el for-each (Iterable<Film>)
    @Override
    public MyIterator iterator() {
        return new MyIterator() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Film next() {
                return films[index++];
            }
        };
    }
}
