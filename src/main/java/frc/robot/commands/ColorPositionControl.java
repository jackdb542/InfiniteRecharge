package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Rotater;

public class ColorPositionControl extends CommandBase {
  /**
   * Creates a new ColorPositionControl.
   */
  static Joystick joy = new Joystick(RobotMap.joystickPort);
  static Rotater rotater = new Rotater();
  public ColorPositionControl() {
    // Use addRequirements() here to declare subsystem dependencies.
    //addRequirements(rotater);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    }

// Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(joy.getRawButton(5) == true){
        rotater.setSpeed(0.5);
    }
    else if(joy.getRawButton(6) == true){
        rotater.setSpeed(-0.5);
    }
    else{
      rotater.setSpeed(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
