package com.bb1;

import org.bukkit.Bukkit;

public class NMS {
	
	private static String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
	private static String serverVersion = "net.minecraft.server." + version;
	private static String craftServerVersion = "org.bukkit.craftbukkit." + version;
	
	public static String getVersion() {
		return version;
	}
	
	public static String getNMS() {
		return serverVersion+".";
	}
	
	public static String getCraftNMS() {
		return craftServerVersion+".";
	}
	
	public static Class<?> getNMSClass(String className) {
		try {
			return Class.forName(getNMS()+className);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	
	public static Class<?> getCraftNMSClass(String className) {
		try {
			return Class.forName(getCraftNMS()+className);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	
}
