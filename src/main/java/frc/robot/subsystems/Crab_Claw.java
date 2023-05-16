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

  private Crab_Claw() {
    CrabMotor = new CANSparkMax(9, MotorType.kBrushless);
    Encoder = CrabMotor.getEncoder();
    PID = CrabMotor.getPIDController();
    
    }
  
  public void clawOpen(){
    setReference(5 ,CANSparkMax.ControlType.kPosition);
  }
  public void clawClose(){
    setReference(-5 ,CANSparkMax.ControlType.kPosition);
  }

@Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}

