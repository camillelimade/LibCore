# _*LibCore* - Sua biblioteca virtual_

Sistema simples de empréstimo de livros em Java, desenvolvido para aplicar os principais conceitos de Programação Orientada a Objetos (POO), tratamento de exceções e organização de código em pacotes.

---

## Objetivo do Projeto

Desenvolver um mini sistema de biblioteca em console que simula o fluxo de listagem, empréstimo e devolução de livros, aplicando boas práticas de POO e estruturação de projetos em Java.

---

## Conceitos Aplicados

- Encapsulamento
- Herança
- Polimorfismo
- Tratamento de Exceções Personalizadas
- Organização em Pacotes (estrutura inspirada em MVC)

---

## Funcionalidades
- Cadastrar livros
- Excluir livros
- Listar livros disponíveis
- Realizar empréstimo de livros
- Lançar exceção caso o livro não esteja disponível
- Realizar devolução de livros
- Diferenciação de usuários:
    - Aluno
    - Professor


---

## Estrutura do Projeto

```text
model        → classes Livro, Usuario, Aluno, Professor  
service      → lógica de empréstimo e devolução (BibliotecaService)  
exceptions   → LivroIndisponivelException  
app          → guarda classe principal com método main()
```

---
## Tecnologias
- Java
- Programação Orientada a Objetos (POO)
- Console (CLI)
