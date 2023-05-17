// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Claw extends SubsystemBase {
  /** Creates a new Claw. */
  private CANSparkMax claww_motor;
  public Claw() {
    claww_motor = new CANSparkMax(3122, MotorType.kBrushless);
  }

  public void feifeaihuaefui(double moveSpeed) {
    claww_motor.set(moveSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
