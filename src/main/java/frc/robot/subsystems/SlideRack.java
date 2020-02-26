/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class SlideRack extends SubsystemBase {
PWMTalonSRX slideRack;

//SpeedControllerGroup m_climberProtocol;

  double targetPos = 20.0;

  Encoder slideRackEncoder = new Encoder(0,1);
  
  //cl = climber Mid+Rear = there respective place, so climber Mid, so mid gear box, and Rear, the back gear box
    
  public void setSpeed(double power) {
    slideRack.set(power);
  }

  public void setPosition(double targetPos) {
    this.targetPos = targetPos;
  }

  @Override
  public void periodic() {
    // target: 20
    // actually: 19

    // TODO: SHOULD WE SUBTRACT ONE OF THESE??
    double currentPos = slideRackEncoder.getDistance();

    double error = targetPos - currentPos;

    setSpeed(error * 0.01);
  }

  public SlideRack() {
    this.slideRack = new PWMTalonSRX(RobotMap.slideRackPort);
    
    //this.m_climberProtocol = new SpeedControllerGroup(slideRack, endGame);

    slideRackEncoder.reset();
    
  }

  //PLEASE DONT CHANGE ANY NAMES BECAUSE TO ME THESE NAMES SOUND COOL, IF YOU CHANGE THESE NAMES I WILL FIND YOU

}