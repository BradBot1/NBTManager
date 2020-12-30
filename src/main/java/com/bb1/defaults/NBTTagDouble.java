package com.bb1.defaults;

import com.bb1.NBTTag;

import lombok.SneakyThrows;

public class NBTTagDouble extends NBTTag<Double> {

	public NBTTagDouble(String key, Double value) {
		super(key, value);
	}

	@Override
	public String getName() {
		return "Double";
	}

	@SneakyThrows
	@Override
	public Object addToNMSTag(Object nmsTag) {
		return nmsTag.getClass().getMethod("setDouble", String.class, double.class).invoke(nmsTag, getKey(), getValue());
	}
	
}
