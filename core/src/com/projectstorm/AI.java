package com.projectstorm;

public interface AI {
    public void activateEnemy(double playerCurrentXPos,double playerCurrentYPos);
    public void chooseActivePath(double playerCurrentXPos, double playerCurrentYPos);
}
