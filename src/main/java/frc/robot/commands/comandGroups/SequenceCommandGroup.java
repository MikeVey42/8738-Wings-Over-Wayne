// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.comandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Auto_Drive;
import frc.robot.commands.Elbow_Spin_Command;
import frc.robot.commands.Spin360Auto;
import frc.robot.commands.Spin_command;
import frc.robot.subsystems.Crab_Claw;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ElbowMotor;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SequenceCommandGroup extends SequentialCommandGroup {
  /** Creates a new SequenceCommandGroup. */
  public SequenceCommandGroup(Crab_Claw Crab_Claw, DriveTrain drivesubsystem, ElbowMotor elbowMotor) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand())
    Spin_command Spin_command = new Spin_command(Crab_Claw);
    Auto_Drive Auto_Drive = new Auto_Drive(drivesubsystem);
    Elbow_Spin_Command Auto_up = new Elbow_Spin_Command(elbowMotor);
    Spin360Auto Spin360Auto = new Spin360Auto();
    addCommands(Spin_command, Auto_up, Auto_Drive, Spin360Auto);
  }
}
