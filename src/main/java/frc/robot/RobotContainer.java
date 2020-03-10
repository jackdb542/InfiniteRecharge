package frc.robot;

//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController; //<--- You don't need XboxButton imports, if you can't find them, probably because they're built in into this import, so everything you want to set to the Xbox Controller, would just be xbox.button or something like that
import frc.robot.subsystems.SlideRack;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Autonomous;
import frc.robot.commands.ColorPositionControl;
import frc.robot.commands.EndgameProtocol;
import frc.robot.commands.ManualDrive;
import frc.robot.commands.SlideRackCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Endgame;
import frc.robot.subsystems.Rotater;
import frc.robot.commands.ColorRotationControl;
          //import edu.wpi.first.wpilibj.RobotBase;
          //import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import edu.wpi.first.wpilibj.DutyCycleEncoder;
    //import edu.wpi.first.wpilibj.util.Color;
    //import edu.wpi.first.wpilibj.TimedRobot;
    //import edu.wpi.first.wpilibj.I2C;
    //import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
    //import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
    //import edu.wpi.first.wpilibj.util.Color;
//Color Sensor Imports
    //import com.revrobotics.ColorSensorV3;
    //import com.revrobotics.ColorMatch;
    //import com.revrobotics.ColorMatchResult;
/**
 * . This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final SlideRack m_slideRack = new SlideRack();
  private Joystick joy = new Joystick(0);
  private final XboxController xbox = new XboxController(1);
  private final Rotater m_rotater = new Rotater();
  private final Endgame m_endgame = new Endgame();
  private final ColorPositionControl m_positioner = new ColorPositionControl();
  private final Autonomous m_autonomous = new Autonomous(m_drivetrain);
  private final JoystickButton m_colorPositionControlButton = new JoystickButton(joy, 6);
  private final JoystickButton m_colorRotationControlButton = new JoystickButton(joy, 5);
  private final ColorRotationControl m_colorRotater = new ColorRotationControl(m_rotater);
  //private final SlideRackCommand m_sRCommand = new SlideRackCommand(xbox, m_slideRack);
  //private final ColorSensor m_colorSensor = new ColorSensor();
  
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    System.out.println(joy.getX());
    System.out.println(joy.getY());
    System.out.println(joy.getTwist());
    
    m_drivetrain.setDefaultCommand(
      new ManualDrive(m_drivetrain, joy)
    );
    m_slideRack.setDefaultCommand(
      new SlideRackCommand(xbox, m_slideRack)
    );
   m_endgame.setDefaultCommand(
     new EndgameProtocol(xbox, m_endgame,m_slideRack)
    );
   m_colorRotater.setDefaultCommand(
      new ColorRotationControl(joy, m_rotater)
    );
   m_positioner.setDefaultCommand(
     new ColorPositionControl(joy, m_rotater)
   );
   m_autonomous.setDefaultCommand(
     new Autonomous(m_drivetrain)
   );
    //m_colorPositionControl.schedule();
  }
  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  public void configureButtonBindings() {
    m_colorPositionControlButton.whenPressed(m_positioner);
    m_colorRotationControlButton.whenPressed(m_colorRotater);
    //Command m_colorPositionControl;
    //Command m_colorRotationControl;  
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An (the autonomous command) will run in autonomous
    return m_autonomous;
  }
}
