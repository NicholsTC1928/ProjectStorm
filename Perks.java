package ProjectStorm;

import java.util.Random;
import java.util.Arrays;
import ProjectStorm.Player;

public class Perks extends Player{
    public String getWunderfizzResult(){
        Random r = new Random();
        return (availablePerks.get(r.nextInt(availablePerks.size())));
    }
    
    public void addQuickRevive(){
        changeQuickReviveState(true);
        addPerk("Quick Revive");
    }
    
    public void addDoubleTap(){
        setFireRateMultiplier(4.0/3.0); //This may not be the actual multiplier.
        setDamageMultiplier(2.0);
        addPerk("Double Tap 2.0 Root Beer");
    }
    
    public void addJuggernog(){
        setMaxHealth(250);
        addPerk("Juggernog");
    }
    
    public void addSpeedCola(){
        setReloadSpeedMultiplier(0.5); //This may not be the actual multiplier.
        addPerk("Speed Cola");
    }
    
    public void addStaminUp(){
        setSpeedMultiplier(4/3); //This may not be the actual multiplier.
        addPerk("Stamin-Up");
    }
    
    public void addFlopper(){
        changeFlopperState(true);
        addPerk("Ph.D. Flopper");
    }
    
    public void addMuleKick(){
        changeMuleKickState(true);
        addPerk("Mule Kick");
    }
    
    public void addElectricCherry(){
        changeElectricCherryState(true);
        addPerk("Electric Cherry");
    }
    
    public void addWhosWho(){
        changeWhosWhoState(true);
        addPerk("Who's Who");
    }
    
    public void addVulturesAid(){
        changeVulturesAidState(true);
        addPerk("Vulture's Aid Elixir");
    }
    
    public void addWidowsWine(){
        changeWidowsWineState(true);
        addPerk("Widow's Wine");
    }
    
    public void addDeadshot(){
        setCriticalHitDamageMultiplier(1.5); //This may not be the actual multiplier.
        addPerk("Deadshot Daiquiri");
    }
}
