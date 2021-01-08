package com.bb1.defaults;

import com.bb1.NBTTag;
import com.bb1.NMS;

import lombok.SneakyThrows;

public class NBTTagCompound {
	
	private static final Class<?> NBTCOMPOUND = NMS.getNMSClass("NBTTagCompound");
	
	protected final Object tag;
	
	@SneakyThrows
	public NBTTagCompound(Object tag) {
		if (tag==null || !tag.getClass().equals(NBTCOMPOUND)) {
			this.tag = NBTCOMPOUND.newInstance();
		} else {
			this.tag = tag;
		}
	}
	
	protected void setTag(NBTTag<?> tag) {
		tag.addToNMSTag(this.tag);
	}
	
	public void setString(String key, String value) {
		setTag(new NBTTagString(key, value));
	}
	
	public void setInt(String key, int value) {
		setTag(new NBTTagInteger(key, value));
	}
	
	public void setLong(String key, long value) {
		setTag(new NBTTagLong(key, value));
	}
	
	public void setDouble(String key, double value) {
		setTag(new NBTTagDouble(key, value));
	}
	
	public void setShort(String key, short value) {
		setTag(new NBTTagShort(key, value));
	}
	
	public void setByte(String key, byte value) {
		setTag(new NBTTagByte(key, value));
	}
	
	public void setBoolean(String key, boolean value) {
		setTag(new NBTTagBoolean(key, value));
	}
	
	@SneakyThrows
	public NBTTag<String> getString(String key) {
		try {
			return new NBTTagString(key, (String) NBTCOMPOUND.getMethod("getString", String.class).invoke(tag, key));
		} catch (Exception e) {
			return new NBTTagString(key, null);
		}
	}
	
	@SneakyThrows
	public NBTTag<Integer> getInt(String key) {
		try {
			return new NBTTagInteger(key, (int) NBTCOMPOUND.getMethod("getInt", String.class).invoke(tag, key));
		} catch (Exception e) {
			return new NBTTagInteger(key, null);
		}
	}
	
	@SneakyThrows
	public NBTTag<Long> getLong(String key) {
		try {
			return new NBTTagLong(key, (long) NBTCOMPOUND.getMethod("getLong", String.class).invoke(tag, key));
		} catch (Exception e) {
			return new NBTTagLong(key, null);
		}
	}
	
	@SneakyThrows
	public NBTTag<Double> getDouble(String key) {
		try {
			return new NBTTagDouble(key, (double) NBTCOMPOUND.getMethod("getDouble", String.class).invoke(tag, key));
		} catch (Exception e) {
			return new NBTTagDouble(key, null);
		}
	}
	
	@SneakyThrows
	public NBTTag<Short> getShort(String key) {
		try {
			return new NBTTagShort(key, (short) NBTCOMPOUND.getMethod("getShort", String.class).invoke(tag, key));
		} catch (Exception e) {
			return new NBTTagShort(key, null);
		}
	}
	
	@SneakyThrows
	public NBTTag<Byte> getByte(String key) {
		try {
			return new NBTTagByte(key, (byte) NBTCOMPOUND.getMethod("getByte", String.class).invoke(tag, key));
		} catch (Exception e) {
			return new NBTTagByte(key, null);
		}
	}
	
	@SneakyThrows
	public NBTTag<Boolean> getBoolean(String key) {
		try {
			return new NBTTagBoolean(key, (boolean) NBTCOMPOUND.getMethod("getBoolean", String.class).invoke(tag, key));
		} catch (Exception e) {
			return new NBTTagBoolean(key, null);
		}
	}
	
	@SneakyThrows
	public Object getAsNMSTag() {
		return this.tag;
	}
	
}
