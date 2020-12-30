package com.bb1.defaults;

import com.bb1.NBTTag;

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
	public Object addToNMSTag(Object nmsTag) {
		return nmsTag.getClass().getMethod("setByte", String.class, byte.class).invoke(nmsTag, getKey(), getValue());
	}
	
}
