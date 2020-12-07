package com.bb1.defaults;

import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;

public class NBTTagDouble implements NBTTag<Double> {

	private static final long serialVersionUID = -4103208056790709738L;

	private final String key;
	private Double value;

	public NBTTagDouble(String key, Double value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getTagKey() {
		return this.key;
	}

	@Override
	public Double getTagValue() {
		return this.value;
	}

	@Override
	public String getTagValueAsString() {
		return Double.toString(this.value);
	}

	@Override
	public NBTType getNBTType() {
		return NBTType.DOUBLE;
	}

}
