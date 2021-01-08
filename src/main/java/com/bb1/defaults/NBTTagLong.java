package com.bb1.defaults;

import com.bb1.NBTTag;
import com.bb1.NMS;

import lombok.SneakyThrows;

public class NBTTagLong extends NBTTag<Long> {

	public NBTTagLong(String key, Long value) {
		super(key, value);
	}

	@Override
	public String getName() {
		return "Long";
	}

	@SneakyThrows
	@Override
	public void addToNMSTag(Object nmsTag) {
		NMS.getNMSClass("NBTTagCompound").getMethod("setLong", String.class, long.class).invoke(nmsTag, getKey(), getValue());
	}
	
}
