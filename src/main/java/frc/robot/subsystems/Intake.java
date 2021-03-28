// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Intake extends SubsystemBase {

  private final Spark IntakeMotor = new Spark(Constants.IntakeMotorPort);

  private final Spark IntakeActuationMotor = new Spark(Constants.IntakeActuationMotorPort);

  private final DigitalInput upperLimitSwitch = new DigitalInput(Constants.IntakeUpperLimitSwitchPort);
  private final DigitalInput lowerLimitSwitch = new DigitalInput(Constants.IntakeLowerLimitSwitchPort);


//Call these methods to set the motor direction for the intake
  public void runIntakeMotorsForward() {
    IntakeMotor.set(-Constants.IntakeMotorSpeedScalar);
  }

  public void runIntakeMotorsBackwards() {
    IntakeMotor.set(Constants.IntakeMotorSpeedScalar);
  }

  public void runIntakeMotorsOff() {
    IntakeMotor.set(0);
  }

//Use this to retract or extend the intake.

//Use caution when testing the RetractIntake and ExtendIntake methods.
//They could accidentally be set to run the motors in the opposite direction as intended.
  public void retractIntake() {

    if (!upperLimitSwitch.get()) {
      IntakeActuationMotor.set(0);
    }
    else {
      IntakeActuationMotor.set(Constants.IntakeActuationMotorScalar);
    }
 }


  public void extendIntake() {
    if (!lowerLimitSwitch.get()) {
      IntakeActuationMotor.set(0);
    }
    else {
      IntakeActuationMotor.set(-Constants.IntakeActuationMotorScalar);
    }  
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