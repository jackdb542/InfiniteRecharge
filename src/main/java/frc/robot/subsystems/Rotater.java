package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Rotater extends SubsystemBase {
  /**
   * Creates a new Rotater.
   */
  
  final PWMVictorSPX rotate = new PWMVictorSPX(RobotMap.colorWheelPort);
  
  public void setSpeed(double power) {
    rotate.set(power);
  }
  public Rotater() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}