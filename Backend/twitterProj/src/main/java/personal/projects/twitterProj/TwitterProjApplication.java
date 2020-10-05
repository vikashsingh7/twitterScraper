package personal.projects.twitterProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("personal.projects")
@SpringBootApplication
public class TwitterProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterProjApplication.class, args);
	}



}
