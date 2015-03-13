package repositories;

import models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 23/10/14.
 */
@Named
@Singleton
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email = ?1 and u.password = ?2")
    User findUserByEmailAndPassword(String email, String password);

    User findUserByEmail(String email);
}