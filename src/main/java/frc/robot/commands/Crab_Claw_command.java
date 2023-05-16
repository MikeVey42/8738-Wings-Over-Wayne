// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Crab_Claw;

public class Crab_Claw_command extends CommandBase {
  private JoystickButton OpenClawTrigger;
  private Boolean OpenClawBoolean; 
  private JoystickButton CloseClawTrigger;
  private Boolean CloseClawBoolean; 
  /** Creates a new Crab_Claw_command. */
  public Crab_Claw_command() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    private void setButtons(){
      public JoystickButton OpenClawTrigger = new JoystickButton(,3);
      public JoystickButton CloseClawTrigger = new JoystickButton(,4);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    OpenClawBoolean = OpenClawTrigger.getAsBoolean();
    CloseClawBoolean = CloseClawTrigger.getAsBoolean();
    if (OpenClawBoolean = true){
      Crab_Claw.clawOpen();
    }
      else{
    }
    if (CloseClawBoolean = true){
      Crab_Claw.clawClose();
    }
      else(){

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
