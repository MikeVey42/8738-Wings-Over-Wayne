// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;

public class clawMovey extends CommandBase {
  /** Creates a new clawMovey. */
  private Claw clowber;
  private Joystick upsstick;
  public clawMovey(Claw clawwwwwww, Joystick uppy) {
    // Use addRequirements() here to declare subsystem dependencies.
    clowber = clawwwwwww;
    upsstick = uppy;
    addRequirements(clowber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    clowber.feifeaihuaefui(upsstick.getX());
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
