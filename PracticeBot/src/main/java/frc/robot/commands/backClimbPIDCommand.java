/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class backClimbPIDCommand extends Command {
  public int targetPosition = 0;
  public String name = "climbCommand";
  private double kP = 0.0;
  private double kI = 0.0;
  private double kD = 0.0;
  private double kF = 0.0;

  public backClimbPIDCommand(int tpos, double _kP, double _kI, double _kD, double _kF) {
    targetPosition = tpos;
    kP = _kP;
    kI = _kI;
    kD = _kD;
    kF = _kF;
    requires(Robot.m_backStilt);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_backStilt.kP = kP;
    Robot.m_backStilt.kI = kI;
    Robot.m_backStilt.kD = kD;
    Robot.m_backStilt.kF = kF;
    setPosition();
    Robot.m_backStilt.printDebug(name);
  }

  public void setPosition() { 
    // 4096 encoder ticks per revolution
    Robot.m_backStilt.setPosition(targetPosition);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.m_backStilt.printDebug(name);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("BACKSTRUT: Finished moving to " + name + "position");
    Robot.m_backStilt.printDebug(name);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    // maybe we need to stop moving if some other command needs to move the arm
    System.out.println("BACKSTRUT: INTERRUPTED trying to get to " + name + "position");
  }
}
