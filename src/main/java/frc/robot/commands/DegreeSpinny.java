// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyro;

public class DegreeSpinny extends CommandBase {
  DriveTrain drivetrains;
  Gyro degree;
  public double var_degree;
  public DegreeSpinny(DriveTrain gospin, Gyro givedegree) {
    drivetrains = gospin;
    degree = givedegree;
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    var_degree = degree.getYaw();
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
    return degree.getYaw() >= var_degree + 360;
  }
}
