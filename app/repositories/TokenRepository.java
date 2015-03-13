package repositories;

import models.security.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 1/11/14.
 */
@Named
@Singleton
public interface TokenRepository extends JpaRepository<Token,Long>
{

    @Query("select t from Token t where t.authToken = ?1")
    Token findUserByAuthToken(String authToken);

    @Query("select t from Token t where t.user.id = ?1")
    Token findTokenByUserId(Long userId);

}
