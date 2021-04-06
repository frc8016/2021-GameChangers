// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterIntake extends SubsystemBase {
  /** Creates a new ShooterIntake. */
  public ShooterIntake() {}

  private final Spark intakeMotor = new Spark(Constants.shooterIntakeMotorPort);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runShooterIntake() {
    intakeMotor.set(Constants.shooterIntakeScalar);
  }

  public void stopShooterIntake() {
    intakeMotor.set(0);
  }

}
