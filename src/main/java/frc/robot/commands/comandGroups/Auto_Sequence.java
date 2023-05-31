// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.comandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Auto_Drive;
import frc.robot.commands.Auto_Spinno;
import frc.robot.commands.Auto_Spinny;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyro;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auto_Sequence extends SequentialCommandGroup {
  /** Creates a new Auto_Sequence. */
  public Auto_Sequence(DriveTrain drv, Gyro gyro) {
    Auto_Drive auto_Drive = new Auto_Drive(drv);

    Auto_Spinny auto_Spinny = new Auto_Spinny(drv);
    Auto_Spinno auto_Spinno = new Auto_Spinno(drv, gyro);

    
    addCommands(auto_Drive, auto_Spinny, auto_Spinno);
  }
}
