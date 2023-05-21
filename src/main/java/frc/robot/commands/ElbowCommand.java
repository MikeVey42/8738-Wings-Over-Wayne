// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ElbowMotor;
public class ElbowCommand extends CommandBase {
  ElbowMotor elbowMotor;
  double position;

  Boolean ArmUp;
  Boolean ArmDown;

  JoystickButton armUpTrigger;
  JoystickButton armDownTrigger;


  public ElbowCommand(ElbowMotor motorsubs, double pos, JoystickButton button1, JoystickButton button2) {
    addRequirements(motorsubs);
    elbowMotor = motorsubs;
    position = pos;

    armUpTrigger = button1;
    armDownTrigger = button2;
  }


  @Override
  public void initialize() {
    elbowMotor.moveUp();
    elbowMotor.elbowYes(position);

  }

  
  @Override
  public void execute() {
    ArmUp = armUpTrigger.getAsBoolean();
    ArmDown = armDownTrigger.getAsBoolean();
    if (ArmUp == true){
      elbowMotor.moveUp();;
    }
    else if (ArmDown == true){
      elbowMotor.moveDown();
    }
  }

  
  @Override
  public void end(boolean interrupted) {}

  
  @Override
  public boolean isFinished() {
    return false;
  }
}
