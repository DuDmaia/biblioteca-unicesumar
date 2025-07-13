# Sistema Web - Biblioteca Universidade UniCesumar

## Descrição do Projeto

Este é um sistema web desenvolvido em Java para modernização dos serviços da Biblioteca da UniCesumar. O sistema permite aos funcionários realizarem o cadastro, listagem e exclusão de livros no acervo interno, substituindo o controle manual em planilhas por uma solução web moderna e funcional.

## Tecnologias Utilizadas

- **Java 8+** - Linguagem de programação principal
- **Servlets** - Controle de requisições HTTP
- **JSP (JavaServer Pages)** - Interface de usuário dinâmica
- **JSF (JavaServer Faces)** - Framework para interface web
- **Maven** - Gerenciamento de dependências e build
- **HTML5/CSS3** - Estrutura e estilização das páginas
- **JavaScript** - Interatividade no frontend

## Arquitetura do Sistema

O projeto segue o padrão **MVC (Model-View-Controller)**:

### Model (Modelo)
- `Livro.java` - Classe que representa a entidade Livro
- `LivroDAO.java` - Classe de acesso a dados (simulação em memória)

### View (Visão)
- **JSP**: `index.jsp`, `cadastro.jsp`, `listagem.jsp`
- **JSF**: `cadastro.xhtml`, `listagem.xhtml`
- `LivroBean.java` - Managed Bean para JSF

### Controller (Controlador)
- `LivroServlet.java` - Servlet principal para gerenciar requisições

## Funcionalidades

### ✅ Cadastro de Livros
- Formulário para inserção de novos livros
- Campos: Título, Autor, Ano de Publicação, ISBN
- Validação de campos obrigatórios
- Verificação de ISBN duplicado

### ✅ Listagem de Livros
- Exibição de todos os livros cadastrados
- Interface responsiva e organizada
- Disponível em JSP e JSF

### ✅ Exclusão de Livros
- Remoção de livros por ISBN
- Confirmação antes da exclusão
- Feedback visual para o usuário

### ✅ Validações
- Campos obrigatórios
- Formato de ano de publicação
- ISBN único no sistema
- Tratamento de erros

## Estrutura do Projeto

```
biblioteca-unicesumar/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/unicesumar/biblioteca/
│       │       ├── model/
│       │       │   ├── Livro.java
│       │       │   └── LivroDAO.java
│       │       ├── controller/
│       │       │   └── LivroServlet.java
│       │       └── view/
│       │           └── LivroBean.java
│       └── webapp/
│           ├── WEB-INF/
│           │   └── web.xml
│           ├── index.jsp
│           ├── cadastro.jsp
│           ├── listagem.jsp
│           ├── cadastro.xhtml
│           └── listagem.xhtml
├── pom.xml
└── README.md
```

## Como Executar

### Pré-requisitos
- Java 8 ou superior
- Maven 3.6+
- Servidor de aplicação (Tomcat, GlassFish, etc.)

### Passos para Execução

1. **Clone ou baixe o projeto**
   ```bash
   cd biblioteca-unicesumar
   ```

2. **Compile o projeto**
   ```bash
   mvn clean compile
   ```

3. **Gere o arquivo WAR**
   ```bash
   mvn package
   ```

4. **Deploy no servidor**
   - Copie o arquivo `target/biblioteca-unicesumar.war` para o diretório `webapps` do Tomcat
   - Ou faça o deploy através do painel administrativo do servidor

5. **Acesse o sistema**
   ```
   http://localhost:8080/biblioteca-unicesumar/
   ```

## Interfaces Disponíveis

### Menu Principal (`index.jsp`)
- Página inicial com navegação para todas as funcionalidades
- Design moderno e responsivo

### Cadastro JSP (`cadastro.jsp`)
- Formulário de cadastro usando JSP puro
- Validação client-side e server-side

### Listagem JSP (`listagem.jsp`)
- Tabela com todos os livros cadastrados
- Funcionalidade de exclusão integrada

### Cadastro JSF (`cadastro.xhtml`)
- Interface JSF com Managed Bean
- Validação automática do framework

### Listagem JSF (`listagem.xhtml`)
- DataTable JSF para exibição dos dados
- Integração completa com o Managed Bean

## Validações Implementadas

### Campos Obrigatórios
- Título do livro
- Nome do autor
- Ano de publicação
- ISBN

### Validações Específicas
- Ano de publicação: número entre 1000 e 2024
- ISBN: deve ser único no sistema
- Campos não podem estar vazios ou conter apenas espaços

### Tratamento de Erros
- Mensagens de erro claras e específicas
- Feedback visual para o usuário
- Preservação dos dados em caso de erro

## Características Técnicas

### Padrão MVC
- Separação clara entre lógica de negócio, apresentação e controle
- Código organizado e de fácil manutenção
- Reutilização de componentes

### Responsividade
- Interface adaptável para desktop e mobile
- Design moderno com gradientes e animações
- Experiência de usuário otimizada

### Persistência
- Simulação em memória para demonstração
- Estrutura preparada para integração com banco de dados
- DAO pattern implementado

## Melhorias Futuras

- Integração com banco de dados real (MySQL, PostgreSQL)
- Sistema de autenticação e autorização
- Relatórios em PDF
- API REST para integração com outros sistemas
- Busca avançada de livros
- Categorização de livros por gênero
- Sistema de empréstimos

## Autor

Desenvolvido para a UniCesumar como parte do processo de modernização da biblioteca.

## Licença

Este projeto foi desenvolvido para fins educacionais e de modernização institucional.

