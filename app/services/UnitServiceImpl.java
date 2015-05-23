package services;

import models.recipes.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.UnitRepository;
import services.base.AbstractService;
import services.interfaces.UnitService;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.transaction.Transactional;

/**
 * Created by eduardo on 19/03/15.
 */
@Named
@Singleton
@Transactional
public class UnitServiceImpl extends AbstractService<Unit,Long> implements UnitService
{
	UnitRepository unitRepository;

	@Autowired
	public UnitServiceImpl (UnitRepository unitRepository)
	{
		super( unitRepository );
		this.unitRepository = unitRepository;
	}
}
