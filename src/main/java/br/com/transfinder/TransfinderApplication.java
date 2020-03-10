package br.com.transfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.transfinder.repository", repositoryImplementationPostfix = "ShippingCompannyRepositoryImpl")
public class TransfinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransfinderApplication.class, args);
	}

}
