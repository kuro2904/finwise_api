package vn.com.ltdt.finwise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJpaAuditing
public class FinWiseApplication {



	public static void main(String[] args) {
		SpringApplication.run(FinWiseApplication.class, args);
	}

}
