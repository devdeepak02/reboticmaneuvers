package com.learning.roboticmaneuvers.util;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by devdeepak02 on 9/24/17.
 */
@Component
public class DirectionUtil {

    final List<DirectionEnum> turnL90DirectionList = Arrays.asList(DirectionEnum.NORTH, DirectionEnum.WEST, DirectionEnum.SOUTH, DirectionEnum.EAST);

    public DirectionEnum turnLeft90(DirectionEnum currentDirection) {

        int currentPos = turnL90DirectionList.indexOf(currentDirection);
        if (currentPos == turnL90DirectionList.size()) {
            return turnL90DirectionList.get(0);
        }
        return turnL90DirectionList.get(currentPos + 1);
    }

    public DirectionEnum turnRight90(DirectionEnum currentDirection) {

        int currentPos = turnL90DirectionList.indexOf(currentDirection);
        if (currentPos == 0) {
            return turnL90DirectionList.get(3);
        }
        return turnL90DirectionList.get(currentPos - 1);
    }
}
