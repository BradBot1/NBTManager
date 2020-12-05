package com.bb1.defaults;

import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;

public class NBTTagInteger implements NBTTag<Integer> {

	private static final long serialVersionUID = 924794517068514539L;

	private final String key;
	private Integer value;

	public NBTTagInteger(String key, Integer value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getTagKey() {
		return this.key;
	}

	@Override
	public Integer getTagValue() {
		return this.value;
	}

	@Override
	public String getTagValueAsString() {
		return Integer.toString(this.value);
	}

	@Override
	public NBTType getNBTType() {
		return NBTType.INTEGER;
	}

}
