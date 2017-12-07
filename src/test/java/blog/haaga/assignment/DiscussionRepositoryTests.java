package blog.haaga.assignment;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import blog.haaga.assignment.domain.Discussion;
import blog.haaga.assignment.domain.DiscussionRepository;
import blog.haaga.assignment.domain.Genre;


@RunWith(SpringRunner.class)
@DataJpaTest
public class DiscussionRepositoryTests {

	@Autowired

	private DiscussionRepository drepository;

	

	@Test
	public void findOneDiscussionByName() {
		List<Discussion> discussions = drepository.findByName("josiah");
		assertThat(discussions).hasSize(1);
	}
	@Test
		public void findOneDiscussionById() {
			List<Discussion> discussions = drepository.findById(2L);
			assertThat(discussions).hasSize(1);


	}

	@Test
	public void createNewDiscussion() {
		Discussion newdis = new Discussion("Claudio","claoudfero@gmail.com","bob marley", "three wailers", "demotest","good music", new Genre ("Rock"));
		drepository.save(newdis);
		assertThat(newdis.getId()).isNotNull();
	}

}
