package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Inputs extends SubsystemBase {
    double x = 0.0;
	  double y = 0.5;
    double r = 0.5;
	    double voltage = 0.0;
    public Joystick joy = new Joystick(1);
    public Inputs(){

    }
    //boolean up, down, mechUp, mechDown, pistonUp, pistonDown;
    //public InputsJoystick(final Joystick joy, final double voltage) {
      //x = joy.getX();
      //y = joy.getY();
      //r = joy.getTwist();
      //this.voltage = voltage;
    // 2018-2019 Pneumatic Controller Map
    // public InputJoystick(XboxController box, double voltage) {
    // pistonUp = box.getRawButton(1);
    // pistonDown = box.getRawButton(4);
    // up = box.getRawButton(5);
    // down = box.getRawButton(6);
    // mechUp = box.getRawButton(7);
    // mechDown = box.getRawButton(8);
    // this.voltage = voltage;

    public double getX() {
      return joy.getX();
    }

    public void setX(final double value) {
      x = value;
    }

    public double getY() {
      return joy.getY();
    }

    public void setY(final double value) {
      y = value;
    }

    public double getTwist() {
      return joy.getTwist();
    }

    public void setTwist(final double value) {
    r = value;
    }
  }