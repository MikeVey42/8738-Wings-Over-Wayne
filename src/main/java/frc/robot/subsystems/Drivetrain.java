// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  /* Initializing variables */
  CANSparkMax frontLeftMotor;
  CANSparkMax backLeftMotor;
  CANSparkMax frontRightMotor;
  CANSparkMax backRightMotor;

  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;

  DifferentialDrive differentialDrive;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    /* Defines variables */
    frontLeftMotor = new CANSparkMax(0, MotorType.kBrushless);
    backLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
    frontRightMotor = new CANSparkMax(2, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(3,MotorType.kBrushless);

    leftMotors = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    rightMotors = new MotorControllerGroup(frontRightMotor,backRightMotor);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void ArcadeDrive(double forwardSpeed, double turnSpeed) {
    differentialDrive.arcadeDrive(forwardSpeed, turnSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
