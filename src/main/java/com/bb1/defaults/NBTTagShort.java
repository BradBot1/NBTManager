package com.bb1.defaults;

import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;

public class NBTTagShort implements NBTTag<Short> {

	private static final long serialVersionUID = -6989030022210816038L;
	
	private final String key;
	private Short value;

	public NBTTagShort(String key, Short value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getTagKey() {
		return this.key;
	}

	@Override
	public Short getTagValue() {
		return this.value;
	}

	@Override
	public String getTagValueAsString() {
		return Short.toString(this.value);
	}

	@Override
	public NBTType getNBTType() {
		return NBTType.SHORT;
	}

}
