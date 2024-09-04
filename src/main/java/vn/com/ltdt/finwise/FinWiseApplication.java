package vn.com.ltdt.finwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FinWiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinWiseApplication.class, args);
	}

}
