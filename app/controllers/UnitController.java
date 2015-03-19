package controllers;

import daos.AbstractDAO;
import daos.UnitDAO;
import models.recipes.Unit;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 19/03/15.
 */
@Named
@Singleton
public class UnitController extends BaseCrudController<Unit>
{
	UnitDAO unitDAO;

	public UnitController( UnitDAO unitDAO )
	{
		super( unitDAO, Unit.class );
		this.unitDAO = unitDAO;
	}
}
