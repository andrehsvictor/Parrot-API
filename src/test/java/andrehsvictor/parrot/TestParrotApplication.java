package andrehsvictor.parrot;

import org.springframework.boot.SpringApplication;

public class TestParrotApplication {

	public static void main(String[] args) {
		SpringApplication.from(ParrotApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
