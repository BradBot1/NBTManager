package com.bb1;

import java.lang.reflect.Method;
import java.util.Set;

import org.bukkit.inventory.ItemStack;

import com.bb1.defaults.NBTTagCompound;
import com.bb1.defaults.NBTTagDouble;
import com.bb1.defaults.NBTTagFloat;
import com.bb1.defaults.NBTTagInteger;
import com.bb1.defaults.NBTTagString;
import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;
import com.bb1.interfaces.NBTTags;

public class NBTManager {
	
	private static final Class<?> classCraftItemStack = NMS.getCraftNMSClass("inventory.CraftItemStack");
	private static final Class<?> classNMSItemStack = NMS.getNMSClass("ItemStack");
	private static final Class<?> classNMSNBTTagCompound = NMS.getNMSClass("NBTTagCompound");
	private static final Class<?> classNMSNBTBase = NMS.getNMSClass("NBTBase");
	
	private static Method methodAsNMSCopyClassCraftItemStack;
	private static Method methodGetTagClassNMSItemStack;
	private static Method methodGetClassNMSNBTTagCompound;
	private static Method methodGetKeysClassNMSNBTTagCompound;
	private static Method methodAsBukkitCopyClassCraftItemStack;
	private static Method methodSetTagClassNMSItemStack;
	private static Method methodGetTypeIDClassNMSNBTBase;
	
	private static void loadNMS() {
		try {
			methodAsNMSCopyClassCraftItemStack = classCraftItemStack.getMethod("asNMSCopy", ItemStack.class);
			methodGetTagClassNMSItemStack = classNMSItemStack.getMethod("getTag");
			methodGetClassNMSNBTTagCompound = classNMSNBTTagCompound.getMethod("get", String.class);
			methodGetKeysClassNMSNBTTagCompound = classNMSNBTTagCompound.getMethod("getKeys");
			methodGetClassNMSNBTTagCompound = classNMSNBTTagCompound.getMethod("get", String.class);
			methodAsBukkitCopyClassCraftItemStack = classCraftItemStack.getMethod("asBukkitCopy", classNMSItemStack);
			methodSetTagClassNMSItemStack = classNMSItemStack.getMethod("setTag", classNMSNBTTagCompound);
			methodGetTypeIDClassNMSNBTBase = classNMSNBTBase.getMethod("getTypeId");
		} catch (NullPointerException | NoSuchMethodException | SecurityException e) {
			System.err.println("Unable to add NBT to items due to an exception!");
		}
	}
	
	public static ItemStack applyNBTToItemStack(ItemStack itemStack, NBTTags nbtTags) {
		loadNMS();
		try {
            methodAsNMSCopyClassCraftItemStack.setAccessible(true);
            methodSetTagClassNMSItemStack.setAccessible(true);
            methodAsBukkitCopyClassCraftItemStack.setAccessible(true);
            methodGetTagClassNMSItemStack.setAccessible(true);

            Object NMSItemStack = methodAsNMSCopyClassCraftItemStack.invoke(null, itemStack);
            Object NBTCompoundTag = methodGetTagClassNMSItemStack.invoke(NMSItemStack);
            if (NBTCompoundTag==null) NBTCompoundTag = classNMSNBTTagCompound.newInstance();
            
            for (NBTTag<?> nbtTag : nbtTags.getTags()) {
				Method set = classNMSNBTTagCompound.getMethod("set"+nbtTag.getNBTType().getName(), String.class, nbtTag.getNBTType().getType());
				set.setAccessible(true);
				set.invoke(NBTCompoundTag, nbtTag.getTagKey(), nbtTag.getTagValue());
			}
            
            methodSetTagClassNMSItemStack.invoke(NMSItemStack, NBTCompoundTag);
            Object o2 = methodAsBukkitCopyClassCraftItemStack.invoke(null, NMSItemStack);
			
			if (o2 instanceof ItemStack) {
				return (ItemStack) o2;
			} else {
				return itemStack;
			}
		} catch (Exception ignore) {
			return itemStack;
		}
	}
	
	public static NBTTags getNBTFromItemStack(ItemStack itemStack) {
		loadNMS();
		NBTTags tags = new NBTTagCompound();
		if (itemStack==null) return tags;
		try {
			Object NMSItemStack = methodAsNMSCopyClassCraftItemStack.invoke(null, itemStack);
			Object NBTCompoundTag = methodGetTagClassNMSItemStack.invoke(NMSItemStack);
			if (NBTCompoundTag==null) {
				return tags;
			}
			Object NBTKeySetObject = methodGetKeysClassNMSNBTTagCompound.invoke(NBTCompoundTag);
			
			if (NBTKeySetObject instanceof Set<?>) {
				Set<?> NBTKeySet = (Set<?>) NBTKeySetObject;
				for (Object key : NBTKeySet) {
					Object base = methodGetClassNMSNBTTagCompound.invoke(NBTCompoundTag, key);
					Object byteValue = methodGetTypeIDClassNMSNBTBase.invoke(base);
					NBTType type = NBTType.getTagByID((byte) byteValue);
					Method get = classNMSNBTTagCompound.getMethod("get"+type.getName(), String.class);
					Object value = get.invoke(NBTCompoundTag, key);
					NBTTag<?> tag;
					if (value instanceof Integer) {
						tag = new NBTTagInteger(key.toString(), (Integer) value);
					} else if (value instanceof Float) {
						tag = new NBTTagFloat(key.toString(), (Float) value);
					} else if (value instanceof Double) {
						tag = new NBTTagDouble(key.toString(), (Double) value);
					} else {
						tag = new NBTTagString(key.toString(), value.toString());
					}
					tags.addTag(tag);
				}
			}
		} catch (Exception ingore) {}
		return tags;
	}
	
}
