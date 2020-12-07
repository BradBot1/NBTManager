package com.bb1.defaults;

import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;

public class NBTTagLongArray implements NBTTag<Long[]> {

	private static final long serialVersionUID = -9120939945314267310L;

	private final String key;
	private Long[] value;

	public NBTTagLongArray(String key, Long[] value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getTagKey() {
		return this.key;
	}

	@Override
	public Long[] getTagValue() {
		return this.value;
	}

	@Override
	public String getTagValueAsString() {
		return this.value.toString();
	}

	@Override
	public NBTType getNBTType() {
		return NBTType.LONGARRAY;
	}

}
