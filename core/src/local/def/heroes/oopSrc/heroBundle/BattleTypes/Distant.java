package local.def.heroes.oopSrc.heroBundle.BattleTypes;

import local.def.heroes.oopSrc.heroBundle.*;

import java.util.ArrayList;
import java.util.List;

public class Distant extends Hero {
    public int Ammo;
    public int MaxAmmo;

    public Distant(String name, int[] position) {
        super(name, position);
        Ammo = 5;
        MaxAmmo = 5;
        Priority = 3;
    }

    @Override
    public void Step(List<Hero> mates, List<Hero> enemies)
    {
        if (Health <= 0)
            return;

        if(Ammo < MaxAmmo) {
            List<Hero> bearers = new ArrayList<Hero>();

            for(Hero hero : mates) {
                if(hero.BattleType != local.def.heroes.oopSrc.heroBundle.BattleTypes.BattleType.Bearer)
                    continue;

                if(hero.Health <= 0)
                    continue;

                if(!((Bearer)hero).IsReady)
                    continue;

                bearers.add(hero);
            }

            if(bearers.isEmpty())
                return;

            ((Bearer)bearers.get(0)).IsReady = false;
            Ammo += 1;
        }

        Hero enemy = GetNearestEnemy(Position, enemies);

        if (GetDistance(Position, enemy.Position) > Range)
        {
            super.Step(mates, enemies);
            return;
        }

        if(Ammo <= 0)
            return;

        Attack(enemy);
    }

    @Override
    protected void Attack(Hero enemy)
    {
        super.Attack(enemy);
        Ammo -= 1;
    }
}
