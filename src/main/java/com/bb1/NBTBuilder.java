package com.bb1;

import com.bb1.defaults.NBTTagCompound;

public final class NBTBuilder {
	
	private final NBTTagCompound tag;
	
	public NBTBuilder() {
		this(null);
	}
	
	public NBTBuilder(Object tag) {
		this.tag = new NBTTagCompound(tag);
	}
	
	public NBTBuilder setString(String key, String value) {
		this.tag.setString(key, value);
		return this;
	}
	
	public NBTBuilder setInt(String key, int value) {
		this.tag.setInt(key, value);
		return this;
	}
	
	public NBTBuilder setLong(String key, long value) {
		this.tag.setLong(key, value);
		return this;
	}
	
	public NBTBuilder setDouble(String key, double value) {
		this.tag.setDouble(key, value);
		return this;
	}
	
	public NBTBuilder setShort(String key, short value) {
		this.tag.setShort(key, value);
		return this;
	}
	
	public NBTBuilder setByte(String key, byte value) {
		this.tag.setByte(key, value);
		return this;
	}
	
	public NBTBuilder setBoolean(String key, boolean value) {
		this.tag.setBoolean(key, value);
		return this;
	}
	
	public NBTTagCompound build() {
		return this.tag;
	}
}
