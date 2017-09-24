package com.learning.roboticmaneuvers.impl;

import com.learning.roboticmaneuvers.constants.ApplicationConstant;
import com.learning.roboticmaneuvers.exception.InvalidInstructionException;
import com.learning.roboticmaneuvers.model.Plateau;
import com.learning.roboticmaneuvers.util.DirectionEnum;
import com.learning.roboticmaneuvers.util.DirectionUtil;
import com.learning.roboticmaneuvers.util.MoveInstructionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by devdeepak02 on 9/24/17.
 */
@Component
public class Robo {

    @Autowired
    DirectionUtil directionUtil;
    @Autowired
    Plateau plateau;

    private int xPosition;
    private int yPosition;
    private DirectionEnum currentDirection;

    Robo() {
        xPosition = 0;
        yPosition = 0;
        currentDirection = DirectionEnum.NORTH;
    }

    public void move(MoveInstructionEnum moveInstructionEnum) {

        switch (moveInstructionEnum) {

            case LEFT:
                currentDirection = directionUtil.turnLeft90(currentDirection);
                break;
            case RIGHT:
                currentDirection = directionUtil.turnRight90(currentDirection);
                break;
            case Move:
                moveForward();
                break;
            default:
                throw new InvalidInstructionException("invalid move instruction");

        }
    }

    private void moveForward() {
        switch (currentDirection) {
            case EAST:
                if (xPosition == plateau.getxCordinateMax())
                    throw new InvalidInstructionException(ApplicationConstant.INVALID_MOVE_INSTRUCTION);
                else
                    xPosition += 1;
                break;
            case WEST:
                if (xPosition == plateau.getxCordinateMin())
                    throw new InvalidInstructionException(ApplicationConstant.INVALID_MOVE_INSTRUCTION);
                else
                    xPosition -= 1;
                break;
            case NORTH:
                if (yPosition == plateau.getyCordinateMax())
                    throw new InvalidInstructionException(ApplicationConstant.INVALID_MOVE_INSTRUCTION);
                else
                    yPosition += 1;
                break;
            case SOUTH:
                if (yPosition == plateau.getyCordinateMin())
                    throw new InvalidInstructionException(ApplicationConstant.INVALID_MOVE_INSTRUCTION);
                else
                    yPosition -= 1;
                break;
            default:
                throw new RuntimeException("Robo is strangely facing 5th direction.");
        }
    }


    @Override
    public String toString() {
        return "Robot's position " + xPosition + " " + yPosition + " " + currentDirection;
    }

}

