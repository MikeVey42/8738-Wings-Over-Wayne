// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyro;

public class autoBalance extends CommandBase {
  /** Creates a new autoBalance. */
  private Gyro Gyro;
  private double initialGyroPitch;
  private double GyroPitch;
  private DriveTrain DriveTrain; 

  public autoBalance(Gyro Gyro, DriveTrain DriveTrain) {
    this.Gyro = Gyro; 
    this.DriveTrain = DriveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initialGyroPitch = Gyro.getPitch();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    GyroPitch = Gyro.getPitch();
    if (GyroPitch == initialGyroPitch){
      DriveTrain.yes(-.2, 0);
    }
    else if (GyroPitch >= initialGyroPitch){
      DriveTrain.yes(-0.2, 0);
    
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
