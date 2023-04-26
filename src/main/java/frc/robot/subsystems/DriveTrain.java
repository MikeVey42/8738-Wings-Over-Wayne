// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SerialPort;

public class DriveTrain extends SubsystemBase {
  private CANSparkMax frontLeftMotor;
  private CANSparkMax frontRightMotor; 
  private CANSparkMax backLeftMotor; 
  private CANSparkMax backRightMotor; 
  private MotorControllerGroup leftSide;
  private MotorControllerGroup rightSide;
  private DifferentialDrive train;
  private AHRS Gyro;

  //MotorType.kBrushless
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    frontLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
    frontRightMotor = new CANSparkMax(7, MotorType.kBrushless);
    backLeftMotor = new CANSparkMax(4, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(8, MotorType.kBrushless);
    leftSide = new MotorControllerGroup(frontLeftMotor,backLeftMotor);
    rightSide = new MotorControllerGroup(frontRightMotor,backRightMotor);
    train = new DifferentialDrive(leftSide, rightSide);
    Gyro = new AHRS(SerialPort.Port.kUSB1);
  }
  public void Drive(double forward, double turn){
    train.arcadeDrive(forward, turn);
  }
  public double GetYaw(){
    return Gyro.getYaw();
  }
  public double GetRoll(){
    return Gyro.getRoll();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
