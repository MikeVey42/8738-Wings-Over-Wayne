// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ElbowMotor extends SubsystemBase {
  private CANSparkMax elbow;
  private RelativeEncoder turn;
  private SparkMaxPIDController turn2;

  public ElbowMotor() {
    elbow = new CANSparkMax(6, MotorType.kBrushless);
    turn = elbow.getEncoder();
    turn2 = elbow.getPIDController();
    turn2.setP(0.3);
    turn2.setOutputRange(-0.5, 0.5);

  }
  public void spin(){
    elbow.set(-0.1);
  }
  public void spinStop(){
    elbow.set(0.0);
  }
  public void zerodefine() {
    turn.setPosition(0);
  }

  public void elbowYes(double position) {
    turn2.setReference(position,ControlType.kPosition);
  }
  public void moveDown(){
    turn2.setReference(25 ,CANSparkMax.ControlType.kPosition);
  }
  public void moveUp(){
    turn2.setReference(5, CANSparkMax.ControlType.kPosition);
  }
  public void upAuto(){

  }
  public void setDefault(){
    turn.setPosition(0);
  }
  @Override
  public void periodic() {

  }
}