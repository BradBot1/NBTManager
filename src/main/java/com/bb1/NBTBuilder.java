package com.bb1;

import java.util.ArrayList;
import java.util.List;

import com.bb1.defaults.NBTTagBoolean;
import com.bb1.defaults.NBTTagByte;
import com.bb1.defaults.NBTTagCompound;
import com.bb1.defaults.NBTTagDouble;
import com.bb1.defaults.NBTTagInteger;
import com.bb1.defaults.NBTTagLong;
import com.bb1.defaults.NBTTagShort;
import com.bb1.defaults.NBTTagString;

import lombok.SneakyThrows;

public final class NBTBuilder {
	
	private static final Class<?> NBTCOMPOUND = NMS.getNMSClass("NBTTagCompound");
	
	private Object tag;
	
	private List<NBTTag<?>> tagsToAdd = new ArrayList<>();
	
	@SneakyThrows
	public NBTBuilder() {
		tag = NBTCOMPOUND.newInstance();
	}
	
	@SneakyThrows
	public NBTBuilder(Object tag) {
		if (tag==null || !tag.getClass().equals(NBTCOMPOUND)) {
			this.tag = NMS.getNMSClass("NBTTagCompound").newInstance();
		} else {
			this.tag = tag;
		}
	}
		
	public NBTBuilder setTag(NBTTag<?> tag) {
		tagsToAdd.add(tag);
		return this;
	}
	
	public NBTBuilder setString(String key, String value) {
		return setTag(new NBTTagString(key, value));
	}
	
	public NBTBuilder setInt(String key, int value) {
		return setTag(new NBTTagInteger(key, value));
	}
	
	public NBTBuilder setLong(String key, long value) {
		return setTag(new NBTTagLong(key, value));
	}
	
	public NBTBuilder setDouble(String key, double value) {
		return setTag(new NBTTagDouble(key, value));
	}
	
	public NBTBuilder setShort(String key, short value) {
		return setTag(new NBTTagShort(key, value));
	}
	
	public NBTBuilder setByte(String key, byte value) {
		return setTag(new NBTTagByte(key, value));
	}
	
	public NBTBuilder setBoolean(String key, boolean value) {
		return setTag(new NBTTagBoolean(key, value));
	}
	
	public synchronized NBTTagCompound build() {
		for (NBTTag<?> tag : tagsToAdd) {
			this.tag = tag.addToNMSTag(tag);
		}
		return new NBTTagCompound(tag);
	}
}
