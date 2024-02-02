package local.def.heroes.oopSrc.heroBundle.Tools;

import local.def.heroes.oopSrc.heroBundle.Hero;
import local.def.heroes.oopSrc.heroBundle.Heroes.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Team
{
    private static Random _random = new Random();

    private static List<String> _names;

    static {
        _names = new ArrayList<String>();
        _names.add("Name");
        _names.add("Name");
        _names.add("Name");
        _names.add("Name");
        _names.add("Name");
        _names.add("Name");
        _names.add("Name");
    }

    public TeamSide Side;
    public List<Hero> Heroes = new ArrayList<Hero>();

    public Team(TeamSide side)
    {
        Side = side;
        GenerateTeam();
    }

    public List<Hero> SortByPriority()
    {
        List<Hero> heroes = Heroes;
        int count = 0;

        while(count < heroes.size() - 1) {
            for (int i = 0; i < heroes.size() - 1; i++) {
                if(heroes.get(i).Priority > heroes.get(i + 1).Priority) {
                    int temp = heroes.get(i).Priority;
                    heroes.get(i).Priority = heroes.get(i + 1).Priority;
                    heroes.get(i + 1).Priority = temp;
                }
            }

            count++;
        }

        return heroes;
    }
    
    public List<Hero> reverse(List<Hero> input) {
        List<Hero> reversed = new ArrayList<Hero>();

        for (int i = input.size() - 1; i > 0; i--)
            reversed.add(input.get(i));

        return reversed;
    }

    public boolean CanFight()
    {
//        boolean canFight = true;
//
//        canFight = Heroes.stream().anyMatch(hero -> hero.BattleType == assets.BattleTypes.BattleType.Melee && hero.Health > 0);
//        canFight = Heroes.stream().anyMatch(hero -> hero.BattleType == assets.BattleTypes.BattleType.Bearer && hero.Health > 0);
//        return canFight;
        return Heroes.stream().anyMatch(hero -> hero.Health > 0);
    }

    private void GenerateTeam()
    {
        Heroes.add(CreateHero(1,
                _names.get(_random.nextInt(_names.size() - 2) + 1),
                new int[] {3, Side == TeamSide.Darkness ? 1 : 10}));
        Heroes.add(CreateHero(1,
                _names.get(_random.nextInt(_names.size() - 2) + 1),
                new int[] {8, Side == TeamSide.Darkness ? 1 : 10}));

        for (int i = 1; i <= 10; i++)
        {
            if (i == 3 || i == 8)
                continue;

            Heroes.add(CreateHero(_random.nextInt(6) + 2,
                    _names.get(_random.nextInt(_names.size() - 2) + 1),
                    new int[] {i, Side == TeamSide.Darkness ? 1 : 10}));
        }
    }

    public boolean contains(Hero hero)
    {
        return Heroes.contains(hero);
    }

    private static Hero CreateHero(int number, String name, int[] position)
    {
        switch (number) {
            case 1:
                return new Villager(name, position);
            case 2:
                return new Bandit(name, position);
            case 3:
                return new Priest(name, position);
            case 4:
                return new Wizard(name, position);
            case 5:
                return new Spearman(name, position);
            case 6:
                return new Crossbower(name, position);
            case 7:
                return new Sniper(name, position);
        }

        return null;
    }
}