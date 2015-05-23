package services.interfaces;

import models.security.Token;
import models.user.User;
import org.springframework.transaction.annotation.Transactional;
import services.base.GenericService;

/**
 * Created by eduardo on 5/04/15.
 */
public interface UserService extends GenericService<User, Long>
{
    public User findByEmailAndPassword (String email, String password);
    public Long count ();
    public User login (User user);
    public Token checkIfExpired (Token token);
    public void logout (Long userId);
    public User getLoggedInUser ();
    public User finByEmail (String email);
    public Token getUserToken (User user);
}
