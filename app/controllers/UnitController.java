package controllers;

import services.UnitService;
import models.recipes.Unit;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 19/03/15.
 */
@Named
@Singleton
public class UnitController extends BaseCrudController<Unit>
{
	UnitService unitDAO;

	@Autowired
	public UnitController( UnitService unitDAO )
	{
		super( unitDAO, Unit.class );
		this.unitDAO = unitDAO;
	}
}
