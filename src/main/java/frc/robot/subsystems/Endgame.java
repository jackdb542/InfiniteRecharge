package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class Endgame extends SubsystemBase {
  
  PWMTalonSRX endGame;

  //SpeedControllerGroup m_climberProtocol;
  private final XboxController xbox = new XboxController(1);
    double targetPos = -20.0;
  
    Encoder endGameEncoder = new Encoder(5,6);
    
    //cl = climber Mid+Rear = there respective place, so climber Mid, so mid gear box, and Rear, the back gear box
    
    public void setSpeed(double power) {
      endGame.set(power);
    }
  
    public void setPosition(double targetPos) {
      this.targetPos = targetPos;
    }
  
    @Override
    public void periodic() {
      // target: 20
      // actually: 19
  
      // TODO: SHOULD WE SUBTRACT ONE OF THESE??
      double currentPos = endGameEncoder.getDistance();
  
      double error = targetPos - currentPos;
    }
     // setSpeed(error * 0.01);
     
    public Endgame() {
      this.endGame = new PWMTalonSRX(RobotMap.endGamePort);
      
      //this.m_climberProtocol = new SpeedControllerGroup(slideRack, endGame);
  
      endGameEncoder.reset();
      
    }
  
    //PLEASE DONT CHANGE ANY NAMES BECAUSE TO ME THESE NAMES SOUND COOL, IF YOU CHANGE THESE NAMES I WILL FIND YOU
  }
