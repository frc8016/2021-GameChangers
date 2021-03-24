// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import java.lang.Math;

public class ShooterVisionLimelight extends SubsystemBase {
  double tx, ty, area;
  /** Creates a new ShooterVisionLimelight. */
  public ShooterVisionLimelight() {}

  @Override
  public void periodic() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx").getDouble(0);
    ty = table.getEntry("tx").getDouble(0);
    area = table.getEntry("tx").getDouble(0);
    // This method will be called once per scheduler run
  }
  //returns distance from limelight to target
  public double getTargetDistance(){
    double d = (Constants.ProjectileConstants.targetHight -  Constants.ProjectileConstants.lenseHeight)/
    Math.tan(ty + Constants.ProjectileConstants.lenseAngle);
    return d;
  }
  // returns desired initial velocity for powercell
  public double getIninitalVelocity(double x){
    double numerator= Constants.ProjectileConstants.g * (x * x);
    double denominator = (2 * Constants.ProjectileConstants.cosThetaSqrd)
     * (Constants.ProjectileConstants.y - Constants.ProjectileConstants.yInitial - (Constants.ProjectileConstants.tanTheta_d * x));

    return java.lang.Math.sqrt(numerator/denominator);

  }
  
}
