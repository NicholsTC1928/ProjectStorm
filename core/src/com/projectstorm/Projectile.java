package com.projectstorm;

public class Projectile{
    private double speedX;
    private final double initialSpeedX;
    private double speedY;
    private final double initialSpeedY;
    private double currentXPos;
    private double currentYPos;
    private boolean isExplosive;
    private final boolean initialIsExplosive;
    private int damage;
    private double explosiveDamageRadius;
    private int pixelXSize;
    private int pixelYSize;
    
    public Projectile(boolean isExplosive,double speedX,double speedY,double currentXPos,double currentYPos,int damage,double radius,int pixelXSize,int pixelYSize){
        this.isExplosive = isExplosive;
        this.initialIsExplosive = isExplosive;
        this.explosiveDamageRadius = radius;
        this.speedX = speedX;
        this.initialSpeedX = speedX;
        this.speedY = speedY;
        this.initialSpeedY = speedY;
        this.currentXPos = currentXPos;
        this.currentYPos = currentYPos;
        this.pixelXSize = pixelXSize;
        this.pixelYSize = pixelYSize;
    }
    
    public Projectile(double speedX,double speedY,double currentXPos,double currentYPos,int damage){
        this(false,speedX,speedY,currentXPos,currentYPos,damage,-1.0);
    }
    
    public Projectile(boolean isExplosive,double speedX,double speedY,double currentXPos,double currentYPos,int damage,double radius){
        this(isExplosive,speedX,speedY,currentXPos,currentYPos,damage,radius,20,20);
    }
    
    public Projectile(double speedX,double speedY,double currentXPos,double currentYPos,int damage,int pixelXSize,int pixelYSize){
        this(false,speedX,speedY,currentXPos,currentYPos,damage,-1.0,pixelXSize,pixelYSize);
    }
    
    public int getPixelXSize(){
        return this.pixelXSize;
    }
    
    public int getPixelYSize(){
        return this.pixelYSize;
    }
    
    public double getSpeedX(){
        return this.speedX;
    }
    
    public void multiplySpeedXBy(double multiplier){
        this.speedX *= multiplier;
    }
    
    public void setSpeedX(double speed){
        this.speedX = speed;
    }
    
    public double getInitialSpeedX(){
        return this.initialSpeedX;
    }
    
    public double getSpeedY(){
        return this.speedY;
    }
    
    public void multiplySpeedYBy(double multiplier){
        this.speedY *= multiplier;
    }
    
    public void setSpeedY(double speed){
        this.speedY = speed;
    }
    
    public double getInitialSpeedY(){
        return this.initialSpeedY;
    }
    
    public double getCurrentXPos(){
        return this.currentXPos;
    }
    
    public void changeCurrentXPosBy(double speed){
        this.currentXPos += speed;
    }
    
    public void setCurrentXPos(double pos){
        this.currentXPos = pos;
    }
    
    public double getCurrentYPos(){
        return this.currentYPos;
    }
    
    public void changeCurrentYPosBy(double speed){
        this.currentYPos += speed;
    }
    
    public void setCurrentYPos(double pos){
        this.currentYPos = pos;
    }
    
    public boolean getIsExplosive(){
        return this.isExplosive;
    }
    
    public void setIsExplosive(boolean isExplosive){
        this.isExplosive = isExplosive;
    }
    
    public boolean getInitialIsExplosive(){
        return this.initialIsExplosive;
    }
    
    public double getExplosiveDamageRadius(){
        return this.explosiveDamageRadius;
    }
    
    public void multiplyExplosiveDamageRadiusBy(double multiplier){
        this.explosiveDamageRadius *= multiplier;
    }
}
