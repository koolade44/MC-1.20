package com.koolade446.mc120.client;

public class ClientPortalData {
    private static boolean playerIsInPortal;

    public static void setIsInPortal(boolean value) {
        playerIsInPortal = value;
    }

    public static boolean getIsInPortal() {
        return playerIsInPortal;
    }
}
