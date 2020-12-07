package com.bb1.defaults;

import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;

public class NBTTagIntegerArray implements NBTTag<Integer[]> {

	private static final long serialVersionUID = -2906003327158617307L;
	
	private final String key;
	private Integer[] value;

	public NBTTagIntegerArray(String key, Integer[] value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getTagKey() {
		return this.key;
	}

	@Override
	public Integer[] getTagValue() {
		return this.value;
	}

	@Override
	public String getTagValueAsString() {
		return this.value.toString();
	}

	@Override
	public NBTType getNBTType() {
		return NBTType.INTEGERARRAY;
	}

}
