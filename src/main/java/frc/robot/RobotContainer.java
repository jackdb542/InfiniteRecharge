package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController; //<--- You don't need XboxButton imports, if you can't find them, probably because they're built in into this import, so everything you want to set to the Xbox Controller, would just be xbox.button or something like that
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ColorPositionControl;
import frc.robot.commands.EndgameProtocol;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ManualDrive;
import frc.robot.commands.SlideRackCommand;
import frc.robot.subsystems.ColorMatcher;
import frc.robot.subsystems.ColorSensor;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Endgame;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Inputs;
//import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.subsystems.SlideRack;

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
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final SlideRack m_slideRack = new SlideRack();
  private final Inputs m_inputs = new Inputs();
  private Joystick joy = new Joystick(0);
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final JoystickButton m_colorPositionControlButton = new JoystickButton(joy, 2);
  private final ColorPositionControl m_colorPositionControl = new ColorPositionControl();
  private final XboxController xbox = new XboxController(1);
  private final SlideRackCommand m_sRCommand = new SlideRackCommand(xbox, m_slideRack);
  //sREncoder = (s)lide(R)ackEncoder
  private final Endgame m_endgame = new Endgame();
  private final EndgameProtocol m_EndgameProtocol = new EndgameProtocol(xbox, m_endgame,m_slideRack);
  private final ColorSensor m_colorSensor = new ColorSensor();
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
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_colorPositionControlButton.whenPressed(m_colorPositionControl);
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
