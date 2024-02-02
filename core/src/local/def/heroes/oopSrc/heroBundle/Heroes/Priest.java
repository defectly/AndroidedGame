package local.def.heroes.oopSrc.heroBundle.Heroes;

import local.def.heroes.oopSrc.heroBundle.BattleTypes.Melee;

public class Priest extends Melee {
    public Priest(String name, int[] position) {
        super(name, position);
        HeroType = local.def.heroes.oopSrc.heroBundle.HeroType.Priest;
    }
}
