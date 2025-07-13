package com.unicesumar.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class LivroDAO {
    private static List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivros() {
        return new ArrayList<>(livros);
    }

    public void removerLivro(String isbn) {
        Iterator<Livro> iterator = livros.iterator();
        while (iterator.hasNext()) {
            Livro livro = iterator.next();
            if (livro.getIsbn().equals(isbn)) {
                iterator.remove();
                return;
            }
        }
    }

    public Livro buscarLivroPorIsbn(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }
}

