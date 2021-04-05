// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder; // may not be the correct encoder import



public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  private final CANSparkMax flywheelMotor = new CANSparkMax(Constants.flywheelMotorPort, MotorType.kBrushless);

  private final Spark hoodMotor = new Spark(Constants.hoodMotorPort);

  private final DigitalInput hoodHomeLimitSwitch = new DigitalInput(Constants.hoodHomeLimitSwitchPort);

  private final CANEncoder hoodEncoder = flywheelMotor.getEncoder();



  //use these methods to control the flywheel
  public void runFlywheelMotorForward() {
    flywheelMotor.set(Constants.flywheelMotorSpeedScalar);
  }

  public void runFlywheelMotorOff() {
    flywheelMotor.set(0);
  }

  public void setFlywheelMotor(double speed) {
      flywheelMotor.set(speed);
  }

  public void homeHood() {
    if (hoodHomeLimitSwitch.get()) {
      hoodMotor.set(0);
      hoodEncoder.setPosition(0.0);
    }
    else {
      hoodMotor.set(Constants.hoodHomingSpeedScalar);
    }

  }


  public Shooter() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
