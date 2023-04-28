// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class drivingmayb extends CommandBase {
  /** Creates a new drivingmayb. */
  private Drivetrain drivy;
  private Joystick turnsstick;
  private Joystick forwardsstick;
  public drivingmayb(Drivetrain driving, Joystick turny, Joystick forwardy) {
    drivy = driving;
    turnsstick = turny;
    forwardsstick = forwardy;
    addRequirements(drivy);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivy.aaafwefeaaw(forwardsstick.getX(), turnsstick.getY());
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
