package local.def.heroes.oopSrc.heroBundle.Heroes;

import local.def.heroes.oopSrc.heroBundle.BattleTypes.Distant;

public class Crossbower extends Distant {
    public Crossbower(String name, int[] position) {
        super(name, position);
        Range = 3;
        HeroType = local.def.heroes.oopSrc.heroBundle.HeroType.Crossbower;
    }
}
