package com.unicesumar.biblioteca.controller;

import com.unicesumar.biblioteca.model.Livro;
import com.unicesumar.biblioteca.model.LivroDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/LivroServlet")
public class LivroServlet extends HttpServlet {
    private LivroDAO livroDAO = new LivroDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if (acao != null) {
            switch (acao) {
                case "cadastrar":
                    cadastrarLivro(request, response);
                    break;
                case "excluir":
                    excluirLivro(request, response);
                    break;
                default:
                    response.sendRedirect("index.xhtml"); // Redireciona para a página inicial JSF
                    break;
            }
        } else {
            response.sendRedirect("index.xhtml"); // Redireciona para a página inicial JSF
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if (acao != null && acao.equals("listar")) {
            listarLivros(request, response);
        } else {
            response.sendRedirect("index.xhtml"); // Redireciona para a página inicial JSF
        }
    }

    private void cadastrarLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String anoPublicacaoStr = request.getParameter("anoPublicacao");
        String isbn = request.getParameter("isbn");

        if (titulo == null || titulo.isEmpty() || autor == null || autor.isEmpty() || anoPublicacaoStr == null || anoPublicacaoStr.isEmpty() || isbn == null || isbn.isEmpty()) {
            request.setAttribute("mensagemErro", "Todos os campos são obrigatórios.");
            request.getRequestDispatcher("cadastro.xhtml").forward(request, response);
            return;
        }

        int anoPublicacao;
        try {
            anoPublicacao = Integer.parseInt(anoPublicacaoStr);
        } catch (NumberFormatException e) {
            request.setAttribute("mensagemErro", "Ano de Publicação deve ser um número válido.");
            request.getRequestDispatcher("cadastro.xhtml").forward(request, response);
            return;
        }

        if (livroDAO.buscarLivroPorIsbn(isbn) != null) {
            request.setAttribute("mensagemErro", "ISBN já cadastrado.");
            request.getRequestDispatcher("cadastro.xhtml").forward(request, response);
            return;
        }
        
        if (!validarISBN(isbn)) {
            request.setAttribute("mensagemErro", "ISBN inválido. Use o formato 10 ou 13 dígitos.");
            request.setAttribute("titulo", titulo);
            request.setAttribute("autor", autor);
            request.setAttribute("anoPublicacao", anoPublicacaoStr);
            request.setAttribute("isbn", isbn);
            request.getRequestDispatcher("cadastro.xhtml").forward(request, response);
            return;
        }

        Livro livro = new Livro(titulo, autor, anoPublicacao, isbn);
        livroDAO.adicionarLivro(livro);

        request.setAttribute("mensagemSucesso", "Livro cadastrado com sucesso!");
        listarLivros(request, response);
    }

    private void listarLivros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Livro> livros = livroDAO.listarLivros();
        request.setAttribute("livros", livros);
        request.getRequestDispatcher("listagem.xhtml").forward(request, response);
    }

    private void excluirLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");

        if (isbn == null || isbn.isEmpty()) {
            request.setAttribute("mensagemErro", "ISBN para exclusão é obrigatório.");
            listarLivros(request, response);
            return;
        }

        if (livroDAO.buscarLivroPorIsbn(isbn) == null) {
            request.setAttribute("mensagemErro", "Livro com ISBN " + isbn + " não encontrado.");
            listarLivros(request, response);
            return;
        }

        livroDAO.removerLivro(isbn);
        request.setAttribute("mensagemSucesso", "Livro excluído com sucesso!");
        listarLivros(request, response);
    }
    
    private boolean validarISBN(String isbn) {
        String cleanIsbn = isbn.replaceAll("[^0-9]", "");
        return cleanIsbn.length() == 10 || cleanIsbn.length() == 13;
    }
}

