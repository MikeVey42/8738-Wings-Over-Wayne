// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {

  private final CANSparkMax elvMotor1, elvMotor2;
  private final MotorControllerGroup elvGroup;

  private RelativeEncoder elvEncoder1, elvEncoder2;
  private SparkMaxPIDController elvController1, elvController2;

  private DigitalInput limitSwitch1, limitSwitch2;


  /** Creates a new Elevator. */
  public Elevator() {
    elvMotor1 = new CANSparkMax(1, MotorType.kBrushless);
    elvMotor2 = new CANSparkMax(2, MotorType.kBrushless);

    elvMotor1.setInverted(true);
    elvMotor2.setInverted(false);

    elvGroup = new MotorControllerGroup(elvMotor1, elvMotor2);


    elvEncoder1 = elvMotor1.getEncoder();
    elvEncoder2 = elvMotor2.getEncoder();

    elvController1 = elvMotor1.getPIDController();
    elvController2 = elvMotor2.getPIDController();

    limitSwitch1 = new DigitalInput(9);
    limitSwitch2 = new DigitalInput(8);

  }

  public void setSetPoint(){

    elvEncoder1.setPosition(0);
    elvEncoder2.setPosition(0);
  }

  public void goSetPoint(){
    elvController1.setReference(0, CANSparkMax.ControlType.kPosition);
    elvController2.setReference(0, CANSparkMax.ControlType.kPosition);
  }

  public void manualElevator(double speed){
    elvGroup.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
