package com.bb1.defaults;

import com.bb1.NBTTag;

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
	public Object addToNMSTag(Object nmsTag) {
		return nmsTag.getClass().getMethod("setInt", String.class, int.class).invoke(nmsTag, getKey(), getValue());
	}
	
}
