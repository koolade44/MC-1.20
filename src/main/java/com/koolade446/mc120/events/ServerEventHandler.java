package com.koolade446.mc120.events;

import com.koolade446.mc120.MC120;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

public class ServerEventHandler {
    @Mod.EventBusSubscriber(modid = MC120.MODID, value = Dist.DEDICATED_SERVER, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ServerForgeEventHandler {
        //Nothing here yet
    }

    @Mod.EventBusSubscriber(modid = MC120.MODID, value = Dist.DEDICATED_SERVER, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ServerModEventHandler {
    }
}
