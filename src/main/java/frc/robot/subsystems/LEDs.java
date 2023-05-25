// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.lang.reflect.Method;

import javax.swing.text.Position;

import org.ejml.data.ZMatrix;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.simulation.AddressableLEDSim;
import edu.wpi.first.wpilibj.util.Color;

public class LEDs extends SubsystemBase {
 private int LedAmount;
 private AddressableLED Leds;
 private AddressableLEDBuffer Buffer;
  /** Creates a new LEDs. */
  public LEDs() {
LedAmount = 80;
Leds = new AddressableLED(9);
Buffer = new AddressableLEDBuffer(LedAmount);

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void ChangeLEDLight(int Position,Color lEDColor){
    Buffer.setLED(Position, lEDColor);
  }
  public void PushLEDupdate(){
    Leds.setData(Buffer);
    Leds.start();
  }
  public Color receiveLEDColor(int Position){
    return.Buffer.getLED(Position);
  }
  
}
