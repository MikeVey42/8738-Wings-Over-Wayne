// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.itstheClaw;

public class dotheClawForward extends CommandBase {

  itstheClaw claw;
  double speed;
  Joystick claw_stick;

  /** Creates a new dotheClawForward. */
  public dotheClawForward(itstheClaw a_claw, Joystick a_joystick) {
    claw = a_claw;
    speed = Constants.forwardClawSpeed;
    claw_stick = a_joystick;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    claw.moveClawForward(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    claw.moveClawForward(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
