package entities;

import java.io.Serializable;

public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;

	public Movie() {
	}

	public Movie(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + "]";
	}

}
