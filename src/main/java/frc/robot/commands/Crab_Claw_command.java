// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Crab_Claw;

public class Crab_Claw_command extends CommandBase {
  private JoystickButton OpenClawTrigger;
  private boolean OpenClawBoolean; 
  private JoystickButton CloseClawTrigger;
  private boolean CloseClawBoolean; 
  private Crab_Claw Crab_Claw;
  /** Creates a new Crab_Claw_command. */
  public Crab_Claw_command(JoystickButton Button3, JoystickButton Button4) {
    // Use addRequirements() here to declare subsystem dependencies.    
    OpenClawTrigger = Button3;
    CloseClawTrigger = Button4;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Crab_Claw.clawClose();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    OpenClawBoolean = OpenClawTrigger.getAsBoolean();
    CloseClawBoolean = CloseClawTrigger.getAsBoolean();
    if (OpenClawBoolean == true){
      Crab_Claw.clawOpen();
    }
    else if (CloseClawBoolean == true){
      Crab_Claw.clawClose();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
