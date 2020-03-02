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

  double targetPos = 11.0;

  Encoder slideRackEncoder = new Encoder(0,1);
  PWMTalonSRX slideRack = new PWMTalonSRX(RobotMap.slideRackPort);
  
  //cl = climber Mid+Rear = there respective place, so climber Mid, so mid gear box, and Rear, the back gear box  
  public void setSpeed(double power) {
    slideRack.set(power);
  }

  public void setPosition(double targetPos) {
    this.targetPos = targetPos;
  }
  public void settargetPos(double targetPos){
    slideRackEncoder.getDistance();
  }
  
  @Override
  public void periodic() {
    // target: 20
    // actually: 19

    // TODO: SHOULD WE SUBTRACT ONE OF THESE??
    double currentPos = slideRackEncoder.getDistance();

    double error = targetPos - currentPos;

    setSpeed(error * 0.03);
  }

  public SlideRack() {
    //this.slideRack = new PWMTalonSRX(RobotMap.slideRackPort);
    
    //this.m_climberProtocol = new SpeedControllerGroup(slideRack);
    slideRackEncoder.reset();
    
  }

  //PLEASE DONT CHANGE ANY NAMES BECAUSE TO ME THESE NAMES SOUND COOL, IF YOU CHANGE THESE NAMES I WILL FIND YOU

}