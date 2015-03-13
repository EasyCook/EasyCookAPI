package models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.AbstractEntity;
import models.recipes.Recipe;
import play.Logger;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@SuppressWarnings("serial")
@Entity
public class User extends AbstractEntity
{



    @Constraints.MinLength(2)
    @Constraints.MaxLength(256)
    public String firstName;


    @Constraints.MinLength(2)
    @Constraints.MaxLength(256)
    public String lastName;

    @Constraints.MaxLength(256)
    @Constraints.Required
    @Constraints.Email
    private String email;

    @JsonIgnore
    private String password;

	@JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Recipe> recipes;

    /*public User ()
    {

    }*/

    public static String getMD5 (String pass)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++)
            {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            Logger.debug("Password: " + sb);
            return sb.toString();
        }
        catch (NoSuchAlgorithmException ex)
        {
            Logger.error("Error creatind md5 password", ex);
        }
        return null;
    }


    // region methods
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
        return this.password;
    }

    public void setPassword (String password)
    {
        this.password = getMD5(password);
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



}