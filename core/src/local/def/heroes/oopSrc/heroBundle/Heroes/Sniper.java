package local.def.heroes.oopSrc.heroBundle.Heroes;

import local.def.heroes.oopSrc.heroBundle.BattleTypes.Distant;

public class Sniper extends Distant {
    public Sniper(String name, int[] position) {
        super(name, position);
        Range = 4;
        HeroType = local.def.heroes.oopSrc.heroBundle.HeroType.Sniper;
    }
}
