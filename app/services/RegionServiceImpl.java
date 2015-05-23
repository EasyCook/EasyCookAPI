package services;

import models.recipes.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import repositories.RegionRepository;
import services.base.AbstractService;
import services.interfaces.RegionService;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 18/03/15.
 */
@Named
@Singleton
@Transactional
public class RegionServiceImpl extends AbstractService<Region,Long> implements RegionService
{
	RegionRepository regionRepository;

	@Autowired
	public RegionServiceImpl (RegionRepository regionRepository)
	{
		super( regionRepository );
		this.regionRepository = regionRepository;
	}
}
