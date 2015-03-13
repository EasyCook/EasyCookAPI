package repositories;

import models.recipes.Region;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by eduardo on 11/03/15.
 */
public interface RegionRepository extends JpaRepository<Region,Long> {
}
