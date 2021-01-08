package com.bb1;

public abstract class NBTTag<E> {
	
	protected final String key;
	
	protected E value;
	/**
	 * Initialises the class
	 */
	protected NBTTag(String key, E value) {
		this.key = key;
		this.value = value;
	}
	/**
	 * The {@link NBTTag}'s name
	 */
	public abstract String getName();
	/**
	 * The {@link NBTTag}'s key
	 */
	public String getKey() { return this.key; };
	/**
	 * Changes the {@link NBTTag}'s value
	 */
	public void setKey(E newValue) { this.value=newValue; };
	/**
	 * The {@link NBTTag}'s value
	 */
	public E getValue() { return this.value; };
	/**
	 * Adds this tag to the given compound tag
	 * @param nmsTag The compound tag this will be added to
	 */
	public abstract void addToNMSTag(Object nmsTag);
}
