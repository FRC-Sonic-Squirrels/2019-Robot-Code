/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class frontStiltsPIDSubsystem extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  
  public static final WPI_TalonSRX frontStrut1 = new WPI_TalonSRX(RobotMap.FRONT_STRUT_1);
  public static final WPI_TalonSRX frontStrut2 = new WPI_TalonSRX(RobotMap.FRONT_STRUT_2);

  public frontStiltsPIDSubsystem() {
    // Intert a subsystem name and PID values here
    
    super("frontStiltsPIDSubsystem", 10, 0, 1);
    setAbsoluteTolerance(100);  
    getPIDController().setContinuous(false);
    //setSetpoint(setpoint);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    
    return frontStrut1.getSelectedSensorPosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    frontStrut1.pidWrite(output);
    frontStrut2.pidWrite(-output);
  }
}
//encoder.thingy = yes;