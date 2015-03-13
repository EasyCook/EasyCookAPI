package repositories;

import models.recipes.Level;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by eduardo on 11/03/15.
 */
public interface LevelRepository extends JpaRepository<Level,Long> {
}
