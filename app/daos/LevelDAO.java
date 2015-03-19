package daos;

import models.recipes.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import repositories.LevelRepository;

import javax.inject.Named;

/**
 * Created by eduardo on 12/03/15.
 */
@Named
@Transactional
public class LevelDAO extends AbstractDAO<Level,Long>
{
	LevelRepository levelRepository;

	@Autowired
	public LevelDAO( LevelRepository levelRepository )
	{
		super( levelRepository );
		this.levelRepository = levelRepository;
	}
}
