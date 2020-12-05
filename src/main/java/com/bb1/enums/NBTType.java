package com.bb1.enums;

import lombok.Getter;

public enum NBTType {
	COMPOUND(null, ""),
	STRING(String.class, "String"),
	INTEGER(int.class, "Int"),
	FLOAT(float.class, "Float"),
	DOUBLE(double.class, "Double"),
	LONG(long.class, "Long"),
	;
	
	private final @Getter Class<?> type;
	private final @Getter String name;
	
	NBTType(Class<?> type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public static NBTType getTagByID(byte id) {
        switch (id) {
            //case 1:
                //return BYTE;
            //case 2:
                //return SHORT;
            //case 3:
                //return INT;
            case 4:
                return LONG;
            case 5:
                return FLOAT;
            case 6:
                return DOUBLE;
            //case 7:
                //return BYTEARRAY;
            case 8:
                return STRING;
            //case 9:
                //return LIST;
            case 10:
                return COMPOUND;
            //case 11:
                //return INTARRAY;
            //case 100:
                //return BOOLEAN;
            default:
               return null;
        }
    }
}
