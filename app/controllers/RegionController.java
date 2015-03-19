package controllers;

import daos.AbstractDAO;
import daos.RegionDAO;
import models.recipes.Region;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 18/03/15.
 */
@Named
@Singleton
public class RegionController extends BaseCrudController<Region>
{
	RegionDAO regionDAO;

	@Autowired
	public RegionController( RegionDAO regionDAO )
	{
		super( regionDAO,Region.class);
		this.regionDAO = regionDAO;
	}
}
