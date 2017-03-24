package com.zathruswriter.packetrecorder;

import org.bukkit.plugin.java.JavaPlugin;

public class PacketRecorder extends JavaPlugin {
	
	@Override
    public void onEnable() {
		this.getLogger().info("We are enabled!");
	}
	
	@Override
	public void onDisable() {
		this.getLogger().info("Disabling plugin...");
	}
	
}