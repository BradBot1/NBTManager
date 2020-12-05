package com.bb1.defaults;

import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;

public class NBTTagFloat implements NBTTag<Float> {

	private static final long serialVersionUID = 924794517068514539L;

	private final String key;
	private Float value;

	public NBTTagFloat(String key, Float value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getTagKey() {
		return this.key;
	}

	@Override
	public Float getTagValue() {
		return this.value;
	}

	@Override
	public String getTagValueAsString() {
		return Float.toString(this.value);
	}

	@Override
	public NBTType getNBTType() {
		return NBTType.FLOAT;
	}

}
