package com.zathruswriter.packetrecorder;

import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

public class PacketRecorder extends JavaPlugin {

	private ProtocolManager protocolManager;
	
	public static boolean isRecording = true;
	
	@Override
    public void onEnable() {
		this.getLogger().info("We are enabled!");
		this.protocolManager = ProtocolLibrary.getProtocolManager();
		this.addListener(PacketType.Play.Server.CHAT);
	}

	@Override
	public void onDisable() {
		this.getLogger().info("Disabling plugin...");
	}

	private void addListener(PacketType pType) {
		this.protocolManager.addPacketListener(
		  new PacketAdapter(this, ListenerPriority.LOWEST, pType) {
		    @Override
		    public void onPacketSending(PacketEvent event) {
		        if (event.getPacketType() == pType) {
		            //event.setCancelled(true);
		        	if (PacketRecorder.isRecording) {
		        		System.out.println("packet " + pType.getPacketClass().getName() + " would be recorded now");
		        	}
		        }
		    }
		});
	}
	
}