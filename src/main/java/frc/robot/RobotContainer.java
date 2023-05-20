// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.GoToRef;
import frc.robot.commands.ManualElevatorControl;
import frc.robot.commands.SetElevator;
import frc.robot.subsystems.Elevator;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Auto_Drive;
import frc.robot.commands.Autos;
import frc.robot.commands.Crab_Claw_command;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Spin_command;
import frc.robot.subsystems.Crab_Claw;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ElbowCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.zeroelbow;
import frc.robot.commands.comandGroups.Auto;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ElbowMotor;
import frc.robot.subsystems.ExampleSubsystem;

import javax.swing.text.Position;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  public Joystick forwardStick = new Joystick(0);
  public Joystick turningStick = new Joystick(1);
  public Joystick thirdJoystick = new Joystick(2);
  
  public JoystickButton Button3 = new JoystickButton(thirdJoystick, 4);
  public JoystickButton Button4 = new JoystickButton(thirdJoystick, 5);
  public JoystickButton upelbow = new JoystickButton(forwardStick, 1);
  public JoystickButton zerobutton = new JoystickButton(forwardStick, 2);
  
  private static Elevator m_Elevator = new Elevator();

  private static ManualElevatorControl m_ManualElevatorControl = new ManualElevatorControl(m_Elevator, thirdJoystick);
  private static SetElevator m_SetElevator = new SetElevator(m_Elevator);
  private static GoToRef m_GoToRef = new GoToRef(m_Elevator);
  
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  Crab_Claw Crab_Claw =  new Crab_Claw();
  public DriveTrain driveSubsystem = new DriveTrain();
  public ElbowMotor elbowSystem = new ElbowMotor();

  public DriveCommand controls = new DriveCommand(driveSubsystem, forwardStick, turningStick);

  public ElbowCommand pos = new ElbowCommand(elbowSystem, 0);
  public zeroelbow makezero = new zeroelbow(elbowSystem);
  
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final Crab_Claw_command Crab_Claw_command = new Crab_Claw_command(Button3, Button4, Crab_Claw);
  private final Spin_command Spin_command = new Spin_command(Crab_Claw);
  private final Auto Auto = new Auto(Crab_Claw, driveSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    Crab_Claw.setDefaultCommand(Crab_Claw_command);
    // Configure the trigger bindings
    configureBindings();

    m_Elevator.setDefaultCommand(m_ManualElevatorControl);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    upelbow.onTrue(pos);
    zerobutton.onTrue(makezero);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Auto;
  }
}
