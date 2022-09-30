package com.koolade446.mc120.hud.overlay;

import com.koolade446.mc120.MC120;
import com.koolade446.mc120.client.ClientPortalData;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.Overlay;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class DeepDarkPortalOverlay {
    private static final ResourceLocation PORTAL_OVERLAY = new ResourceLocation(MC120.MODID, "textures/overlay/deep_dark_portal_overlay.png");

    public static final IGuiOverlay HUD_PORTAL_OVERLAY = ((gui, poseStack, partialTick, width, height)-> {
       int x = 0;
       int y = 0;
       width = Minecraft.getInstance().getWindow().getGuiScaledWidth();
       height = Minecraft.getInstance().getWindow().getGuiScaledHeight();

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, PORTAL_OVERLAY);
        if (ClientPortalData.getIsInPortal()) {
            GuiComponent.blit(poseStack, x, y, x, y, width, height, width, height);
        }
    });
}
