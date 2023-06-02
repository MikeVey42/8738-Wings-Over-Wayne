package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.kauailabs.navx.frc.AHRS.SerialDataType;

import edu.wpi.first.networktables.BooleanEntry;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gyro extends SubsystemBase {
  /** Creates a new Gyro. */
  private final AHRS m_gyro;

  private ShuffleboardTab gyroTab;
  private SimpleWidget gyroWidget;
  private BooleanEntry flipped;
  private GenericEntry flippedData;

  public Gyro() {
    m_gyro = new AHRS(SerialPort.Port.kUSB1, SerialDataType.kProcessedData, (byte) 60);
    m_gyro.enableLogging(true);

    gyroTab = Shuffleboard.getTab("dAvid");
    gyroWidget = gyroTab.add("Upsidedown?",false);
    flippedData = gyroWidget.getEntry();
  }

  public double getYaw(){
    return -m_gyro.getYaw() + 180;
  }

  public double getPitch(){
    return m_gyro.getPitch() + 1;
  }

  public double getRoll(){
    return m_gyro.getRoll() + 1.7;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if (Math.abs(m_gyro.getRoll())> 90){
      flippedData.setBoolean(true);
    }
    else if(Math.abs(m_gyro.getPitch())> 90){
      flippedData.setBoolean(true);
    }
    else{
      flippedData.setBoolean(false);
    }
  }
}
