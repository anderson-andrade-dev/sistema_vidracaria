# Software de Vidraçaria

Este é um projeto de software de gestão para uma vidraçaria, desenvolvido em Java com Spring Boot e Thymeleaf, utilizando MySQL como banco de dados.

## Funcionalidades

- Cadastro de clientes
- Gestão de produtos e serviços
- Orçamentos e pedidos
- Controle de estoque
- Relatórios de vendas e financeiros

## Requisitos do Sistema

- Java 11
- Maven 3.x
- MySQL 8.x

## Configuração do Banco de Dados

1. Instale o MySQL Server (se ainda não estiver instalado).
2. Crie um banco de dados chamado `vidracaria`.
3. Configure as credenciais de acesso no arquivo `application.properties`.

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/vidracaria
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

## Como Executar

1. Clone este repositório.
   ```bash
   git clone https://github.com/seu_usuario/vidracaria.git
   ```

2. Navegue até o diretório do projeto.
   ```bash
   cd vidracaria
   ```

3. Compile o projeto.
   ```bash
   mvn clean package
   ```

4. Execute o projeto.
   ```bash
   java -jar target/vidracaria-0.0.1-SNAPSHOT.jar
   ```

5. Acesse a aplicação no seu navegador.
   ```
   http://localhost:8080
   ```

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests para correções ou melhorias.

## Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT) - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

Para mais informações, entre em contato via email: andersonandradedev@outlook.com

---

#Sistema não esta finalizado!
 
