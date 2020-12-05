package com.bb1.interfaces;

import java.io.Serializable;

import com.bb1.enums.NBTType;

public interface NBTTag<E> extends Serializable {
	
	public String getTagKey();
	
	public E getTagValue();
	
	public String getTagValueAsString();
	
	public NBTType getNBTType();
	
}
