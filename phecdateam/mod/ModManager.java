package pl.oucik.phecdateam.mod;

import pl.oucik.phecdateam.impl.PhecdaMod;

import java.util.ArrayList;

public class ModManager {

    public ArrayList<Mod> mods;

    public ModManager(){

        mods = new ArrayList<>();
        mods.add(new PhecdaMod());

    }

}
