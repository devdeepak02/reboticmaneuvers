package com.learning.roboticmaneuvers.application;

import com.learning.roboticmaneuvers.impl.Robo;
import com.learning.roboticmaneuvers.model.Plateau;
import com.learning.roboticmaneuvers.util.DirectionEnum;
import com.learning.roboticmaneuvers.util.MoveInstructionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by devdeepak02 on 9/24/17.
 */
@Slf4j
@Component
@Configuration
@ComponentScan(value = "com.learning.roboticmaneuvers")
public class RoboticManeuversApplication implements CommandLineRunner {

    @Autowired
    Plateau plateau;

    @Autowired
    Robo robo;

    public static void main(String[] args) throws Exception {
        log.info("RoboticManeuversApplication started");
        SpringApplication.run(RoboticManeuversApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        log.info("====================================================");
        log.info("**************                               ******");
        log.info("************** Robotic Maneuvers Application ******");
        log.info("**************                               *******");
        log.info("====================================================");

        log.info("running application with args {}", args);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String plateauDimensions;
        String[] plateauMaxCoordinates;

        String roboPos;
        //Let's collect plateau dimensions
        log.error("Enter plateau dimensions and press ENTER");
        plateauDimensions = reader.readLine();
        if (!StringUtils.isEmpty(plateauDimensions) &&
                (plateauMaxCoordinates = plateauDimensions.split(" ")).length > 1) {
            int maxXCoordinates = Integer.parseInt(plateauMaxCoordinates[0]);
            int maxYCoordinates = Integer.parseInt(plateauMaxCoordinates[1]);

            plateau.setxCordinateMax(maxXCoordinates);
            plateau.setyCordinateMax(maxYCoordinates);
        }
        //two step process for every robo
        //1 - collect initial possition
        //2 - collect string of commands
        while(true) {
            log.info("provide initial position for robo ");
            roboPos = reader.readLine();
            String[] roboCoOrdinates;
            // Did user provide initial position ?
            if (!StringUtils.isEmpty(roboPos) &&
                    (roboCoOrdinates = roboPos.split(" ")).length > 2) {
                int roboXPos = Integer.parseInt(roboCoOrdinates[0]);
                int roboYPos = Integer.parseInt(roboCoOrdinates[1]);
                DirectionEnum roboDirection = DirectionEnum.find(roboCoOrdinates[2]);

                robo.setXPosition(roboXPos);
                robo.setYPosition(roboYPos);
                robo.setCurrentDirection(roboDirection);
            }

            log.info("provide complete move instructions for first robo ");

            String moveInstruction = reader.readLine();
            //Did user provide move instructions ?
            if (!StringUtils.isEmpty(moveInstruction)) {
                List<MoveInstructionEnum> commands = moveInstruction.chars()
                        .mapToObj(x -> {
                            String command = Character.toString((char) x);
                            return MoveInstructionEnum.find(command);
                        }).collect(Collectors.toList());

                if (!CollectionUtils.isEmpty(commands)) {
                    //Execute each command to change robo state
                    commands.forEach(robo::move);

                    log.info("final robo position {}", robo);
                }
            }
            // Want to continue or should I exit ?
            log.info("do you want to continue ? Y/N ");
            String response = reader.readLine();
            if(!Boolean.valueOf(response)){
                break;
            }
        }

    }

}
