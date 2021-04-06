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
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import java.lang.Math;



public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  private final CANSparkMax flywheelMotor = new CANSparkMax(Constants.flywheelMotorPort, MotorType.kBrushless);

  // private final Spark hoodMotor = new Spark(Constants.hoodMotorPort);

  // private final DigitalInput hoodHomeLimitSwitch = new DigitalInput(Constants.hoodHomeLimitSwitchPort);

  private final CANEncoder hoodEncoder = flywheelMotor.getEncoder();

  double tx, ty, area;


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

  // public void homeHood() {
  //   if (hoodHomeLimitSwitch.get()) {
  //     hoodMotor.set(0);
  //     hoodEncoder.setPosition(0.0);
  //   }
  //   else {
  //     hoodMotor.set(Constants.hoodHomingSpeedScalar);
  //   }

  // }


  public Shooter() {}

  @Override
  public void periodic() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx").getDouble(0);
    ty = table.getEntry("tx").getDouble(0);
    area = table.getEntry("tx").getDouble(0);
    // This method will be called once per scheduler run
  }
}
