// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//package PullDown;
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DualClaw;


public class PullDown extends Command {
  private final DualClaw _dualClaw;

  /** Creates a new PullDown. */
  public PullDown(DualClaw dualClaw) {
    _dualClaw = dualClaw;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(_dualClaw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    _dualClaw.pullDown();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
