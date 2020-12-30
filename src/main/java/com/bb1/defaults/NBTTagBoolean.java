package com.bb1.defaults;

import com.bb1.NBTTag;

import lombok.SneakyThrows;

public class NBTTagBoolean extends NBTTag<Boolean> {

	public NBTTagBoolean(String key, Boolean value) {
		super(key, value);
	}

	@Override
	public String getName() {
		return "Boolean";
	}

	@SneakyThrows
	@Override
	public Object addToNMSTag(Object nmsTag) {
		return nmsTag.getClass().getMethod("setBoolean", String.class, boolean.class).invoke(nmsTag, getKey(), getValue());
	}
	
}
