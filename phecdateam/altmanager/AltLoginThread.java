
package pl.oucik.phecdateam.altmanager;

import java.net.Proxy;

import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Session;

public final class AltLoginThread
extends Thread {
    private String status;
    private final String username;
    private Minecraft mc = Minecraft.getMinecraft();

    public AltLoginThread(String username) {
        super("Alt Login Thread");
        this.username = username;
        this.status = (Object)((Object)EnumChatFormatting.GRAY) + "Waiting...";
    }

    private Session createSession(String username) {
        YggdrasilAuthenticationService service = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
        YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication)service.createUserAuthentication(Agent.MINECRAFT);
        auth.setUsername(username);
        try {
            auth.logIn();
            return new Session(auth.getSelectedProfile().getName(), auth.getSelectedProfile().getId().toString(), auth.getAuthenticatedToken(), "mojang");
        }
        catch (AuthenticationException localAuthenticationException) {
            localAuthenticationException.printStackTrace();
            return null;
        }
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public void run() {
        if(this.username.isEmpty()){
            this.status = (Object)((Object)EnumChatFormatting.RED) + "Username cannot be empty!";
            return;
        }

            this.mc.session = new Session(this.username, "", "", "mojang");
            this.status = (Object)((Object)EnumChatFormatting.GREEN) + "Logged in. (" + this.username + " - offline name)";
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

