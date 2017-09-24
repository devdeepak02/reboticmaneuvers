package com.learning.roboticmaneuvers.util;

/**
 * Created by devdeepak02 on 9/24/17.
 */
public enum DirectionEnum {


    NORTH(1),
    SOUTH(2),
    EAST(3),
    WEST(4);

    private final int value;

    DirectionEnum(int value) {
        this.value = value;
    }

}
