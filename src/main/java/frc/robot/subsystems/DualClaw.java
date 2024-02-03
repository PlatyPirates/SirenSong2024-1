// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
//import com.revrobotics.CANSparkMax.IdleMode;
//import com.revrobotics.CANSparkMax.MotorType;
//import com.revrobotics.CANSparkMax.SoftLimitDirection;
import edu.wpi.first.wpilibj2.command.RunCommand; 
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants; 
import frc.robot.Constants.IntakeConstants; 

public class DualClaw extends SubsystemBase {
  /** Creates a new DualClaw. */
  private final CANSparkMax _clawMotor = new CANSparkMax(Constants.IntakeConstants.clawMotor, MotorType.kBrushless);
  private final RelativeEncoder _encoder = _clawMotor.getEncoder();

  private double _clawPower = Constants.IntakeConstants.clawMotorPower;

  public DualClaw() {
    setDefaultCommand(new RunCommand(this::stop, this));

    _clawMotor.restoreFactoryDefaults();
    _clawMotor.setIdleMode(IdleMode.kBrake);
    _clawMotor.enableSoftLimit(SoftLimitDirection.kReverse, true);
    _clawMotor.setSoftLimit(SoftLimitDIrection.kReverse, IntakeConstants.clawLimitIn);
    _clawMotor.enableSoftLimit(SoftLimitDirection.kForward, true);
    _clawMotor.setSoftLimit(SoftLimitDirection.kForward, IntakeConstants.clawLimitOut);
    _clawMotor.burnFlash();
  }
  public void stop() {
    _clawMotor.stopMotor();
  }
  public void clawIn(){
    _clawMotor.set(_clawPower);
  }
  public void clawOut(){
    _clawMotor.set(-_clawPower);
  }
  public void go(double clawPower){
    _clawMotor.set(clawPower);
  }
  public void setClawPower (double clawPower){
    _clawPower = clawPower;
  }
  public double getPosition(){
    return _encoder.getPosition();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
