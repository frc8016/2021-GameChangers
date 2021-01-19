// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  public DriveTrain() {}
  private WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(Constants.leftFrontMotorPort);
  private WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(Constants.leftBackMotorPort);
  private WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(Constants.rightFrontMotorPort);
  private WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(Constants.rightBackMotorPort);

  private SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);
  private SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);

  private DifferentialDrive differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  
  public void ArcadeDrive(double speed, double rotation){
    differentialDrive.arcadeDrive(speed, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
