/*
 * NOTES:
 * - Removed RobotContainer.java class because it contained so many errors and I wasn't sure that we actually needed that class.
 * - Added the old Constants.java class from the initial commit on GitHub and removed PID functions, since we don't need them this year.
 * - Note that the Constants.java class is never used - I just added it because it seems like something we actually need and have put some work into.
 * - Used a template drivetrain file and noted any differences between our current GitHub Robot.java version as comments.
 * - From what I understand, this code should work with only the joysticks - no button functions. Contains teleop joystick controls and should
 *   drive for about two seconds during autonomous (that's what the comments that came with the template said, anyway).
 * - I removed all of the explanatory comments that came with the file just to clean up the code a little bit and make it easier to find things and added
 *   tags to some of the more important methods so that they're easier to find later if you have certain extensions installed (I think one of the
 *   extensions that comes with WPILib enables it, but if not, there are extensions to enable todo and fixme highlights).
 * - This program builds successfully and doesn't throw a warning that one Gradle Daemon was incompatible or failed or something like that, which
 *   the old code did. That might have had something to do with the conflicting versions of WPILib.
 * - This program was completely created in the newest version of WPILib, which might also hopefully help since WPILib said there was a compatibility
 *   issue.
 * - Created using the basic steps on the WPILib documentation that Ms. Emily posted in Slack.
 * - Not in any repository so we'll need to make a repository and run it on the normal laptop or get an ethernet dongle to run it from this computer.
 * 


// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
*/

package frc.robot;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

/* Old code contained:
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; */

public class Robot extends TimedRobot {

  /* Old code contained:
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>(); */

  //TODO Variable Initialization
  private final PWMSparkMax m_leftDrive = new PWMSparkMax(0);
  private final PWMSparkMax m_rightDrive = new PWMSparkMax(1);
  private final DifferentialDrive m_robotDrive =
      new DifferentialDrive(m_leftDrive::set, m_rightDrive::set);
  private final XboxController m_controller = new XboxController(0);
  private final Timer m_timer = new Timer();

  public Robot() { //Note: this method was not present in the old code.
    SendableRegistry.addChild(m_robotDrive, m_leftDrive);
    SendableRegistry.addChild(m_robotDrive, m_rightDrive);
  }

  @Override
  public void robotInit() {

    /*Old code method contained only:
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser); */

    m_rightDrive.setInverted(true);
  }

  /*Old code contained:
  public void robotPeriodic() {} */

  //TODO Autonomous Init
  @Override
  public void autonomousInit() {

    /*Old code method contained only:
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected); */

    m_timer.restart();
  }

  //TODO Autonomous Periodic
  @Override
  public void autonomousPeriodic() {

    /*Old code method contained only:
      switch (m_autoSelected) {
        case kCustomAuto:
          // Put custom auto code here
          break;
        case kDefaultAuto:
        default:
          // Put default auto code here
          break;
      } */

    if (m_timer.get() < 2.0) {
      m_robotDrive.arcadeDrive(0.5, 0.0, false);
    } else {
      m_robotDrive.stopMotor();
    }
  }

  //TODO Teleop Init
  @Override
  public void teleopInit() {}

  //TODO Teleop Periodic
  @Override
  public void teleopPeriodic() {
    //Old code method was empty.
    m_robotDrive.arcadeDrive(-m_controller.getLeftY(), -m_controller.getRightX());
  }

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  /*Old code contained:
  
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {} */

}
