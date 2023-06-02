// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyro;

public class Spin360Auto extends CommandBase {
  Gyro Gyro;
  DriveTrain DriveTrain;
  Double GyroYaw;
  Double newGyroYaw;
  /** Creates a new Spin360Auto. */
  public Spin360Auto() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Gyro, DriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    GyroYaw = Gyro.getYaw();
    newGyroYaw = GyroYaw + 360;
    DriveTrain.yes(0,.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveTrain.yes(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (GyroYaw >= newGyroYaw){
      return true;
    }
    else {
      return false;
    }
    }
  }
