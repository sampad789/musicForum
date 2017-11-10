package blog.haaga.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import blog.haaga.assignment.domain.Discussion;
import blog.haaga.assignment.domain.DiscussionRepository;
import blog.haaga.assignment.domain.Genre;
import blog.haaga.assignment.domain.GenreRepository;

@SpringBootApplication
public class AssignmentApplication {
	private static final Logger log = LoggerFactory.getLogger(AssignmentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Bean
	public CommandLineRunner blogSpot(DiscussionRepository drepository,GenreRepository grepository) {
		return (args) -> {
			log.info("save a couple of Genres");
			grepository.save(new Genre ("Metal")); 
			grepository.save(new Genre ("R&B")); 
			grepository.save(new Genre ("Hard Rock")); 
			grepository.save(new Genre ("Indie")); 
			grepository.save(new Genre ("Alternative")); 
			grepository.save(new Genre ("Classical")); 
			grepository.save(new Genre ("Blues")); 
			grepository.save(new Genre ("Pop")); 
			grepository.save(new Genre ("EDM")); 
			grepository.save(new Genre ("HIP-HOP")); 
			grepository.save(new Genre ("RAP")); 
			grepository.save(new Genre ("Jazz")); 
			grepository.save(new Genre ("Soul"));
			grepository.save(new Genre ("Reggae"));
			

		log.info("Starting a example discussion.");
			drepository.save(new Discussion("josiah singh", "jsingh@gmail.com", "Cowboys From Hell",
					"Pantera", "This is just a demo for the topics to be used for the discussions",grepository.findByName("Metal").get(0)));
			drepository.save(new Discussion("josiah singh", "jsingh@gmail.com", "Cowboys From Hell",
					"Pantera", "This is just a demo for the topics to be used for the discussions",grepository.findByName("EDM").get(0)));
			

			log.info("Get all the discussions");
			for (Discussion discussion : drepository.findAll()) {
				log.info(discussion.toString());

			}

		};

	}
}
