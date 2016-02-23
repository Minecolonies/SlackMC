package com.compwiz1548.slack.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import java.util.List;

public class Utils {
    public static String getPlayerList(MinecraftServer server) {
        List<EntityPlayer> playerList = MinecraftServer.getServer().getConfigurationManager().playerEntityList;

        StringBuilder s = new StringBuilder();
        for (EntityPlayer entityPlayer : playerList) {
            s.append(entityPlayer.getGameProfile().getName());
            s.append(", ");
        }
        return s.length() > 0 ? s.substring(0, s.length() - 2) : "";
    }
}
