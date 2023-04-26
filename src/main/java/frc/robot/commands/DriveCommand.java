// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.DriveTrain;

public class DriveCommand extends CommandBase {
  DriveTrain driveTrain;
  Joystick movement;
  Joystick direction;

  public DriveCommand(DriveTrain subsystem, Joystick forwardback, Joystick turning) {
    addRequirements(subsystem);
    driveTrain = subsystem;
    movement = forwardback;
    direction = turning;
  } 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    movement.getX();
    direction.getY();
    double joystickforward = MathUtil.applyDeadband(movement.getX(), 0.1);
    double joystickturn = MathUtil.applyDeadband(direction.getY(), 0.1);
    driveTrain.yes(joystickforward,joystickturn);
  }

  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
