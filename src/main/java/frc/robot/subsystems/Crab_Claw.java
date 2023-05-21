// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.ControlType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Crab_Claw extends SubsystemBase {
  /** Creates a new Crab_Claw. */  
  private RelativeEncoder Encoder;
  private SparkMaxPIDController PID;
  private CANSparkMax CrabMotor;

  public Crab_Claw() {
    CrabMotor = new CANSparkMax(9, MotorType.kBrushless);
    Encoder = CrabMotor.getEncoder();
    PID = CrabMotor.getPIDController();
    PID.setP(0.1);
    PID.setOutputRange(-.2, .2);
    }
  public void spin(){
    CrabMotor.set(0.4);
  }
  public void spinStop(){
    CrabMotor.set(0.0);
  }
  public void clawOpen(){
    PID.setReference(-36 ,CANSparkMax.ControlType.kPosition);
  }
  public void clawClose(){
    PID.setReference(0 ,CANSparkMax.ControlType.kPosition);
  }
  public void setDefault(){
    Encoder.setPosition(0);
  }
@Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}

