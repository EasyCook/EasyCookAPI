package dtos;

/**
 * Created by eduardo on 26/05/15.
 */
public class BaseDTO {
	Long id;
	String name;
	String description;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}
}
