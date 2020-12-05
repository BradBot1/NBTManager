package com.bb1.defaults;

import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;

public class NBTTagLong implements NBTTag<Long> {

	private static final long serialVersionUID = 924794517068514539L;

	private final String key;
	private Long value;

	public NBTTagLong(String key, Long value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getTagKey() {
		return this.key;
	}

	@Override
	public Long getTagValue() {
		return this.value;
	}

	@Override
	public String getTagValueAsString() {
		return Long.toString(this.value);
	}

	@Override
	public NBTType getNBTType() {
		return NBTType.LONG;
	}

}
