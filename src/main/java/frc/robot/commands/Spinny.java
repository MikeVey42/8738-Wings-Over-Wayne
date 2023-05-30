// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Spinny extends CommandBase {
  DriveTrain drivetrains;
  Timer secondspin;

  public Spinny(DriveTrain gospin) {
    drivetrains = gospin;
    secondspin = new Timer();
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    secondspin.reset();
    secondspin.start();
    secondspin.get();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrains.yes(0,.5);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return secondspin.get() >= 14;
  }
}
