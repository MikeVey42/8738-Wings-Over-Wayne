// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;



public class AutoSpin extends CommandBase {

  public DriveTrain driveTrain;
  public Timer duration;

  /** Creates a new AutoSpin. */
  public AutoSpin(DriveTrain subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = subsystem;
    duration = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    duration.reset();
    duration.start();
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
    return duration.get() >= 14;
  }
}