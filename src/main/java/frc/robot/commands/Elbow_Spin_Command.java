// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElbowMotor;

public class Elbow_Spin_Command extends CommandBase {
  Timer elbowTimer;
  ElbowMotor elbowMotor;
  /** Creates a new Elbow_Spin_Command. */
  public Elbow_Spin_Command(ElbowMotor elbowMotor) {
    this.elbowMotor = elbowMotor;
    elbowTimer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(elbowMotor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    elbowTimer.restart();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elbowMotor.spin();
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elbowMotor.setDefault();
    elbowMotor.spinStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return 2 <= elbowTimer.get();
  }
}
