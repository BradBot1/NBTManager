package com.bb1;

import java.lang.reflect.Method;

import org.bukkit.inventory.ItemStack;

import com.bb1.defaults.NBTTagCompound;


public class NBTManager {
	
	private static final Class<?> classCraftItemStack = NMS.getCraftNMSClass("inventory.CraftItemStack");
	private static final Class<?> classNMSItemStack = NMS.getNMSClass("ItemStack");
	private static final Class<?> classNMSNBTTagCompound = NMS.getNMSClass("NBTTagCompound");
	
	private static Method methodAsNMSCopyClassCraftItemStack;
	private static Method methodGetTagClassNMSItemStack;
	private static Method methodAsBukkitCopyClassCraftItemStack;
	private static Method methodSetTagClassNMSItemStack;
	
	private static void loadNMS() {
		try {
			methodAsNMSCopyClassCraftItemStack = classCraftItemStack.getMethod("asNMSCopy", ItemStack.class);
			methodGetTagClassNMSItemStack = classNMSItemStack.getMethod("getTag");
			methodAsBukkitCopyClassCraftItemStack = classCraftItemStack.getMethod("asBukkitCopy", classNMSItemStack);
			methodSetTagClassNMSItemStack = classNMSItemStack.getMethod("setTag", classNMSNBTTagCompound);
		} catch (NullPointerException | NoSuchMethodException | SecurityException e) {
			System.err.println("Unable to add NBT to items due to an exception!");
		}
	}
	
	public static ItemStack applyNBTToItemStack(ItemStack itemStack, NBTTagCompound nbtTags) {
		loadNMS();
		try {
            Object NMSItemStack = methodAsNMSCopyClassCraftItemStack.invoke(null, itemStack);
            methodSetTagClassNMSItemStack.invoke(NMSItemStack, nbtTags.getAsNMSTag());
            Object o2 = methodAsBukkitCopyClassCraftItemStack.invoke(null, NMSItemStack);
			if (o2 instanceof ItemStack) {
				return (ItemStack) o2;
			} else {
				return itemStack;
			}
		} catch (Exception ignore) {
			ignore.printStackTrace();
			return itemStack;
		}
	}
	
	public static NBTTagCompound getNBTFromItemStack(ItemStack itemStack) {
		loadNMS();
		if (itemStack==null) return new NBTBuilder().build();;
		try {
			Object NMSItemStack = methodAsNMSCopyClassCraftItemStack.invoke(null, itemStack);
			Object NBTCompoundTag = methodGetTagClassNMSItemStack.invoke(NMSItemStack);
			return new NBTBuilder(NBTCompoundTag).build();
		} catch (Exception ingore) {}
		return new NBTBuilder().build();
	}
	
}
