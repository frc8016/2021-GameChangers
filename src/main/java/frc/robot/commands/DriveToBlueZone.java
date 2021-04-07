// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;


public class DriveToBlueZone extends CommandBase {
	//Joystick driverStick = new Joystick(Constants.joystickPort);
  /** Creates a new DriveStraight. */
  DriveTrain m_driveTrain;
  public DriveToBlueZone(DriveTrain driveTrain) {
	// Use addRequirements() here to declare subsystem dependencies.
	m_driveTrain = driveTrain;
	addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   //m_driveTrain.zeroHeading(); 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
	  m_driveTrain.driveToZero_Limelight(m_driveTrain.driveToDistance(Constants.blueZoneShootingDistance));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
	m_driveTrain.ArcadeDrive(0, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

