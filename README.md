
# Verbalia

Verbalia é uma aplicação Java/Spring Boot que consome a API pública Gutendex para buscar e armazenar informações de livros e autores. O projeto integra dados de uma API externa com persistência local em banco PostgreSQL, e oferece um menu interativo para consulta e gerenciamento dos dados.


## Funcionalidades

• Buscar livros por título via API Gutendex e salvar no banco local

• Listar todos os livros cadastrados

• Listar todos os autores cadastrados

• Listar autores vivos em um ano específico

• Listar livros filtrados por idioma

• Exclusão de livros

• Persistência dos dados utilizando Spring Data JPA e PostgreSQL
## Tecnologias Utilizadas

• Java 17+

• Spring Boot

• Spring Data JPA

• Hibernate

• PostgreSQL

• RestTemplate (para consumo da API Gutendex)

• Maven
## Próximos passos

• Melhorar tratamento de erros e input do usuário

• Adicionar testes unitários e de integração

• Refatorar para utilizar WebClient no lugar de RestTemplate

• Implementar interface web para melhorar usabilidade
