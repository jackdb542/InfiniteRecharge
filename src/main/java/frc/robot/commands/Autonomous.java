package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

//import java.sql.Time;

import edu.wpi.first.wpilibj.Timer;

public class Autonomous extends CommandBase{
  private final Timer m_timer = new Timer();
  private final Drivetrain m_drivetrain;
  /**
   * Creates a new Autonomous.
   */
  public Autonomous(Drivetrain drivetrain) {
    m_drivetrain = drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     m_drivetrain.manualDrive(.5, 0, 0);
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.manualDrive(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_timer.get() >= 2){
       return true;
    }
    else{
    return false;
    }
  }
}
