package com.bb1.defaults;

import java.util.Set;

import com.bb1.enums.NBTType;
import com.bb1.interfaces.NBTTag;
import com.bb1.interfaces.NBTTags;
import com.google.common.collect.Sets;

public class NBTTagCompound implements NBTTags, NBTTag<Object> {

	private static final long serialVersionUID = -8112620672852745399L;

	private final Set<NBTTag<?>> tags = Sets.newConcurrentHashSet();

	private final String key;
	private Object value;

	public NBTTagCompound(String key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	public NBTTagCompound() {
		this.key = "";
		this.value = this.tags;
	}

	@Override
	public Set<NBTTag<?>> getTags() {
		return this.tags;
	}

	@Override
	public void addTag(NBTTag<?> nbtTag) {
		for (NBTTag<?> nbtTag2 : this.tags) {
			if (nbtTag2.getTagKey().equals(nbtTag.getTagKey())) {
				this.tags.remove(nbtTag2);
			}
		}
		this.tags.add(nbtTag);
	}

	@Override
	public void addTag(String key, String value) {
		for (NBTTag<?> nbtTag2 : this.tags) {
			if (nbtTag2.getTagKey().equals(key)) {
				this.tags.remove(nbtTag2);
			}
		}
		this.tags.add(new NBTTagString(key, value));
	}

	@Override
	public NBTTag<?> getTag(String key) {
		for (NBTTag<?> nbtTag : this.tags) {
			if (nbtTag.getTagKey().equals(key)) {
				return nbtTag;
			}
		}
		return new NBTTagString(key, "");
	}

	@Override
	public NBTTag<?> getTagOrDefault(String key, NBTTag<?> defaultTag) {
		for (NBTTag<?> nbtTag : this.tags) {
			if (nbtTag.getTagKey().equals(key)) {
				return nbtTag;
			}
		}
		return defaultTag;
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
		return NBTType.COMPOUND;
	}

}
