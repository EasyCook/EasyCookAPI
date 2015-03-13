package dtos;

/**
 * Created by eduardo on 11/03/15.
 */
public class CategoryDTO {
    Long id;
    String name;
	String thumbnail;
	String slug;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getThumbnail()
	{
		return thumbnail;
	}

	public void setThumbnail( String thumbnail )
	{
		this.thumbnail = thumbnail;
	}

	public String getSlug()
	{
		return slug;
	}

	public void setSlug( String slug )
	{
		this.slug = slug;
	}
}
