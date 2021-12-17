package pl.oucik.phecdateam;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.ResourceLocation;

public class FeaturedServer extends ServerData {
    public static final ResourceLocation ICON = new ResourceLocation("PhecdaClient/icon.png");
    public FeaturedServer(String ServerName, String ServerIP) {
        super(ServerName, ServerIP, false);
    }
}
