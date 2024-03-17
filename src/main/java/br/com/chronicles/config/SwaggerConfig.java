package br.com.chronicles.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
public class SwaggerConfig {
	
	@Value("${api.url}")
	private String url;

	@Value("${version-api}")
	private String version;

	@Bean
	OpenAPI myOpenAPI() {
		Server server = new Server();

		server.setUrl(url);
		server.setDescription("Ambiente de Desenvolvimento da Chrnicles API");

		Contact contact = new Contact();
		contact.setEmail("bernardojob2003@outlook.com");
		contact.setName("Chronicles API");
		contact.setUrl("https://github.com/Boyce22");

		License license = new License()
				.name("Apache license version 2.0")
				.url("https://maven.apache.org/ref/3.0/license.html");

		Info info = new Info()
				.title("Documentação da API Chronicles")
				.version(version)
				.contact(contact)
				.license(license);

		return new OpenAPI().info(info).servers(List.of(server));
	}

}
