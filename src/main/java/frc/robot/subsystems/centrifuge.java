// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class centrifuge extends SubsystemBase {
  
  /** Creates a new centrifuge. */
  public centrifuge() {
   
  }
  private final Spark spark = new Spark(Constants.cenrifugeMotorPort);
  public void runCentrifuge() {
    spark.set(Constants.centrifugeScalar);
  }

  public void stopCentrifuge() {
    spark.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
