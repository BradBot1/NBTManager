package com.bb1.interfaces;

import java.io.Serializable;
import java.util.Set;

public interface NBTTags extends Serializable {
	
	public Set<NBTTag<?>> getTags();
	
	public NBTTag<?> getTag(String key);
	
	public NBTTag<?> getTagOrDefault(String key, NBTTag<?> defaultTag);
	
	public void addTag(NBTTag<?> nbtTag);
	
	public void addTag(String key, String value);
	
}
