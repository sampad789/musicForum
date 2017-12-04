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
import blog.haaga.assignment.domain.GenreRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DiscussionRepositoryTests {

	@Autowired

	private DiscussionRepository drepository;

	private GenreRepository grepository;

	@Test
	public void findOneDiscussionByName() {
		List<Discussion> discussions = drepository.findByName("josiah");
		assertThat(discussions).hasSize(1);

	}

	@Test
	public void createNewDiscussion() {
		Discussion newDiscussion = new Discussion("mati","jsingh@gmail.com","Cowboys From Hell","Pantera","This is just a demo for the topics to be used for the discussions","Great rock album",grepository.findByName("Alternative").get(0));
		drepository.save(newDiscussion);
		assertThat(newDiscussion.getId()).isNotNull();

	}

}
