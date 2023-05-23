// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class limelight extends SubsystemBase {
  public NetworkTable table;
  public double aprilTag;
  public double targetDetected;
  public double offsetX;
  public double offsetY;
  public NetworkTableEntry pipeline;
  /** Creates a new limelight. */
  public limelight() {    
    table = NetworkTableInstance.getDefault().getTable("limelight-slice");
    pipeline = table.getEntry("pipeline");
  }
  public double getAprilTag() {
      return aprilTag;
  }
  public double getTarget(){
    return targetDetected;
  }
  public double getoffsetX(){
    return offsetX;
  }
  public double getOffsetY(){
    return offsetY;
  }
  public void setPipeline(double pipelineVariable){
    pipeline.setDouble(pipelineVariable);
    
  }
  @Override
  public void periodic() {
    aprilTag = table.getEntry("tid").getDouble(0);
    targetDetected = table.getEntry("tv").getDouble(0);
    offsetX = table.getEntry("tx").getDouble(0);
    offsetY = table.getEntry("ty").getDouble(0);

    // This method will be called once per scheduler run
  }
}
