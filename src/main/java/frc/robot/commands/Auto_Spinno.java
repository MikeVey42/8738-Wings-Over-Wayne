// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyro;

public class Auto_Spinno extends CommandBase {

  DriveTrain m_drivetrain;
  Gyro m_gyro;

  Double startPos;

  /** Creates a new Auto_Spinno. */
  public Auto_Spinno(DriveTrain drv, Gyro gyr) {
    m_drivetrain = drv;
    m_gyro = gyr;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startPos = m_gyro.getYaw();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    while (m_gyro.getYaw() < startPos + 180){
      m_drivetrain.yes(0, 0.4);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.yes(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
