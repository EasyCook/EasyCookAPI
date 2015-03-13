package dtos;

import org.apache.commons.lang3.builder.ToStringBuilder;
import play.data.validation.Constraints;

/**
 * Created by eduardo on 20/11/14.
 */
public class UserDTO
{

    public Long id;

    @Constraints.MaxLength(256)
    @Constraints.Email
    public String email;

    @Constraints.MinLength(6)
    @Constraints.MaxLength(256)
    public String password;

    @Constraints.MinLength(2)
    @Constraints.MaxLength(256)
    public String firstName;

    @Constraints.MinLength(2)
    @Constraints.MaxLength(256)
    public String lastName;

    public Float cheerScore;


    public Long getId ()
    {
        return id;
    }

    public void setId (Long id)
    {
        this.id = id;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getFirstName ()
    {
        return firstName;
    }

    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName ()
    {
        return lastName;
    }

    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }

    public Float getCheerScore ()
    {
        return cheerScore;
    }

    public void setCheerScore (Float cheerScore)
    {
        this.cheerScore = cheerScore;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
