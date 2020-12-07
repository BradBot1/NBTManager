package com.bb1.defaults;

import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;

public class NBTTagBoolean implements NBTTag<Boolean> {

	private static final long serialVersionUID = -227032451606029539L;

	private final String key;
	private Boolean value;

	public NBTTagBoolean(String key, Boolean value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getTagKey() {
		return this.key;
	}

	@Override
	public Boolean getTagValue() {
		return this.value;
	}

	@Override
	public String getTagValueAsString() {
		return Boolean.toString(this.value);
	}

	@Override
	public NBTType getNBTType() {
		return NBTType.BOOLEAN;
	}

}
