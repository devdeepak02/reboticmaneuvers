package com.learning.roboticmaneuvers.util;

/**
 * Created by devdeepak02 on 9/24/17.
 */
public enum MoveInstructionEnum {

    Move("M"),
    LEFT("L"),
    RIGHT("R");

    private final String value;

    MoveInstructionEnum(String value) {
        this.value = value;
    }

    public static MoveInstructionEnum find(String val) {
        for (MoveInstructionEnum e : MoveInstructionEnum.values()) {
            if (e.value.equalsIgnoreCase(val))
                return e;
        }
        throw new IllegalStateException(String.format("Unsupported type %s.", val));
    }
}
