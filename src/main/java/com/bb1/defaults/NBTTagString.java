package com.bb1.defaults;

import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;

public class NBTTagString implements NBTTag<String> {

	private static final long serialVersionUID = 924794517068514539L;

	private final String key;
	private String value;

	public NBTTagString(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getTagKey() {
		return this.key;
	}

	@Override
	public String getTagValue() {
		return this.value;
	}

	@Override
	public String getTagValueAsString() {
		return this.value;
	}


	@Override
	public NBTType getNBTType() {
		return NBTType.STRING;
	}

}
