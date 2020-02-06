package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Inputs;
import frc.robot.subsystems.Drivetrain;

public class ManualDrive extends CommandBase {
  /**
   * Creates a new ManualDrive.
   *
   * @param inputs
   * @param drivetrain
   * @param m_inputs
   * @param m_drivetrain
   */
  public ManualDrive(Drivetrain drivetrain, Inputs inputs, Inputs m_inputs) {
    m_inputs = inputs;
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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
