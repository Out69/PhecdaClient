package pl.oucik.phecdateam.rebuild.hook;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import pl.oucik.phecdateam.GuiPhecdaOptions;
import pl.oucik.phecdateam.PhecdaClient;
import pl.oucik.phecdateam.rebuild.helper.ChatHelper;
import pl.oucik.phecdateam.rebuild.helper.OpenGlHelper;
import pl.oucik.phecdateam.rebuild.helper.SystemHelper;
import pl.oucik.phecdateam.rebuild.helper.TimeHelper;
import pl.oucik.phecdateam.rebuild.holder.Holder;

import javax.swing.*;
import java.awt.*;

public class GuiInGameHook extends GuiIngame {

  private static final Minecraft mc = Minecraft.getMinecraft();

  public GuiInGameHook(Minecraft mcIn) {
    super(mcIn);
  }

  @Override
  public void renderGameOverlay(float partialTicks) {
    super.renderGameOverlay(partialTicks);

    Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("PhecdaClient/logo.png"));
    Gui.drawModalRectWithCustomSizedTexture(10,7,40,35,130,130,200,200);
    Gui.drawRect(500,200, 500, 200 , new Color(202, 0 ,0 , 170).getRGB());

    if (!mc.isSingleplayer()) {
      int x = (int) mc.thePlayer.posX, y = (int) mc.thePlayer.posY, z = (int) mc.thePlayer.posZ;
      long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
      long lastPacketMS = TimeHelper.getCurrentTime() - Holder.getLastPacketMS();
      if (lastPacketMS > 1000 && Holder.getTPS() > 0.00)
      {
        Holder.setTPS(Holder.getTPS() - 0.01);
      }
      if (Minecraft.ommamalejointypale){
        JOptionPane.showMessageDialog(null, "YOOO YOU BYPASSED THIS LICENSE!!!", "LICENSE BYPASSED!!!!", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showConfirmDialog(null, "UPS CRITICAL ERROR \n CaUsEd By : YoU dOnT hAvE bRaIn", "Oh no wait", JOptionPane.PLAIN_MESSAGE);
        Minecraft.getMinecraft().shutdown();
        return;
      }
      mc.fontRendererObj
          .drawStringWithShadow(ChatHelper.fix("&cServer: " + mc.getCurrentServerData().serverIP),
              5, 130, 0);

      if (mc.thePlayer.getClientBrand() != null) {
        String brand = mc.thePlayer.getClientBrand().contains("<- ") ?
            mc.thePlayer.getClientBrand().split(" ")[0] + " -> " + mc.thePlayer.getClientBrand()
                .split("<- ")[1] : mc.thePlayer.getClientBrand().split(" ")[0];
        mc.fontRendererObj.drawStringWithShadow(
            ChatHelper.fix("&cEngine: " + brand), 5, 140, 0);
      }

      mc.fontRendererObj
          .drawStringWithShadow(ChatHelper.fix("&cFPS: " + Minecraft.getDebugFPS()), 5, 150, 0);

      mc.fontRendererObj.drawStringWithShadow(ChatHelper.fix(
          String.format("&cCPU Usage: %.2f",
              SystemHelper.getOsBean().getProcessCpuLoad() * 1000 / 10)
              + "&c%"), 5, 160, 0);
      mc.fontRendererObj
              .drawStringWithShadow(ChatHelper.fix(String.format("&cRAM Usage: %s/%s",
                      SystemHelper.humanReadableByteCount(usedMemory, false),
                      SystemHelper.humanReadableByteCount(Runtime.getRuntime().totalMemory(), false))), 5, 170, 0);

      if (Holder.getTPS() != -1) {
        String tps = String.format((Holder.getTPS() > 15 ? "&a%.2f" : (Holder.getTPS() > 10 ? "&e%.2f" : (Holder.getTPS() > 5 ? "&6%.2f" : "&c%.2f"))), Holder.getTPS());

        mc.fontRendererObj
            .drawStringWithShadow(ChatHelper.fix(String.format("&cTPS: %s", tps)), 5, 180, 0);
      }

      if (Holder.getLastPacketMS() != -1) {
        String packetMs = (lastPacketMS < 1000
                ? "&a" + lastPacketMS : (lastPacketMS < 7000
                ? "&e" + lastPacketMS : (lastPacketMS < 15000
                ? "&6" + lastPacketMS : "&c" + lastPacketMS)));


        if (lastPacketMS>1000){
          mc.fontRendererObj
                  .drawStringWithShadow(ChatHelper.fix(String.format("&8&l[&4&lLAG&8&l] &a&l%s&7&lms", packetMs)), 5, 200, 0);

        }


      }
  }
}}
