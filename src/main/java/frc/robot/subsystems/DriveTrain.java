// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveTrain extends SubsystemBase {
  private CANSparkMax frontleftmotor, frontrightmotor, backleftmotor, backrightmotor;
  private MotorControllerGroup controllerleft, controllerright;
  private DifferentialDrive drive;

  public DriveTrain() { 
    frontleftmotor = new CANSparkMax(3, MotorType.kBrushless);
    frontrightmotor = new CANSparkMax(7, MotorType.kBrushless);
    backleftmotor = new CANSparkMax(4, MotorType.kBrushless);
    backrightmotor = new CANSparkMax(8, MotorType.kBrushless);
    controllerleft = new MotorControllerGroup(frontleftmotor, backleftmotor);
    controllerright = new MotorControllerGroup(frontrightmotor, backrightmotor);
    drive = new DifferentialDrive(controllerleft, controllerright);
  }

  public void yes(double speed, double turnspeed) {
    drive.arcadeDrive(speed, turnspeed, false);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}