# Manual do Usuário - Sistema Biblioteca Cesumar (Versão JSF)

## Introdução

Bem-vindo ao Sistema de Biblioteca da Universidade Cesumar! Esta versão do sistema é focada exclusivamente nas funcionalidades desenvolvidas com JavaServer Faces (JSF), oferecendo uma interface moderna e integrada para o gerenciamento de livros.

## Acessando o Sistema

1.  Abra seu navegador web.
2.  Digite o endereço: `http://localhost:8080/biblioteca-cesumar/`
3.  A página inicial do sistema será exibida.

## Navegação Principal

### Página Inicial (`index.xhtml`)

A página inicial é o ponto de partida do sistema e apresenta as seguintes opções:

-   **Cadastrar Livro**: Permite adicionar novos livros ao acervo da biblioteca.
-   **Listar Livros**: Exibe todos os livros já cadastrados no sistema.

## Cadastrando Livros

### Interface de Cadastro (`cadastro.xhtml`)

1.  Na página inicial, clique em **"Cadastrar Livro"**.
2.  Você será direcionado para o formulário de cadastro de livros.
3.  Preencha todos os campos obrigatórios:
    -   **Título do Livro**: O nome completo da obra.
    -   **Autor**: O nome do autor ou dos autores.
    -   **Ano de Publicação**: O ano em que o livro foi publicado (deve ser um número entre 1000 e 2024).
    -   **ISBN**: O Código Padrão Internacional do Livro (deve ser único no sistema).
4.  Após preencher os dados, clique no botão **"Cadastrar Livro"**.
5.  O sistema validará as informações. Se o cadastro for bem-sucedido, uma mensagem de sucesso será exibida e você será redirecionado para a página de listagem de livros. Caso contrário, mensagens de erro aparecerão indicando o que precisa ser corrigido.

### Validações no Cadastro

O sistema realiza as seguintes validações automaticamente:

-   ✅ Todos os campos (Título, Autor, Ano de Publicação, ISBN) são de preenchimento obrigatório.
-   ✅ O campo "Ano de Publicação" deve conter um número válido dentro do intervalo permitido.
-   ✅ O ISBN informado deve ser único; o sistema não permite o cadastro de livros com ISBNs duplicados.

## Visualizando e Excluindo Livros

### Lista de Livros (`listagem.xhtml`)

1.  Na página inicial, clique em **"Listar Livros"**.
2.  Todos os livros cadastrados serão exibidos em uma tabela organizada, contendo as seguintes informações para cada livro:
    -   Título
    -   Autor
    -   Ano de Publicação
    -   ISBN
    -   Uma coluna de **Ações** com o botão "Excluir".

### Excluindo Livros

1.  Na tabela de listagem, localize o livro que você deseja remover.
2.  Clique no botão **"Excluir"** correspondente ao livro.
3.  Uma caixa de diálogo de confirmação será exibida, perguntando se você realmente deseja excluir o livro.
4.  Clique em **"OK"** para confirmar a exclusão ou **"Cancelar"** para abortar a operação.
5.  Após a confirmação, o livro será removido do acervo e uma mensagem de sucesso será exibida. Se houver algum problema, uma mensagem de erro será mostrada.

### ⚠️ Atenção

A exclusão de um livro é uma ação permanente e não pode ser desfeita. Certifique-se de que está excluindo o livro correto.

## Mensagens do Sistema

O sistema utiliza mensagens visuais para informar o status das operações:

-   **Mensagens de Sucesso (Fundo Verde)**: Indicam que uma operação foi concluída com êxito (ex: "Livro cadastrado com sucesso!").
-   **Mensagens de Erro (Fundo Vermelho)**: Indicam que ocorreu um problema ou que uma validação falhou (ex: "Título é obrigatório.", "ISBN já cadastrado.").

## Dicas de Uso

-   **Navegação**: Utilize os links de navegação (`h:link` e `h:commandButton` com `faces-redirect=true`) para transitar entre as páginas e garantir o funcionamento correto do JSF.
-   **Preenchimento de Campos**: Para o campo ISBN, utilize o código completo do livro. Para o Ano de Publicação, insira apenas o valor numérico.

## Resolução de Problemas

### Problemas Comuns

-   **Página não carrega ou erro 500**: Verifique se o Apache Tomcat está em execução e se o arquivo `.war` foi corretamente implantado e o servidor reiniciado após as últimas alterações.
-   **Mensagens de erro no formulário**: Leia atentamente a mensagem para entender qual campo precisa ser corrigido ou qual validação falhou.

### Suporte Técnico

Em caso de problemas persistentes, entre em contato com a equipe de TI da Universidade Cesumar, fornecendo o máximo de detalhes possível sobre o erro (mensagens exibidas, passos para reproduzir, logs do servidor).

## Conclusão

Este sistema JSF foi projetado para ser uma ferramenta eficiente e fácil de usar para o gerenciamento do acervo da biblioteca. Com as funcionalidades de cadastro, listagem e exclusão, ele oferece um controle robusto e intuitivo sobre os livros.

