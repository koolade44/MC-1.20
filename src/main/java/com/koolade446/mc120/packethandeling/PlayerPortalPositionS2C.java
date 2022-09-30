package com.koolade446.mc120.packethandeling;

import com.koolade446.mc120.client.ClientPortalData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PlayerPortalPositionS2C {
    private final boolean isInPortal;

    public PlayerPortalPositionS2C(boolean portalPos) {
        this.isInPortal = portalPos;
    }

    public PlayerPortalPositionS2C(FriendlyByteBuf buf) {
        this.isInPortal = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(isInPortal);
    }

    public void handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(()->{
            ClientPortalData.setIsInPortal(isInPortal);
        });
    }

}
