package ProjectStorm;

import javax.swing.*;
import java.awt.*;
//Potential Fullscreen Toggle: https://stackoverflow.com/questions/4462454/java-full-screen-program-swing-tab-alt-f4/4462524#4462524

public class InitializeWindow extends JFrame{
    boolean isFullscreen = false; //Make sure to change this, so that it does not override user configuration value.
    static boolean isDebugModeOn = false;
    static boolean displayFPSCount = true;
    static double scaleX = 1.0;
    static double scaleY = 1.0;

    public InitializeWindow(){
        initUI();
    }

    private void initUI(){
        add(new Game());
        //setResizable(false);
        pack();
        setTitle("Project Storm (Debug Build)");
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Perhaps I could change this, so that it asks to save the game.
        setFullscreen(true);
    }

    public void setFullscreen(boolean isFullscreen){
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        DisplayMode dispMode = device.getDisplayMode();
        DisplayMode dispModeOld = device.getDisplayMode();

        if(this.isFullscreen != isFullscreen){
            this.isFullscreen = isFullscreen;
            //This if-statement will return to windowed mode.
            if(!isFullscreen){
                device.setDisplayMode(dispModeOld);
                setVisible(false);
                dispose();
                setUndecorated(false);
                device.setFullScreenWindow(null);
                setLocationRelativeTo(null);
                setResizable(true);
                setVisible(true);
                this.scaleX = dispModeOld.getWidth() / 1920.0;
                this.scaleY = dispModeOld.getHeight() / 1080.0;
            }
            else{
                setVisible(false);
                dispose();
                setUndecorated(true);
                device.setFullScreenWindow(this);
                device.setDisplayMode(dispMode);
                setResizable(false);
                setAlwaysOnTop(false); //Theoretically, this should allow for better alt-tab support.
                setVisible(true);
                this.scaleX = dispMode.getWidth() / 1920.0;
                this.scaleY = dispMode.getHeight() / 1080.0;
            }
            repaint();
        }
    }
    
    public static boolean getDebugModeState(){
        return isDebugModeOn;
    }
    
    public static boolean getFPSCountState(){
        return displayFPSCount;
    }
    
    public static double getScaleX(){
        return scaleX;
    }
    
    public static double getScaleY(){
        return scaleY;
    }

    public static void main(String[] args){
        for(String arg : args){
            if(arg.equals("--debug") || arg.equals("-d")) isDebugModeOn = true;
            if(arg.equals("--disable_FPS")) displayFPSCount = false;
        }
        EventQueue.invokeLater(() -> {
            JFrame window = new InitializeWindow();
            //setFullscreen(isFullscreen);
            //window.dispose();
            /*
            The use of the previous method is to destroy the JFrame, even though it recovers after "window.setVisible(true);"
            is called. Its purpose is to prevent a crash when using the "setUndecorated()" method.
            */
            //window.setExtendedState(JFrame.MAXIMIZED_BOTH);
            //window.setUndecorated(true);
            window.setVisible(true);
        });
    }
}
