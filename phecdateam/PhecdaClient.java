package pl.oucik.phecdateam;


import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import pl.oucik.phecdateam.event.EventManager;
import pl.oucik.phecdateam.mod.ModManager;
import pl.oucik.phecdateam.rebuild.command.CommandManager;
import pl.oucik.phecdateam.rebuild.command.impl.ExploitCommand;
import pl.oucik.phecdateam.rebuild.command.impl.FakeGamemodeCommand;
import pl.oucik.phecdateam.rebuild.command.impl.HelpCommand;
import pl.oucik.phecdateam.rebuild.command.impl.OnlineCommand;
import pl.oucik.phecdateam.rebuild.exploit.ExploitManager;
import pl.oucik.phecdateam.rebuild.exploit.impl.nbt.*;
import pl.oucik.phecdateam.viamcp.ViaMCP;

import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public enum PhecdaClient {





    INSTANCE;
    public static EventManager eventManager;
    public ModManager manager;

    private final CommandManager commandManager;
    private final ExploitManager exploitManager;
    public static boolean buulin = true;

    PhecdaClient(){
        try{
            ViaMCP.getInstance().start();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        commandManager = new CommandManager(
                new ExploitCommand(),
                new HelpCommand(),
                new OnlineCommand(),
                new FakeGamemodeCommand()
        );

        exploitManager = new ExploitManager(
                new Neun1(),
                new Neun2(),
                new Netty1(),
                new ExploitFixerExploit(),
                new CustomClick1(),
                new Wing1(),
                new Wing2(),
                new CustomClick2(),
                new BlockPlace1(),
                new Position1(),
                new BlockPlace2(),
                new BlockPlace3()
        );
    }



    public void setDisplay() throws IOException {
        Display.setTitle("PhecdaClient v1.2.1");

    }

    public void shutDown() {

    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public ExploitManager getExploitManager() {
        return exploitManager;
    }

}
