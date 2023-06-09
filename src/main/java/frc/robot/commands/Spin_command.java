// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Crab_Claw;


public class Spin_command extends CommandBase {
  Crab_Claw Crab_Claw;
  Timer Spin_Timer;
  /** Creates a new Spin_command. */
  public Spin_command(Crab_Claw Crab_Claw) {
    this.Crab_Claw = Crab_Claw;
    Spin_Timer = new Timer();
    addRequirements(Crab_Claw);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Spin_Timer.restart();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Crab_Claw.spin();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Crab_Claw.setDefault();
    Crab_Claw.spinStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  
    return 1 <= Spin_Timer.get();
  }
}
