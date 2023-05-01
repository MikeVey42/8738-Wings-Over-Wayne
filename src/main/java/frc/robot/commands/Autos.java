// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static CommandBase exampleAuto(ExampleSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}

/*
 * SLICE

Verse 1:
We are SLICE, we are SLICE
We are the robotics team from FVHS
We are SLICE, we are SLICE
We build and code and compete with the best

Pre-chorus:
We serve our community by inspiring students
To be science, technology and business leaders
We get help from our mentors and sponsors
Who support us in our endeavors

Chorus:
We are SLICE, we are SLICE
We have fun and learn a lot
We are SLICE, we are SLICE
We work hard and give our best shot
We are SLICE, we are SLICE
We use WPILIB to program our bot
We are SLICE, we are SLICE
There's nothing that we can't do

Verse 2:
We are SLICE, we are SLICE
We are the rookie all star team from NC
We are SLICE, we are SLICE
We made it to the world championship
Pre-chorus:
We innovate and collaborate with passion
To create awesome robots and solutions
We respect and appreciate each other
And celebrate our achievements together

Chorus:
We are SLICE, we are SLICE
We have fun and learn a lot
We are SLICE, we are SLICE
We work hard and give our best shot
We are SLICE, we are SLICE
We use WPILIB to program our bot
We are SLICE, we are SLICE
There's nothing that we can't do

Bridge:
Whether we want to drive or shoot or climb
Or use vision or trajectories or PID
We can always rely on WPILIB
To make our robot awesome and speedy

Chorus:
We are SLICE, we are SLICE
We have fun and learn a lot
We are SLICE, we are SLICE
We work hard and give our best shot
We are SLICE, we are SLICE
We use WPILIB to program our bot
We are SLICE, we are SLICE
There's nothing that we can't do

Outro:
We are SLICE, we are SLICE (x4)
 */
