package com.bb1.defaults;

import com.bb1.NBTTag;

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
	public Object addToNMSTag(Object nmsTag) {
		return nmsTag.getClass().getMethod("setString", String.class, String.class).invoke(nmsTag, getKey(), getValue());
	}
	
}
