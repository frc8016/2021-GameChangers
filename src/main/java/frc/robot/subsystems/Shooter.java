// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder; // may not be the correct encoder import



public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  private final Spark flywheelMotor = new Spark(Constants.flywheelMotorPort);


  private final Spark hoodMotor = new Spark(Constants.hoodMotorPort);

  private final DigitalInput hoodHomeLimitSwitch = new DigitalInput(Constants.hoodHomeLimitSwitchPort);

  private final Encoder hoodEncoder = new Encoder(Constants.hoodEncoderDIO[0],Constants.hoodEncoderDIO[1]);

  private final PIDController flywheelMotorPIDController = new PIDController(Constants.flywheelMotor_kP, Constants.flywheelMotor_kI, Constants.flywheelMotor_kD);
  // private final PIDController hoodMotorPIDController = new PIDController(Constants.hoodMotor_kP, Constants.hoodMotor_kI, Constants.hoodMotor_kD);

  flywheelMotorPIDController.setPoint(0.1);




  //use these methods to control the flywheel
  public void runFlywheelMotorForward() {
    flywheelMotorPIDController.setSetpoint(0.1);
    // this is set to an arbitrary value that will not damage any components.
    // In the final code the 0.1 should be replaced by a number returned by the vision system.
    // If this is not possible, I can set seperate speeds for each shooting position.
    // I didn't put the value in Constants because it will be constantly changing.
  }

  public void runFlywheelMotorOff() {
    flywheelMotor.set(0);
  }

  public void homeHood() {
    if (hoodHomeLimitSwitch.get()) {
      hoodMotor.set(0);
      hoodEncoder.reset();
    }
    else {
      hoodMotor.set(Constants.hoodHomingSpeedScalar);
    }

  }

  // public void adjustShooterHoodAngle() {
  //   hoodMotorPIDController.setSetpoint(0.1);
    // this is set to an arbitrary value that will not damage any components.
    // In the final code the 0.1 should be replaced by a number returned by the vision system.
    // If this is not possible, I can set seperate speeds for each shooting position.
    // I didn't put the value in Constants because it will be constantly changing.


  public Shooter() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
