package pl.oucik.phecdateam.impl;

import pl.oucik.phecdateam.mod.Category;
import pl.oucik.phecdateam.mod.Mod;

public class PhecdaMod extends Mod {
    public PhecdaMod() {
        super("PhecdaMod", "PhecdaMod only", Category.COSMETIC);
    }
    @Override
    public void onEnable() {
        super.onEnable();
        System.out.println("PhecdaMod ON");
    }
}
