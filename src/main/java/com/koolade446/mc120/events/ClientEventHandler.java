package com.koolade446.mc120.events;

import com.koolade446.mc120.MC120;
import com.koolade446.mc120.hud.overlay.DeepDarkPortalOverlay;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEventHandler {
    @Mod.EventBusSubscriber(modid = MC120.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ClientForgeEventHandler {
        //Nothing here yet
    }

    @Mod.EventBusSubscriber(modid = MC120.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEventHandler {
        @SubscribeEvent
        public static void registerGuiOverlay(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("dd_portal", DeepDarkPortalOverlay.HUD_PORTAL_OVERLAY);
        }
    }
}
