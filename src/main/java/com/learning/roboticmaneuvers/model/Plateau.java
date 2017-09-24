package com.learning.roboticmaneuvers.model;

import org.springframework.stereotype.Component;

/**
 * Created by devdeepak02 on 9/24/17.
 */
@Component
public class Plateau {

    int xCordinateMin = 0;

    public int getyCordinateMin() {
        return yCordinateMin;
    }

    public void setyCordinateMin(int yCordinateMin) {
        this.yCordinateMin = yCordinateMin;
    }

    int yCordinateMin = 0;

    public int getxCordinateMax() {
        return xCordinateMax;
    }

    public void setxCordinateMax(int xCordinateMax) {
        this.xCordinateMax = xCordinateMax;
    }

    int xCordinateMax = 0;

    public int getyCordinateMax() {
        return yCordinateMax;
    }

    public void setyCordinateMax(int yCordinateMax) {
        this.yCordinateMax = yCordinateMax;
    }

    int yCordinateMax = 0;

    public int getxCordinateMin() {
        return xCordinateMin;
    }

    public void setxCordinateMin(int xCordinateMin) {
        this.xCordinateMin = xCordinateMin;
    }
}
