// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private CANSparkMax left_front_motor, left_back_motor, right_front_motor, right_back_motor;
  private MotorControllerGroup left_motors, right_motors;
  private DifferentialDrive difDrive;
  public Drivetrain() {
    left_front_motor = new CANSparkMax(3, MotorType.kBrushless);
    left_back_motor = new CANSparkMax(4, MotorType.kBrushless);
    right_front_motor = new CANSparkMax(7, MotorType.kBrushless);
    right_back_motor = new CANSparkMax(8, MotorType.kBrushless);

    left_motors = new MotorControllerGroup(left_back_motor, left_front_motor);
    right_motors = new MotorControllerGroup(right_back_motor, right_front_motor);

    difDrive = new DifferentialDrive(left_motors, right_motors);
    
  }

  public void aaafwefeaaw(double forwardSpeed, double turnSpeed) {
    difDrive.arcadeDrive(forwardSpeed, turnSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

