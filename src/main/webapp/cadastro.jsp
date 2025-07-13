<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Livros - Sistema Biblioteca UniCesumar</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            background: white;
            border-radius: 20px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

        .header {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 30px;
            text-align: center;
        }

        .header h1 {
            font-size: 24px;
            margin-bottom: 5px;
        }

        .header p {
            opacity: 0.9;
        }

        .form-container {
            padding: 40px;
        }

        .form-group {
            margin-bottom: 25px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #333;
        }

        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 12px 15px;
            border: 2px solid #e9ecef;
            border-radius: 10px;
            font-size: 16px;
            transition: border-color 0.3s ease;
        }

        input[type="text"]:focus, input[type="number"]:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
        }

        .btn {
            padding: 12px 30px;
            border: none;
            border-radius: 10px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            text-decoration: none;
            display: inline-block;
            margin-right: 10px;
        }

        .btn-primary {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }

        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 20px rgba(102, 126, 234, 0.3);
        }

        .btn-secondary {
            background: #f8f9fa;
            color: #333;
            border: 2px solid #e9ecef;
        }

        .btn-secondary:hover {
            background: #e9ecef;
        }

        .alert {
            padding: 15px;
            border-radius: 10px;
            margin-bottom: 20px;
        }

        .alert-error {
            background: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }

        .alert-success {
            background: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }

        .form-actions {
            display: flex;
            gap: 10px;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>📚 Cadastro de Livros</h1>
            <p>Adicione novos livros ao acervo da biblioteca</p>
        </div>
        
        <div class="form-container">
            <% if (request.getAttribute("mensagemErro") != null) { %>
                <div class="alert alert-error">
                    <%= request.getAttribute("mensagemErro") %>
                </div>
            <% } %>
            
            <% if (request.getAttribute("mensagemSucesso") != null) { %>
                <div class="alert alert-success">
                    <%= request.getAttribute("mensagemSucesso") %>
                </div>
            <% } %>
            
            <form action="LivroServlet" method="post">
                <input type="hidden" name="acao" value="cadastrar">
                
                <div class="form-group">
                    <label for="titulo">Título do Livro:</label>
                    <input type="text" id="titulo" name="titulo" required>
                </div>
                
                <div class="form-group">
                    <label for="autor">Autor:</label>
                    <input type="text" id="autor" name="autor" required>
                </div>
                
                <div class="form-group">
                    <label for="anoPublicacao">Ano de Publicação:</label>
                    <input type="number" id="anoPublicacao" name="anoPublicacao" min="1000" max="2024" required>
                </div>
                
                <div class="form-group">
                    <label for="isbn">ISBN:</label>
                    <input type="text" id="isbn" name="isbn" required>
                </div>
                
                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">Cadastrar Livro</button>
                    <a href="index.jsp" class="btn btn-secondary">Voltar ao Menu</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>

