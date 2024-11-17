package net.hydra.jojomod.client;


import net.hydra.jojomod.networking.ModPacketHandler;
import net.hydra.jojomod.util.Config;
import net.hydra.jojomod.util.ConfigManager;

public class ClientNetworking {
    private static boolean isConnectedToDedicated = false;
    private static boolean displayNewConfigToast = false;
    private static boolean refreshScreen = false;

    public static Config getAppropriateConfig(){
        if (isConnectedToDedicated){
            return Config.getServerInstance();
        }
        return Config.getLocalInstance();
    }

    public static void initialize(boolean connected, String ser){
        isConnectedToDedicated = connected;
        ConfigManager.deserializeConfig(ser);
        if (!isConnectedToDedicated) return;

        ConfigManager.deserializeConfig(ser);
    }
    public static void sendHandshake() {
        ModPacketHandler.PACKET_ACCESS.handshake();
    }

    private static void requestConfigFromServer() {
        sendHandshake();
    }

    public static boolean isConnectedToDedicated() {
        return isConnectedToDedicated;
    }
}
