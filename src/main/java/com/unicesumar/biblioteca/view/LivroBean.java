package com.unicesumar.biblioteca.view;

import com.unicesumar.biblioteca.model.Livro;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "livroBean")
@RequestScoped
public class LivroBean {
    private Livro livro = new Livro();
    private String isbnParaExcluir;

    // Getters e Setters
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getIsbnParaExcluir() {
        return isbnParaExcluir;
    }

    public void setIsbnParaExcluir(String isbnParaExcluir) {
        this.isbnParaExcluir = isbnParaExcluir;
    }
}