
package pl.oucik.phecdateam;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import pl.oucik.phecdateam.altmanager.AltLoginThread;
import pl.oucik.phecdateam.rebuild.helper.OpenGlHelper;

import java.io.IOException;

public final class GuiPhecdaOptions
extends GuiScreen {
    private final GuiScreen previousScreen;

    public GuiPhecdaOptions(GuiScreen previousScreen) {
        this.previousScreen = previousScreen;
    }
    public static boolean autologin;
    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 1){
                this.mc.displayGuiScreen(this.previousScreen);
        }
        if (button.id==2){
            autologin= !autologin;
            button.displayString = "§fAutoLogin: " + (autologin ? "§aTAK" : "§cNIE");
        }
        if (button.id==69){
            this.mc.displayGuiScreen(previousScreen);
        }

    }

    @Override
    public void drawScreen(int x2, int y2, float z2) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.mc.fontRendererObj, "PhecdaOptions", width / 2, 20,  OpenGlHelper.rainbowColor(3000, 1));
        super.drawScreen(x2, y2, z2);
    }

    @Override
    public void initGui() {
        int var3 = height / 4 + 24;
        this.buttonList.add(new GuiButton(2, this.width / 2 - 155, 50, 150, 20,"§fAutoLogin: " + (autologin ? "§aTAK" : "§cNIE")));
        this.buttonList.add(new GuiButton(69, this.width / 2 - 80, this.height / 2 + 90, 150, 20, "BACK"));

        Keyboard.enableRepeatEvents(true);
    }

    @Override
    protected void keyTyped(char character, int key) {
        try {
            super.keyTyped(character, key);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (character == '\r') {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
    }

    @Override
    protected void mouseClicked(int x2, int y2, int button) {
        try {
            super.mouseClicked(x2, y2, button);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void updateScreen() {
    }
}

