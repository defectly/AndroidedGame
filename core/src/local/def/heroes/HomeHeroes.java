package local.def.heroes;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import local.def.heroes.oopSrc.View;
import local.def.heroes.oopSrc.heroBundle.*;
import local.def.heroes.oopSrc.heroBundle.Tools.Team;
import local.def.heroes.oopSrc.heroBundle.Tools.TeamSide;

public class HomeHeroes extends ApplicationAdapter {
	SpriteBatch batch;

	Texture background, bandit, crossbower, priest, sniper, spearman, villager, wizard;
	Texture img;

	static Random random = new Random();
	public static Team darkness;
	public static Team heaven;
	public static ArrayList<Hero> darkTeam = new ArrayList<Hero>();
	public static ArrayList<Hero> holyTeam = new ArrayList<Hero>();
	public static ArrayList<Hero> allTeam = new ArrayList<Hero>();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		background = new Texture("background.jpg");
		bandit = new Texture("heroes/bandit.png");
		crossbower = new Texture("heroes/crossbower.png");
		priest = new Texture("heroes/priest.png");
		sniper = new Texture("heroes/sniper.png");
		spearman = new Texture("heroes/spearman.png");
		villager = new Texture("heroes/villager.png");
		wizard = new Texture("heroes/wizard.png");

		darkness = new Team(TeamSide.Darkness);
		heaven = new Team(TeamSide.Heaven);
		darkTeam.addAll(darkness.Heroes);
		holyTeam.addAll(heaven.Heroes);
		allTeam.addAll(darkness.SortByPriority());
		allTeam.addAll(heaven.SortByPriority());


	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//batch.draw(img, 0, 0);


		for (Hero hero : allTeam) {
			if(hero.Health <= 0)
				continue;

			switch (hero.HeroType) {
				case Bandit:
					batch.draw(bandit, hero.Position[1] * bandit.getWidth(), hero.Position[0] * bandit.getHeight() / 10 * 8);
				case Crossbower:
					batch.draw(crossbower, hero.Position[1] * crossbower.getWidth(), hero.Position[0] * bandit.getHeight() / 10 * 8);
				case Priest:
					batch.draw(priest, hero.Position[1] * priest.getWidth(), hero.Position[0] * bandit.getHeight() / 10 * 8);
				case Sniper:
					batch.draw(sniper, hero.Position[1] * sniper.getWidth(), hero.Position[0] * bandit.getHeight() / 10 * 8);
				case Spearman:
					batch.draw(spearman, hero.Position[1] * spearman.getWidth(), hero.Position[0] * bandit.getHeight() / 10 * 8);
				case Villager:
					batch.draw(villager, hero.Position[1] * villager.getWidth(), hero.Position[0] * bandit.getHeight() / 10 *  8);
				case Wizard:
					batch.draw(wizard, hero.Position[1] * wizard.getWidth(), hero.Position[0] * bandit.getHeight() / 10 * 8);
			}
		}

		if(Gdx.input.isTouched()) {

			if(!darkness.CanFight()) {
				Gdx.graphics.setTitle("Heaven won");
			}
			if(!heaven.CanFight()) {
				Gdx.graphics.setTitle("Darkness won");
			}

			try {
				for(Hero hero : allTeam) {
					if(holyTeam.contains(hero))
						hero.Step(holyTeam, darkTeam);
					else
						hero.Step(darkTeam, holyTeam);
				}
			} catch(Exception e) {

			}
		}

		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		bandit.dispose();
		crossbower.dispose();
		priest.dispose();
		sniper.dispose();
		spearman.dispose();
		villager.dispose();
		wizard.dispose();
	}
}
