package com.bb1.defaults;

import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;

public class NBTTagUnknown implements NBTTag<Object> {

	private static final long serialVersionUID = -4014534655839363202L;

	private final String key;
	private final Object value;

	public NBTTagUnknown(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getTagKey() {
		return this.key;
	}

	@Override
	public Object getTagValue() {
		return this.value;
	}

	@Override
	public String getTagValueAsString() {
		return this.value.toString();
	}


	@Override
	public NBTType getNBTType() {
		return NBTType.UNKNOWN;
	}

}
