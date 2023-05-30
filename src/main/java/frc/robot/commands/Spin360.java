// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyro;



public class Spin360 extends CommandBase {

  public DriveTrain driveTrain;
  public Timer duration;
  public Gyro gyro;
  public double currentDirection;

  /** Creates a new AutoSpin. */
  public Spin360(DriveTrain subsystem, Gyro gyrO) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = subsystem;
    gyro = gyrO;
    duration = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    duration.reset();
    duration.start();
    currentDirection = gyro.getYaw();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.yes(0,1.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return gyro.getYaw() >= currentDirection + 360;
  }
}
