package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Rotater;

public class ColorRotationControl extends CommandBase {
  /**
   * Creates a new ColorRotationControl.
   */
  Joystick joy = new Joystick(0);
  Rotater rotater;
  Timer timer = new Timer();
  public final double rotationtime = 9.0;
//private ColorSensor m_colorSensor;

public ColorRotationControl(final Rotater r) {
  rotater = r;
  // Use addRequirements() here to declare subsystem dependencies.
 //addRequirements(rotater);
}

// Called when the command is initially scheduled.
@Override
public void initialize() {
  whenPressed(joy.getRawButton(6));
  timer.reset();
  timer.start();
}

public void whenPressed(boolean rawButton) {
}

// Called every time the scheduler runs while the command is scheduled.
@Override
public void execute() {
  if (timer.get() < rotationtime) {
    rotater.setSpeed(1.0);
  } else {
    rotater.setSpeed(0.0);
  }
}


// Called once the command ends or is interrupted.
@Override
public void end(final boolean interrupted) {
  rotater.setSpeed(0.0);
}

// Returns true when the command should end.
@Override
public boolean isFinished() {
  if(timer.get() > rotationtime){
    return true;
  }
  else{
    return false;
  }
}
}
