package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
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
   whenPressed(xbox.getRawButton(5));
   whenPressed(xbox.getRawButton(6));
  }
  private void whenPressed(boolean rawButton) {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     if(xbox.getRawButton(5) == true){
         slideRack.setSpeed(0.5);
     }
     else if(xbox.getRawButton(6) == true){
       slideRack.setSpeed(-0.5);
     }
     else{
       slideRack.setSpeed(0.0);
     }
     
    /*
    if (xbox.getRawButton(5)) {
      if (!debounce) {
        debounce = true;
      }
    } else {
      debounce = false;
    }
    if (isUp) {
      slideRack.setPosition(20.0);
    } else {
      slideRack.setPosition(0.0);
      
    if (xbox.getRawButton(6)){
        if(!isUp){
      debounce = true;
    }
   } else{
      slideRack.setSpeed(-0.5);
      debounce = false;
    }
  }*/
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
