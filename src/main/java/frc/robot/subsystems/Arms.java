package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Arms extends SubsystemBase {
  private CANSparkMax frontleftmotor;

  public Arms() {
    frontleftmotor = new CANSparkMax(3, MotorType.kBrushless);

  }

  public void no(double speed) {
    frontleftmotor.set(speed); 
  }
}