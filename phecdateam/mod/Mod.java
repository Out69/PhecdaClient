package pl.oucik.phecdateam.mod;

import net.minecraft.client.Minecraft;
import pl.oucik.phecdateam.PhecdaClient;

public class Mod {

    public Minecraft mc = Minecraft.getMinecraft();

    public String name,description;
    public boolean enabled;
    public Category category;


    public Mod(String name, String description, Category category){
        this.name = name;
        this.description = description;
        this.category = category;

        this.enabled = true;

    }

    public void onEnable(){
        PhecdaClient.eventManager.register(this);
    }

    public void onDisable(){
        PhecdaClient.eventManager.unregister(this);

    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if(enabled){
            onEnable();
        }else{
            onDisable();
        }
    }

    public void toggle(){

        setEnabled(this.enabled);

    }
}
