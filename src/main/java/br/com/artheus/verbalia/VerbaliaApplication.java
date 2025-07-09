package br.com.artheus.verbalia;

import br.com.artheus.verbalia.cli.InteractiveMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VerbaliaApplication implements CommandLineRunner {

	private final InteractiveMenu interactiveMenu;

	public VerbaliaApplication(InteractiveMenu interactiveMenu) {
		this.interactiveMenu = interactiveMenu;
	}

	public static void main(String[] args) {
		SpringApplication.run(VerbaliaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		interactiveMenu.start();
	}
}


