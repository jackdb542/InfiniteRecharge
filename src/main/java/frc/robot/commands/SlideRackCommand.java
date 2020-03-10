package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SlideRack;


public class SlideRackCommand extends CommandBase {
  // Go up on a button press
  // Go down on a button press
  //boolean isUp = false;
  //boolean debounce = false;

  XboxController xbox;
  SlideRack slideRack;

  public SlideRackCommand(XboxController xbox, SlideRack slideRack) {
    this.xbox = xbox;
    this.slideRack = slideRack;
   
      addRequirements(slideRack);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   slideRack.upperLimit = 52;
   slideRack.lowerLimit = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     if(xbox.getRawButton(12) == true&& slideRack.hasReachedLowerLimit() == false){
         slideRack.setSpeed(-0.5);
     }
     else if(xbox.getRawButton(11) == true&&slideRack.hasReachedUpperLimit() == false){
       slideRack.setSpeed(0.5);
     }
     else if(xbox.getRawButton(1)){
        //use this to lower the slider after the match ends
        slideRack.setSpeed(-0.5);
     }
     else{
       slideRack.setSpeed(0.0);
     }
     SmartDashboard.putNumber("encoder value", slideRack.getShaftRotations());
     
    
}     
    //return statement
   
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
