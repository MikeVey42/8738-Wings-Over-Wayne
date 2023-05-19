// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElbowMotor;
public class ElbowCommand extends CommandBase {
  ElbowMotor elbowMotor;
  double position;
  

  public ElbowCommand(ElbowMotor motorsubs, double pos) {
    addRequirements(motorsubs);
    elbowMotor = motorsubs;
    position = pos;

  }


  @Override
  public void initialize() {
    elbowMotor.elbowyes(position);
    
  }

  
  @Override
  public void execute() {}

  
  @Override
  public void end(boolean interrupted) {}

  
  @Override
  public boolean isFinished() {
    return true;
  }
}
