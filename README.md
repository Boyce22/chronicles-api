# Chronicles - API

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
  
5. **Sistema de Avaliação de Obras:**
  - Os leitores podem atribuir avaliações às obras, fornecendo feedback valioso para outros usuários.
  - As avaliações ajudam a destacar obras de qualidade e guiar os leitores na escolha de seus próximos livros.
  
6. **Sistema de Comentários:**
  - Os usuários podem deixar comentários sobre obras específicas, facilitando discussões e interações entre os leitores e os autores.
  - Os comentários são uma forma de compartilhar opiniões, críticas construtivas e insights sobre as obras.

7. **Recomendações Personalizadas:**
  - Com base nas preferências de leitura e histórico de interações dos usuários, o sistema pode oferecer recomendações personalizadas de obras que possam interessar a cada usuário.
  - As recomendações ajudam os leitores a descobrir novos autores e gêneros que estejam alinhados com seus gostos e interesses.
   
9. **Notificações:**
 - Os usuários podem optar por receber notificações sobre novos lançamentos, atualizações de obras favoritas, novos comentários ou avaliações em suas obras, entre outros eventos relevantes.
 - As notificações mantêm os usuários engajados e informados sobre as atividades e novidades na plataforma.

## Arquitetura e Princípios de Desenvolvimento

### Padrão Spring MVC

#### O padrão Spring MVC (Model-View-Controller) é uma arquitetura de software utilizada no desenvolvimento de aplicativos web em Java. Ele separa as preocupações do aplicativo em três componentes principais:

- Modelo (Model): Definir classes de modelo para representar os dados da aplicação, juntamente com as camadas de acesso a dados (por exemplo, DAOs ou repositórios) para interagir com o banco de dados.

```java
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "author_cd_id")
  private Long id;
  
  @Column(name = "author_tx_name")
  private String name;
  
  @Column(name = "author_tx_lastName")
  private String lastName;

}
```
- Controlador (Controller): Implementar controladores para lidar com as solicitações do usuário, processar os dados, chamar métodos de serviço e determinar qual visão deve ser retornada.

```java
@GetMapping("/findAll")
public ResponseEntity<List<AuthorDetailsDTO>> findAll() {
  List<AuthorDetailsDTO> authors = authorService.findAll();
  return authors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(authors);
}
```
- Service Layer: É uma camada adicional que encapsula a lógica de negócios da aplicação
```java

@Service
public class FileService {

  public FileWork save(MultipartFile file) throws IOException {
    return fileRepository.save(new FileWork().create(file, countNumberChapters(file)));
  }
  
  private Integer countNumberChapters(MultipartFile file) throws IOException {
    PdfReader reader = new PdfReader(file.getInputStream());
    return reader.getNumberOfPages();
  }

}

```

### Clean Code e SOLID

- Nomeação Significativa: Utilizar nomes significativos para variáveis, métodos e classes, tornando o código mais legível e compreensível.
```java
public interface AuthorServiceImpl {

  AuthorDetailsDTO register(AuthorRegisterDTO dto);
  
  AuthorDetailsDTO update(AuthorUpdateDTO dto, Long id);
  
  List<AuthorDetailsDTO> findAll();

  ...more
}
```
- Princípio da Responsabilidade Única (Single Responsibility Principle - SRP): Garantir que cada classe ou método tenha apenas uma responsabilidade.

```java
@Entity
public class Author {
  ..atributos
  
  public Author registrar(AuthorRegisterDTO dto) {
    this.name = dto.name();
    this.lastName = dto.lastName();
    this.cpf = dto.cpf();
    this.birthDate = dto.birthDate();
    this.createdDate = LocalDate.now();
    return this;
  }

}
```
- Princípio Aberto/Fechado (Open/Closed Principle - OCP): Projetar classes e métodos de forma a permitir a extensão sem modificar o código existente.
```java
@Service
public class AuthorService implements AuthorServiceImpl {

  private final AuthorRepository authorRepository;
  
  private AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }
  
  @Override
    public AuthorDetailsDTO register(AuthorRegisterDTO dto) {
    return new AuthorDetailsDTO(authorRepository.save(new Author().registrar(dto)));
  }
  
  @Override
    public AuthorDetailsDTO update(AuthorUpdateDTO dto, Long id) {
    return new AuthorDetailsDTO(authorRepository.save(findById(id).update(dto)));
  }

}
```


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
