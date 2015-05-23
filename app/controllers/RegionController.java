package controllers;

import controllers.base.BaseCrudController;
import models.recipes.Region;
import org.springframework.beans.factory.annotation.Autowired;
import services.interfaces.RegionService;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 18/03/15.
 */
@Named
@Singleton
public class RegionController extends BaseCrudController<Region>
{
	RegionService regionService;

	@Autowired
	public RegionController( RegionService regionService )
	{
		super( regionService );
		this.regionService = regionService;
	}
}
