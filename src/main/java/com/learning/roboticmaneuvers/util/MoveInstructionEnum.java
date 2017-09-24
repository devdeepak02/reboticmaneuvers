package com.learning.roboticmaneuvers.util;

/**
 * Created by devdeepak02 on 9/24/17.
 */
public enum MoveInstructionEnum {

    Move('M'),
    LEFT('L'),
    RIGHT('R');

    private final char value;

    MoveInstructionEnum(char value) {
        this.value = value;
    }
}
