package blog.haaga.assignment.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long genreid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="genre")
	private List<Discussion> discussions;

	public Genre() {}

	public Genre(String name) {
		super();
		this.name = name;

	}

	public long getGenreid() {
		return genreid;
	}

	public void setGenreid(long genreid) {
		this.genreid = genreid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Discussion> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(List<Discussion> discussions) {
		this.discussions = discussions;

	}

	@Override
	public String toString() {
		return "Genre [genreid=" + genreid + ", name=" + name + "]";
	}

	
}
