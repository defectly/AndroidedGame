package local.def.heroes.oopSrc.heroBundle.Heroes;

import local.def.heroes.oopSrc.heroBundle.BattleTypes.Distant;

public class Spearman extends Distant {
    public Spearman(String name, int[] position) {
        super(name, position);
        Range = 2;
        HeroType = local.def.heroes.oopSrc.heroBundle.HeroType.Spearman;
        Ammo = 1;
        MaxAmmo = 1;
    }
}
