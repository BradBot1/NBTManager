package com.bb1.defaults;

import com.bb1.NBTTag;
import com.bb1.NMS;

import lombok.SneakyThrows;

public class NBTTagString extends NBTTag<String> {

	public NBTTagString(String key, String value) {
		super(key, value);
	}

	@Override
	public String getName() {
		return "String";
	}

	@SneakyThrows
	@Override
	public void addToNMSTag(Object nmsTag) {
		NMS.getNMSClass("NBTTagCompound").getMethod("setString", String.class, String.class).invoke(nmsTag, getKey(), getValue());
	}
	
}
