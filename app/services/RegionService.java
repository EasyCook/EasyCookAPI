package services;

import models.recipes.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import repositories.RegionRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 18/03/15.
 */
@Named
@Singleton
@Transactional
public class RegionService extends AbstractService<Region,Long>
{
	RegionRepository regionRepository;

	@Autowired
	public RegionService( RegionRepository regionRepository )
	{
		super( regionRepository );
		this.regionRepository = regionRepository;
	}
}
