// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class itstheClaw extends SubsystemBase {

  private CANSparkMax clawMotor;

  /** Creates a new itstheClaw. */
  public itstheClaw() {
    clawMotor = new CANSparkMax(69, MotorType.kBrushless);
  }

  public void moveClawForward(double speed1){
    clawMotor.set(speed1);
  }

  public void moveClawBackward(double speed2) {
    clawMotor.set(speed2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
