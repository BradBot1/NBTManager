package com.bb1.defaults;

import com.bb1.NBTTag;
import com.bb1.NMS;

import lombok.SneakyThrows;

public class NBTTagInteger extends NBTTag<Integer> {

	public NBTTagInteger(String key, Integer value) {
		super(key, value);
	}

	@Override
	public String getName() {
		return "Integer";
	}

	@SneakyThrows
	@Override
	public void addToNMSTag(Object nmsTag) {
		NMS.getNMSClass("NBTTagCompound").getMethod("setInt", String.class, int.class).invoke(nmsTag, getKey(), getValue());
	}
	
}
