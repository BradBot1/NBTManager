package com.bb1.defaults;

import com.bb1.NBTTag;

import lombok.SneakyThrows;

public class NBTTagShort extends NBTTag<Short> {

	public NBTTagShort(String key, Short value) {
		super(key, value);
	}

	@Override
	public String getName() {
		return "Short";
	}

	@SneakyThrows
	@Override
	public Object addToNMSTag(Object nmsTag) {
		return nmsTag.getClass().getMethod("setShort", String.class, short.class).invoke(nmsTag, getKey(), getValue());
	}
	
}
