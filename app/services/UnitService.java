package services;

import models.recipes.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.UnitRepository;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.transaction.Transactional;

/**
 * Created by eduardo on 19/03/15.
 */
@Named
@Singleton
@Transactional
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
