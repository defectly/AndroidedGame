package local.def.heroes.oopSrc.heroBundle.BattleTypes;

import local.def.heroes.oopSrc.heroBundle.Hero;

public abstract class Bearer extends Hero {
    public boolean IsReady;
    public Bearer(String name, int[] Position) {
        super(name, Position);
        Priority = 0;
    }
}