package models.security;

import Constants.UserLoginStatus;
import models.AbstractEntity;
import models.user.User;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created by eduardo on 1/11/14.
 */
@Entity
public class Token extends AbstractEntity
{

    public String authToken;

    @OneToOne
    public User user;

    public UserLoginStatus status;

    public Date expirationDate;

    public String ip;

    public String getAuthToken ()
    {
        return authToken;
    }

    public void setAuthToken (String authToken)
    {
        this.authToken = authToken;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    public UserLoginStatus getStatus ()
    {
        return status;
    }

    public void setStatus (UserLoginStatus status)
    {
        this.status = status;
    }

    public Date getExpirationDate ()
    {
        return expirationDate;
    }

    public void setExpirationDate (Date expirationDate)
    {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
