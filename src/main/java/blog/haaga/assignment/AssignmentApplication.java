package blog.haaga.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import blog.haaga.assignment.domain.Discussion;
import blog.haaga.assignment.domain.DiscussionRepository;

@SpringBootApplication
public class AssignmentApplication {
	private static final Logger log = LoggerFactory.getLogger(AssignmentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Bean
	public CommandLineRunner blogSpot(DiscussionRepository repository) {
		return (args) -> {
			log.info("Starting a example discussion.");
			repository.save(new Discussion("josiah singh", "jsingh@gmail.com", "Metal Music","Cowboys From Hell","Pantera",
					"This is just a demo for the topics to be used for the discussions"));
			repository.save(new Discussion("josiah singh", "jsingh@gmail.com", "Metal Music","Cowboys From Hell","Pantera",
					"This is just a demo for the topics to be used for the discussions"));
			repository.save(new Discussion("josiah singh", "jsingh@gmail.com", "Metal Music","Cowboys From Hell","Pantera",
					"This is just a demo for the topics to be used for the discussions"));
			
			
			
			log.info("Get all the discussions");
			for (Discussion discussion : repository.findAll()) {
				log.info(discussion.toString());

			}

		};

	}
}
