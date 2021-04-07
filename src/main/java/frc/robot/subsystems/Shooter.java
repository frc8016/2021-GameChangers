// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder; // may not be the correct encoder import
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import java.lang.Math;



public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  private final CANSparkMax flywheelMotor = new CANSparkMax(Constants.flywheelMotorPort, MotorType.kBrushless);

  // private final Spark hoodMotor = new Spark(Constants.hoodMotorPort);

  // private final DigitalInput hoodHomeLimitSwitch = new DigitalInput(Constants.hoodHomeLimitSwitchPort);

  private final CANEncoder flywheelEncoder = flywheelMotor.getEncoder();

  private final CANPIDController pidConroller = flywheelMotor.getPIDController();

  double tx, ty, area;

  double speed = 0;

  double previousError = 0;
  double integral = 0;


  //use these methods to control the flywheel
  public void runFlywheelMotorForward() {
    flywheelMotor.set(Constants.flywheelMotorSpeedScalar);
  }

  public void runFlywheelMotorOff() {
    flywheelMotor.set(0);
  }

  public void setFlywheelMotor() {
      flywheelMotor.set(Constants.flywheelMotorSpeedScalar);
  }
  public double getTargetDistance(){
    double d = (Constants.targetHeight -  Constants.lenseHeight)/
    Math.tan(ty + Constants.lenseAngle);
    return d;
  }

  public double getIninitalVelocity(double x){
    double numerator= Constants.ProjectileConstants.g * (x * x);
    double denominator = (2 * Constants.ProjectileConstants.cosThetaSqrd)
     * (Constants.ProjectileConstants.y - Constants.ProjectileConstants.yInitial - (Constants.ProjectileConstants.tanTheta_d * x));

    return java.lang.Math.sqrt(numerator/denominator);
  }
  public void RunFlywheelPID(){
    pidConroller.setReference(Constants.flyWheelRPM, ControlType.kVelocity);
  }

  // public void homeHood() {
  //   if (hoodHomeLimitSwitch.get()) {
  //     hoodMotor.set(0);
  //     hoodEncoder.setPosition(0.0);
  //   }
  //   else {
  //     hoodMotor.set(Constants.hoodHomingSpeedScalar);
  //   }

  // }


  public Shooter() {
    pidConroller.setP(Constants.pFlywheel);
    pidConroller.setI(Constants.iFlywheel);
    pidConroller.setD(Constants.dFlywheel);
    pidConroller.setFF(Constants.ffFlywheel);
    pidConroller.setIZone(Constants.izFlywheel);
    // pidConroller.setOutputRange(Constants.minFlywheel, Constants.maxFlywheel);
  }

  @Override

  public void periodic() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx").getDouble(0);
    ty = table.getEntry("ty").getDouble(0);
    area = table.getEntry("ta").getDouble(0);
    SmartDashboard.putNumber("Shooter RPM", flywheelEncoder.getVelocity());
    SmartDashboard.putNumber("Shooter Error", Constants.flyWheelRPM - flywheelEncoder.getVelocity());
    // This method will be called once per scheduler run
  }

  public void manualPID(){
    double error = Constants.flyWheelRPM - flywheelEncoder.getVelocity();
    integral += error*.02;
    double derivative = (error -previousError) / .02;
    flywheelMotor.set(error * Constants.pFlywheel+ integral * Constants.iFlywheel + derivative * Constants.dFlywheel);
    previousError = error;

  }

  public void flywheelRampUp(){
      speed += 0.05;
      flywheelMotor.set(speed);
  }


  public CANEncoder flywheelEncoder() {
    return flywheelEncoder;
  }

  public void setShooterRPM(double input) {
    double multiplier = -input * 0.5 + 0.5;
    flywheelMotor.set(multiplier);
  }
}
