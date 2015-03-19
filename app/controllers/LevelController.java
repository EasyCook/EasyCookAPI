package controllers;

import daos.LevelDAO;
import models.recipes.Level;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by eduardo on 12/03/15.
 */
@Named
@Singleton
public class LevelController extends BaseCrudController<Level>
{
	LevelDAO levelDAO;

	@Autowired
	public LevelController(LevelDAO levelDAO)
	{
		super(levelDAO, Level.class);
		this.levelDAO = levelDAO;
	}
}
