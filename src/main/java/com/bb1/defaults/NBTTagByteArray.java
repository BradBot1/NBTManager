package com.bb1.defaults;

import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;

public class NBTTagByteArray implements NBTTag<Byte[]> {

	private static final long serialVersionUID = 3131829143409955227L;

	private final String key;
	private Byte[] value;

	public NBTTagByteArray(String key, Byte[] value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getTagKey() {
		return this.key;
	}

	@Override
	public Byte[] getTagValue() {
		return this.value;
	}

	@Override
	public String getTagValueAsString() {
		return (this.value==null) ? "" : this.value.toString();
	}

	@Override
	public NBTType getNBTType() {
		return NBTType.BYTEARRAY;
	}

}
