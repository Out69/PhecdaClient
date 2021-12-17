package pl.oucik.phecdateam.ui;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.util.ResourceLocation;
import pl.oucik.phecdateam.altmanager.GuiAltLogin;
import pl.oucik.phecdateam.viamcp.gui.GuiProtocolSelector;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainMenu extends GuiScreen {

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        mc.getTextureManager().bindTexture(new ResourceLocation("PhecdaClient/main.jpg.png"));
        drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
        Gui.drawRect(width / 2 - 220,height / 2 + 120, width / 2 + 220, height / 2 + 30 , new Color(0, 0 ,0 , 170).getRGB());

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() throws IOException, InterruptedException {
        DiscordRichPresence richPresence = new DiscordRichPresence.Builder("In main menu").setBigImage("logo", "PhecdaClient").setDetails("Minecraft 1.8.8").build();
        DiscordRPC.discordUpdatePresence(richPresence);
        this.buttonList.add(new GuiButton(1,width / 2 - 205, height / 2 + 40, "SinglePlayer"));
        this.buttonList.add(new GuiButton(2,width / 2 - 205, height / 2 + 65, "MultiPlayer"));
        this.buttonList.add(new GuiButton(69,width / 2 - 205, height / 2 + 90, "Username Changer"));
        this.buttonList.add(new GuiButton(3, width / 2 + 7, height / 2 + 40, "Options"));
        this.buttonList.add(new GuiButton(300, width / 2 + 7, height / 2 + 65, "Version Changer"));
        this.buttonList.add(new GuiButton(4, width / 2 + 7, height / 2 + 90, "Shutdown."));
        this.buttonList.add(new GuiButton(1,10000,10000,""));
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException, InterruptedException {

        if(button.id == 1) {
            mc.displayGuiScreen(new GuiSelectWorld(this));
        }
        if(button.id == 2) {
            mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        if(button.id==3) {
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        }
        if(button.id==4) {
            mc.shutdown();
        }
        if(button.id==69) {
            mc.displayGuiScreen(new GuiAltLogin(this));
        }
        if (button.id==300){
            this.mc.displayGuiScreen(new GuiProtocolSelector(this));
        }
        }

    }


