// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import java.lang.reflect.Method;
import java.util.ArrayList;

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
    return Buffer.getLED(Position);
  }
  public void turnOffLED(){
    for(int y = 0; y < 80; y++){
      ChangeLEDLight(y, Color.kBlack);
    }
    PushLEDupdate();
  }


  /**
   * Applies a pattern to all the LEDs of the robot
   * @param pattern
   */
  public void applyPattern(Color[] pattern) {
    // Apply the pattern to all 4 strips
    applyPatternToStrip(pattern, Constants.LEDConstants.LEFT_STRIP_START, Constants.LEDConstants.LEFT_STRIP_END);
    applyPatternToStrip(pattern, Constants.LEDConstants.RIGHT_STRIP_START, Constants.LEDConstants.RIGHT_STRIP_END);
    applyPatternToStrip(pattern, Constants.LEDConstants.LOOP_LEFT_START, Constants.LEDConstants.LOOP_LEFT_END);
    applyPatternToStrip(pattern, Constants.LEDConstants.LOOP_RIGHT_START, Constants.LEDConstants.LOOP_RIGHT_END);
    
    // Apply the first color in the pattern to the top of the loop
    for (int i = Constants.LEDConstants.LOOP_TOP_START; i <= Constants.LEDConstants.LOOP_TOP_END; i++) {
      ChangeLEDLight(i, pattern[0]);
    }

    // Apply the last color of the pattern to the bottom of the loop
    for (int i = Constants.LEDConstants.LOOP_BOTTOM_START; i <= Constants.LEDConstants.LOOP_BOTTOM_END; i++) {
      ChangeLEDLight(i, pattern[pattern.length - 1]);
    }
  }

  /**
   * Colors an LED strip by splitting it into even chunks and apply a different color to each chunk
   * @param pattern the list of colors to apply. pattern.length is the number of chunks to split into
   * @param start the ID of the first light in the strip
   * @param end the ID of the last light in the strip
   */
  private void applyPatternToStrip(Color[] pattern, int start, int end) {
    if (end > start) {
      // Apply the pattern from lowest to greatest ID

      for (int i = start; i <= end; i++) {
        // Number of LEDs in the strip
        int length = (1 + end - start);
        // Percentage of the way through the strip
        double percentage = (double) (i - start) / length;
        // What part of the pattern to apply
        int index = (int) (percentage * pattern.length);
        // Color to apply
        Color color = pattern[index];
        ChangeLEDLight(i, color);
      }
    } else {
      // Apply the pattern from greatest to lowest ID

      for (int i = start; i >= end; i--) {
        // Number of LEDs in the strip
        int length = (1 + start - end);
        // Percentage of the way through the strip
        double percentage = (double) (start - i) / length;
        // What part of the pattern to apply
        int index = (int) (percentage * pattern.length);
        // Color to apply
        Color color = pattern[index];
        ChangeLEDLight(i, color);
      }
    }
  }
  
}