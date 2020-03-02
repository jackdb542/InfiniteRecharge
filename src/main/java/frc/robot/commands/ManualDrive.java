package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.subsystems.Inputs;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;

public class ManualDrive extends CommandBase {
  /**
   * Creates a new ManualDrive.
   */
  private Drivetrain m_drivetrain;
  private Joystick m_joystick;
  
  public ManualDrive(Drivetrain drivetrain, Joystick joystick) {
    m_drivetrain = drivetrain;
    m_joystick = joystick;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double x_speed = m_joystick.getX();
    double y_speed = m_joystick.getY();
    double r_speed = m_joystick.getTwist();
    m_drivetrain.manualDrive(x_speed, y_speed, r_speed);
  }

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
