package services;

import models.recipes.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import repositories.RegionRepository;

import javax.inject.Named;

/**
 * Created by eduardo on 18/03/15.
 */
@Named
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
