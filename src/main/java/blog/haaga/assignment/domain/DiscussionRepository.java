package blog.haaga.assignment.domain;

	import java.util.List;

	import org.springframework.data.repository.CrudRepository;





	public interface DiscussionRepository extends CrudRepository<Discussion,Long> {

		List<Discussion> findByName(String name );
		List<Discussion> findById(Long id);
		List<Discussion> findTop5ByOrderByDateDesc();
		List<Discussion> findAllByOrderByIdDesc();
	}


