package com.koolade446.mc120.client;

public class ClientPortalData {
    private static boolean playerIsInPortal;
    private static long playerPortalCoolDownTime;

    public static void setPlayerPortalCoolDownTime(long playerPortalCoolDownTime) {
        ClientPortalData.playerPortalCoolDownTime = playerPortalCoolDownTime;
    }

    public static long getPlayerPortalCoolDownTime() {
        return playerPortalCoolDownTime;
    }

    public static void setIsInPortal(boolean value) {
        playerIsInPortal = value;
    }

    public static boolean getIsInPortal() {
        return playerIsInPortal;
    }
}
