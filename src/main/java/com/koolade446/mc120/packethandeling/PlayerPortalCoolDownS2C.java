package com.koolade446.mc120.packethandeling;

import com.koolade446.mc120.client.ClientPortalData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PlayerPortalCoolDownS2C {
    private final long coolDownTime;

    public PlayerPortalCoolDownS2C(long coolDownTime) {
        this.coolDownTime = coolDownTime;
    }

    public PlayerPortalCoolDownS2C(FriendlyByteBuf buf) {
        this.coolDownTime = buf.readLong();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeLong(coolDownTime);
    }

    public void handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(()-> ClientPortalData.setPlayerPortalCoolDownTime(coolDownTime));
    }

}
