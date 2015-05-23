package controllers;

import controllers.base.BaseCrudController;
import models.recipes.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import services.interfaces.UnitService;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 19/03/15.
 */
@Named
@Singleton
public class UnitController extends BaseCrudController<Unit>
{
	UnitService unitService;

	@Autowired
	public UnitController( UnitService unitService )
	{
		super( unitService);
		this.unitService = unitService;
	}
}
