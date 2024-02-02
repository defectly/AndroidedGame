package local.def.heroes.oopSrc.heroBundle.Heroes;

import local.def.heroes.oopSrc.heroBundle.BattleTypes.Melee;

public class Bandit extends Melee {
    public Bandit(String name, int[] position) {
        super(name, position);
        HeroType = local.def.heroes.oopSrc.heroBundle.HeroType.Bandit;
    }
}
