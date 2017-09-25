package com.learning.roboticmaneuvers.util;

/**
 * Created by devdeepak02 on 9/24/17.
 */
public enum DirectionEnum {


    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private final String value;

    DirectionEnum(String value) {
        this.value = value;
    }

    public static DirectionEnum find(String val) {
        for (DirectionEnum e : DirectionEnum.values()) {
            if (e.value.equalsIgnoreCase(val))
                return e;
        }
        throw new IllegalStateException(String.format("Unsupported type %s.", val));
    }
}
