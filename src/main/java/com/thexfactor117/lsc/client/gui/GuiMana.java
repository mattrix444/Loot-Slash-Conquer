package com.thexfactor117.lsc.client.gui;

import org.lwjgl.opengl.GL11;

import com.thexfactor117.lsc.capabilities.implementation.LSCPlayerCapability;
import com.thexfactor117.lsc.config.Configs;
import com.thexfactor117.lsc.util.PlayerUtil;
import com.thexfactor117.lsc.util.misc.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiMana extends Gui {
    private static final ResourceLocation MANA_BAR_TEXTURE = new ResourceLocation(Reference.MODID, "textures/gui/mana.png");

    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent.Post event) {
        if (!Configs.renderingCategory.renderCustomManabar || event.getType() != ElementType.EXPERIENCE) return;

        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.player;
        
        if (!player.capabilities.isCreativeMode) {
            LSCPlayerCapability cap = PlayerUtil.getLSCPlayer(player);
            
            if (cap != null && cap.getMaxMana() != 0) {
                ScaledResolution sr = event.getResolution();
                double manaBarWidth = (double) cap.getMana() / cap.getMaxMana() * 81.0;
                int xPos = sr.getScaledWidth() / 2 + 10;
                int yPos = sr.getScaledHeight() - 38;
                
                mc.getTextureManager().bindTexture(MANA_BAR_TEXTURE);
                this.drawTexturedModalRect(xPos, yPos, 0, 18, 81, 6);
                this.drawTexturedModalRect(xPos, yPos, 0, 24, (int) manaBarWidth, 5);
            }
        }
    }

    @SubscribeEvent
    public void onRenderOverlayText(RenderGameOverlayEvent.Text event) {
        if (!Configs.renderingCategory.renderCustomManabar) return;

        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.player;
        LSCPlayerCapability cap = PlayerUtil.getLSCPlayer(player);
        
        if (!player.capabilities.isCreativeMode && cap != null) {
            String mana = cap.getMana() + " / " + cap.getMaxMana();
            ScaledResolution sr = event.getResolution();
            
            GL11.glPushMatrix();
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            mc.fontRenderer.drawStringWithShadow(mana, (sr.getScaledWidth() / 2 + 37) * 2, (sr.getScaledHeight() - 37) * 2, 0xFFFFFF);
            GL11.glPopMatrix();
        }
    }
}
