package ProjectStorm;

import java.util.Random;

public class Serpent extends MovableObject implements AI{
    private int level;
    private boolean isCurrentlyInWorld;
    private final double actualFullSpeed;
    private double initialSpeedX;
    private double initialSpeedY;
    private double angleForOrientation;
    private double desiredXPos;
    private double desiredYPos;
    
    public Serpent(int level){
        super(2.5,2.5,(60 + (30 * level)),false);
        //super((2.5 + (0.5 * level)),(2.5 + (0.5 * level)),(60 + (30 * level)),false);
        switch(level){
            case 0:
                this.setDamage(30);
                this.actualFullSpeed = 2.5;
                break;
            case 1:
                this.setDamage(60);
                this.actualFullSpeed = 2.5; //Was 3.0
                break;
            case 2:
                this.setDamage(90);
                this.actualFullSpeed = 2.5; //Was 3.5
                break;
            default:
                this.setDamage(30);
                this.actualFullSpeed = 2.5;
                break;
        }
        this.isCurrentlyInWorld = false;
        this.setIsAIActivated(false);
    }

    public double getInitialSpeedX(){
        return this.initialSpeedX;
    }

    public double getInitialSpeedY(){
        return this.initialSpeedY;
    }
    
    public double getDesiredXPos(){
        return this.desiredXPos;
    }
    
    public void setDesiredXPos(double newX){
        this.desiredXPos = newX;
    }
    
    public double getDesiredYPos(){
        return this.desiredYPos;
    }
    
    public void setDesiredYPos(double newY){
        this.desiredYPos = newY;
    }

    public double getAngleForOrientation(){
        return this.angleForOrientation;
    }
    
    public double getLevel(){
        return this.level;
    }
    
    public void setLevel(int newLevel){
        this.level = newLevel;
    }
    
    public boolean getIsCurrentlyInWorld(){
        return this.isCurrentlyInWorld;
    }
    
    //It seems probable that the Serpent AI will need an entire overhaul in its implementation.
    
    public void activateEnemy(double playerCurrentXPos,double playerCurrentYPos){
        this.setIsAIActivated(true);
        Random r = new Random();
        while(this.getHealth() > 0){
            int sideChoice = r.nextInt(4) + 1;
            if(!this.isCurrentlyInWorld){
                switch(sideChoice){
                    case 1: //Top Border
                        this.goToYPos(0.0);
                        this.goToXPos(400.0 * (r.nextDouble()));
                        break;
                    case 2: //Bottom Border
                        this.goToYPos(400.0);
                        this.goToXPos(400.0 * (r.nextDouble()));
                        break;
                    case 3: //Left Border
                        this.goToXPos(0.0);
                        this.goToYPos(400.0 * (r.nextDouble()));
                        break;
                    case 4: //Right Border
                        this.goToXPos(400.0);
                        this.goToYPos(400.0 * (r.nextDouble()));
                        break;
                    default:
                        break;
                }
                System.out.println("Start: (" + this.getCurrentXPos() + ", " + this.getCurrentYPos() + ")");
                this.isCurrentlyInWorld = true;
            }
            if(!this.getHasDesiredPath()){
                chooseActivePath(playerCurrentXPos,playerCurrentYPos);
            }
            else{
                if(this.getCurrentXPos() < 0.0 || this.getCurrentXPos() > 400.0 || this.getCurrentYPos() < 0.0
                        || this.getCurrentYPos() > 400.0){
                    System.out.println("End: (" + this.getCurrentXPos() + ", " + this.getCurrentYPos() + ")");
                    this.isCurrentlyInWorld = false;
                    this.setHasDesiredPath(false);
                    this.setIsAIActivated(false);
                    this.setSpeedX(0.0);
                    this.setSpeedY(0.0);
                }
            }
        }
    }
    
    public void chooseActivePath(double playerCurrentXPos,double playerCurrentYPos){
        double neededChangeInX = playerCurrentXPos - this.getCurrentXPos();
        double neededChangeInY = playerCurrentYPos - this.getCurrentYPos();
        //The total speed of the enemy should be 2.5 units/second (3.5 units/second if the type is Omega).
        double angle = Math.atan2(neededChangeInY, neededChangeInX);
        System.out.println("Angle: " + angle);
        //if(neededChangeInX > 0 && neededChangeInY > 0) this.angleForOrientation = (angle * -1.0);
        //else if(neededChangeInX < 0 && neededChangeInY < 0) this.angleForOrientation = (Math.PI - angle);
        //else if(neededChangeInX > 0 && neededChangeInY < 0) this.angleForOrientation = angle;
        //else this.angleForOrientation = (Math.PI + angle);
        this.angleForOrientation = ((-1.0 * Math.PI / 2) + angle);
        this.setSpeedX(this.actualFullSpeed * Math.cos(angle));
        //if(neededChangeInX < 0) this.setSpeedX(this.getSpeedX() * -1.0);
        //System.out.println("X Speed: " + this.getSpeedX());
        this.initialSpeedX = this.getSpeedX();
        this.setSpeedY(this.actualFullSpeed * Math.sin(angle));
        //if(neededChangeInY < 0) this.setSpeedY(this.getSpeedY() * -1.0);
        //System.out.println("Y Speed: " + this.getSpeedY());
        this.initialSpeedY = this.getSpeedY();
        this.setHasDesiredPath(true);
    }
}
