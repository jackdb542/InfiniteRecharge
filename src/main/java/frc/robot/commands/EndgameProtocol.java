package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Endgame;

public class EndgameProtocol extends CommandBase {

  XboxController xbox;
  Endgame endGame;
    
    public EndgameProtocol(XboxController xbox, Endgame endGame) {
      this.xbox = xbox;
      this.endGame = endGame;
 
      addRequirements(endGame);
    }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    whenPressed(xbox.getRawButton(7));
    whenPressed(xbox.getRawButton(8));
  }

  private void whenPressed(boolean rawButton) {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(xbox.getRawButton(7) == true){
     endGame.setSpeed(0.6);
     }
     else if(xbox.getRawButton(8) == true){
      endGame.setSpeed(-0.6);
     }
     else{
       endGame.setSpeed(0.0);
     }
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
