/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

public class armLowCommand extends armCommand {

  public armLowCommand() {
    // targetPosition, kP, kI, kD, kF
    super(2500, 0.3, 0.0, 0.0, 0.0);

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    name = "Low";
  }

}

