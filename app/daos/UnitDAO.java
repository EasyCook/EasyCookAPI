package daos;

import models.recipes.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import repositories.UnitRepository;

/**
 * Created by eduardo on 19/03/15.
 */
public class UnitDAO extends AbstractDAO<Unit,Long>
{
	UnitRepository unitRepository;

	@Autowired
	public UnitDAO(  UnitRepository unitRepository )
	{
		super( unitRepository );
		this.unitRepository = unitRepository;
	}
}
