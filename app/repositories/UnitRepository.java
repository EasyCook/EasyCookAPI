package repositories;

import models.recipes.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by eduardo on 11/03/15.
 */
public interface UnitRepository extends JpaRepository<Unit,Long> {
}
