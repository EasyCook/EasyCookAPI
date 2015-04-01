package repositories;

import models.recipes.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 11/03/15.
 */
@Named
@Singleton
public interface RegionRepository extends JpaRepository<Region,Long> {
}
