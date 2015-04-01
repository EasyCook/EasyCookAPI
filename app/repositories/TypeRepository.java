package repositories;

import models.recipes.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.sound.sampled.CompoundControl;

/**
 * Created by eduardo on 11/03/15.
 */
@Named
@Singleton
public interface TypeRepository extends JpaRepository<Type,Long> {
}
