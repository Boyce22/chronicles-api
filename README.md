# Chronicles - API 📚  

### Conectando pequenos autores e seus mundos criativos ao universo digital com simplicidade e eficiência.  

---

## ⚙️ Funcionalidades  

### 📄 **Cadastro de Autor**  
- Os autores podem se cadastrar e enviar seus **trabalhos autorais** no formato **PDF**, que serão vinculados ao seu perfil.  

### 📖 **Cadastro de Leitor**  
- Leitores podem se cadastrar para acessar obras disponíveis na aplicação.  
- É possível alterar o **cadastro de leitor para autor**, mediante o envio de informações adicionais como **CPF**.  

### 📂 **Serviço para Upload de Arquivos PDF**  
- Autores podem enviar **arquivos PDF** com limite de até **128MB**.  
- As **páginas de conteúdo** enviadas serão contabilizadas, porém não há limite definido no momento.  

### 📚 **Cadastro de Obras**  
- As obras devem ser cadastradas em **categorias padronizadas**, como Romance, Ação, Aventura, entre outras.  
- Obras direcionadas ao **público maduro** receberão uma **tag especial**, restringindo o acesso apenas para maiores de 18 anos.  

### 🧐 **Busca por Autor**  
- Encontre autores cadastrados facilmente por meio de uma referência, como **@Autor**.  

### 💬 **Sistema de Comentários**  
- Usuários podem deixar **comentários** sobre obras cadastradas, promovendo feedback entre leitores e autores.  
- O sistema de comentários incentiva discussões construtivas sobre cada obra apresentada.  

---

## 🛠️ Tecnologias Utilizadas  

- [Java 21](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html) ☕ - Linguagem de programação moderna e eficiente.  
- [Spring Framework](https://spring.io/) 💚 - Framework sólido para construção de aplicativos web e APIs robustas.  
- [PostgreSQL](https://www.postgresql.org/) 📓 - Banco de dados relacional confiável e de alto desempenho.  
- [Maven](https://maven.apache.org/) ⚖️ - Ferramenta para automação e gerenciamento de dependências.  

---

## 📦 Dependências  

| Dependência              | Link                                                                                   |  
|--------------------------|----------------------------------------------------------------------------------------|  
| **Lombok**               | [Lombok Setup](https://projectlombok.org/setup/maven)                                  |  
| **PostgreSQL**           | [PostgreSQL Driver](https://mvnrepository.com/artifact/org.postgresql/postgresql)      |  
| **Spring Validation**    | [Spring Validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation)|  

---

## 🚀 Instalação  

### 🗄️ Configurações do Banco de Dados  

1. **Abra o arquivo** `application.properties` na pasta do projeto.  
2. Substitua as configurações padrão com as informações do seu banco de dados PostgreSQL:  

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/chronicles  
spring.datasource.username=seu_usuario  
spring.datasource.password=sua_senha
```

3. Verifique o driver do banco de dados:  

```properties
spring.datasource.driverClassName=org.postgresql.Driver
```

4. Configure o Hibernate para gerenciar o esquema automaticamente:  

```properties
spring.jpa.hibernate.ddl-auto=update
```

5. Defina o **dialeto do Hibernate** para PostgreSQL:  

```properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

---

### ▶️ Inicializando o Sistema  

- Após configurar o `application.properties` com os valores corretos, inicie a aplicação localmente utilizando:  

```shell script
mvn spring-boot:run
```

- Certifique-se de que seu banco de dados PostgreSQL esteja ativo e configurado conforme os parâmetros definidos.  

---

## 📝 Notas Adicionais  

- Substitua `seu_usuario` e `sua_senha` com as credenciais apropriadas para acessar o PostgreSQL no seu ambiente.  
- Caso necessário, ajuste os valores padrões de configuração para atender às demandas do projeto ou ambiente de produção.  

Este guia oferece um ponto de partida para configurar e executar o **Chronicles API** com rapidez e eficiência. 🚀  
