// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Auto_Drive extends CommandBase {
  private DriveTrain DriveTrain; 
  private Timer Auto_Timer; 
  /** Creates a new Auto_Drive. */
  public Auto_Drive(DriveTrain DriveTrain) {
    this.DriveTrain = DriveTrain;
    Timer Auto_timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Auto_Timer.restart();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {  
    DriveTrain.yes(.5, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveTrain.yes(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Auto_Timer.get() >= 2;
  }
}
