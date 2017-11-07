package blog.haaga.assignment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Discussion {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    @NotNull
    @Size(min = 1, max = 100)
    private String email;
    @NotNull
    private String album ;
    @NotNull
    private String artist;
    @Column (length=1000000)
    @Lob
    @NotNull
    @Size(min = 1, max = 100000)
    private String thought;
   
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "genreid")
    private Genre genre;

    public Discussion() {}

	public Discussion(String name,String email,String album,String artist, String thought,Genre genre) {
		super();
		this.name = name;
		this.email = email;
		this.album = album;
		this.artist = artist;
		this.thought = thought;
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getThought() {
		return thought;
	}

	public void setThought(String thought) {
		this.thought = thought;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Discussion [id=" + id + ", name=" + name + ", email=" + email + ", album=" + album + ", artist="
				+ artist + ", thought=" + thought + ", genre=" + genre + "]";
	}

	
	

}