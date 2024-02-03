// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//package Reach;
package frc.robot.commands; 

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DualClaw; 

public class Reach extends Command {
  /** Creates a new Reach. */
  private final DualClaw _dualClaw; 
  public Reach(DualClaw dualClaw) {
    // Use addRequirements() here to declare subsystem dependencies.
    _dualClaw = dualClaw;
    addRequirements(_dualClaw);
  }

  /*  Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  */
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    _dualClaw.Reach();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //_dualClaw.stopClaw();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
