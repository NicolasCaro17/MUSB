package co.edu.usbbog.musb.musbws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class MusbwsApplication {	

	public static void main(String[] args) {
		SpringApplication.run(MusbwsApplication.class, args);
	}

}
