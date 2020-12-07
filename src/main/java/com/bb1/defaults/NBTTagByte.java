package com.bb1.defaults;

import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;

public class NBTTagByte implements NBTTag<Byte> {

	private static final long serialVersionUID = -5988330344814968408L;

	private final String key;
	private Byte value;

	public NBTTagByte(String key, Byte value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getTagKey() {
		return this.key;
	}

	@Override
	public Byte getTagValue() {
		return this.value;
	}

	@Override
	public String getTagValueAsString() {
		return Byte.toString(this.value);
	}

	@Override
	public NBTType getNBTType() {
		return NBTType.BYTE;
	}

}
