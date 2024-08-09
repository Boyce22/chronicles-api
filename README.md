# Chronicles - API 📚

### Sua porta de entrada para os mundos criativos dos pequenos autores, conectando suas histórias ao universo digital com simplicidade e eficiência..

## Funcionalidades

1. **Cadastro de Autor:**
  - Os autores podem enviar seus trabalhos autorais, no formato de PDF, que serão associados a eles.
  Cadastro de Leitor:
  - Os leitores terão acesso aos trabalhos disponíveis na aplicação.
  - É possível alterar o cadastro de leitor para autor, se necessário, mediante informação do CPF.
  
2. **Serviço para upload de arquivos PDF:**
  - Autores podem enviar seus PDFs, atualmente com suporte para até 128MB.
  - As páginas de conteúdo serão contabilizadas, atualmente sem limite definido.

3. **Cadastro da Obra:**
  - Existe uma padronização nas categorias que podem estar associadas à obra, como Romance, Ação e Aventura.
  - Não há limites definidos para o número de categorias.
  - Obras com conteúdo para público maduro receberão uma tag, permitindo acesso somente a maiores de 18 anos.

4. **Busca por Autor:**
  - Os autores podem ser encontrados através de sua referência, como @Autor.
  
5. **Sistema de Comentários:**
  - Os usuários podem deixar comentários sobre obras específicas, facilitando discussões e interações entre os leitores e os autores.
  - Os comentários são uma forma de compartilhar opiniões, críticas construtivas e insights sobre as obras.

## Tecnologias

- [Java 21](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) - A versão mais recente da linguagem de programação Java, proporcionando recursos avançados e melhorias de desempenho.

- [Spring Framework](https://spring.io/) - Um framework de desenvolvimento para Java que oferece suporte abrangente para o desenvolvimento de aplicativos empresariais modernos.

- [PostgreSQL](https://www.postgresql.org/) - Um sistema de gerenciamento de banco de dados relacional de código aberto, conhecido por sua confiabilidade e recursos avançados.

- [Maven](https://maven.apache.org/) - Uma ferramenta de automação de construção e gerenciamento de dependências amplamente utilizada para projetos Java. O Maven simplifica o processo de construção e gerenciamento de projetos, facilitando a integração de bibliotecas e o gerenciamento de dependências.


## Dependências

| Dependências | Link |
| ------ | ------ |
| Lombok | [https://projectlombok.org/setup/maven] |
| PostgreSQL | [https://mvnrepository.com/artifact/org.postgresql/postgresql] |
| Spring Validation | [https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation]|


## Instalação

### Configurações do Banco de Dados:

1. Abra o arquivo `application.properties`.
2. Modifique as seguintes propriedades com as informações do seu PostgreSQL:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/chronicles
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```
3. Certifique-se de que o driver PostgreSQL está corretamente configurado:
    ```properties
    spring.datasource.driverClassName=org.postgresql.Driver
    ```
4. Certifique-se de que o driver PostgreSQL está corretamente configurado:
    ```properties
    spring.datasource.driverClassName=org.postgresql.Driver
    ```
5. Configure o Hibernate para atualizar automaticamente o esquema do banco de dados:
    ```properties
    spring.jpa.hibernate.ddl-auto=update
    ```
6. Defina o dialeto do Hibernate para PostgreSQL:
    ```properties
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```
 ## Inicie o Chronicles API:
 
- Após configurar as propriedades, você está pronto para iniciar o  Chronicles API em seu ambiente local.
Certifique-se de substituir seu_usuario e sua_senha pelas credenciais corretas do seu PostgreSQL. Este é um guia básico para configurar o ambiente. Certifique-se de adaptar as configurações conforme necessário para o seu ambiente específico.
