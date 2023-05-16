// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Arms;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArmsCommand extends CommandBase {
  Joystick grabby;
  Arms arms;


  public ArmsCommand(Arms grab, Joystick grabup, Joystick turngrab) {

    addRequirements(grab);
    arms = grab;
    grabby = grabup;
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    grabby.getX();
    double grabpleasework = MathUtil.applyDeadband(grabby.getX(), 0.1);
    arms.no(grabpleasework);

  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}