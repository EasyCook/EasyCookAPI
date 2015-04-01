package services;

import models.recipes.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.UnitRepository;

/**
 * Created by eduardo on 19/03/15.
 */
public class UnitService extends AbstractService<Unit,Long>
{
	UnitRepository unitRepository;

	@Autowired
	public UnitService( UnitRepository unitRepository )
	{
		super( unitRepository );
		this.unitRepository = unitRepository;
	}
}
