// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Intake extends SubsystemBase {

  private final Spark IntakeMotor = new Spark(Constants.IntakeMotorPort);

  private final DoubleSolenoid IntakeSolenoid = new DoubleSolenoid(Constants.IntakeSolenoidPort1,
      Constants.IntakeSolenoidPort2);

//Call these methods to set the motor direction for the intake
  public void runIntakeMotorsForward() {
    IntakeMotor.set(Constants.IntakeMotorSpeedScalar);
  }

  public void runIntakeMotorsBackwards() {
    IntakeMotor.set(-Constants.IntakeMotorSpeedScalar);
  }

  public void runIntakeMotorsOff() {
    IntakeMotor.set(0);
  }

//Use this to retract or extend the intake.
  public void retractIntake() {
    IntakeSolenoid.set(Value.kReverse);
  }
  public void extendIntake() {
    IntakeSolenoid.set(Value.kForward);
  }

  /**
   * Creates a new Intake.
   */
  public Intake() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}