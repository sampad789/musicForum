package blog.haaga.assignment;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import blog.haaga.assignment.web.AdminController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssignmentApplicationTests {
	
	@Autowired
	private AdminController adminController ;

	@Test

	public void contextLoads() throws Exception{
		assertThat(adminController).isNotNull();
	}

}
