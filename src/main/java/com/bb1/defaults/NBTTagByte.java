package com.bb1.defaults;

import com.bb1.NBTTag;
import com.bb1.NMS;

import lombok.SneakyThrows;

public class NBTTagByte extends NBTTag<Byte> {

	public NBTTagByte(String key, Byte value) {
		super(key, value);
	}

	@Override
	public String getName() {
		return "Byte";
	}

	@SneakyThrows
	@Override
	public void addToNMSTag(Object nmsTag) {
		NMS.getNMSClass("NBTTagCompound").getMethod("setByte", String.class, byte.class).invoke(nmsTag, getKey(), getValue());
	}
	
}
