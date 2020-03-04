package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class SlideRack extends SubsystemBase {
 
  //SpeedControllerGroup m_climberProtocol;

  public double lowerLimit = 0.0;
  public double upperLimit = 80.0;

  Encoder slideRackEncoder = new Encoder(1,2);
  PWMTalonSRX slideRack = new PWMTalonSRX(RobotMap.slideRackPort);
  
  public void setSpeed(double power) {
    slideRack.set(power);
  }
  
  @Override
  public void periodic() {
    
  }

  public SlideRack() {
    //this.slideRack = new PWMTalonSRX(RobotMap.slideRackPort);
    
    //this.m_climberProtocol = new SpeedControllerGroup(slideRack);
    slideRackEncoder.setDistancePerPulse(1./256.);
    slideRackEncoder.reset();
    slideRackEncoder.setReverseDirection(true);
    
  }
  public boolean hasReachedUpperLimit(){
    if(slideRackEncoder.getDistance()>= upperLimit){
      return true;
    }
    else{
      return false;
    }
  }
  public boolean hasReachedLowerLimit(){
    if(slideRackEncoder.getDistance()<= lowerLimit){
      return true;
    }
    else{
      return false;
    }
  }
  public double getShaftRotations(){
     return slideRackEncoder.getDistance();
  }
  
}