package intern.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import intern.project.entity.Account;
import intern.project.repository.AccountRepository;

@SpringBootApplication(scanBasePackages = { "intern.project.repository","intern.project.controller","intern.project.entity",
"intern.project.security","intern.project.service" })
public class ProjectApplication  {
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
    

}
