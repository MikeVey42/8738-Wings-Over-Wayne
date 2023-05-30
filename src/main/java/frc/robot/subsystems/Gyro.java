package frc.robot.subsystems;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.kauailabs.navx.frc.AHRS;
import com.kauailabs.navx.frc.AHRS.SerialDataType;
import com.revrobotics.CANSparkMax;

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
  
  private ShuffleboardTab shuffle;
  SimpleWidget inspectorgadget;
  GenericEntry controldata;
  public Gyro() {
    m_gyro = new AHRS(SerialPort.Port.kUSB1, SerialDataType.kProcessedData, (byte) 60);
    m_gyro.enableLogging(true);


     shuffle = Shuffleboard.getTab("dAvid");
     inspectorgadget = shuffle.add("FLIP",false);
     controldata = inspectorgadget.getEntry();
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
    boolean getrotated = Math.abs(getRoll()) >= 90;
    boolean getpitched = Math.abs(getPitch()) >= 90;
    controldata.setBoolean(getpitched || getrotated);
    
  }
}
