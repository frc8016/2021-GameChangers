// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

import java.io.IOException;
import java.nio.file.Path;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Transform2d;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj2.command.RamseteCommand;


public class exampleRamseteCommand extends CommandBase {
  /** Creates a new exampleRamseteCommand. */
  DriveTrain m_driveTrain;
  RamseteCommand ramseteCommand;
  Trajectory trajectory;
  public exampleRamseteCommand(DriveTrain driveTrain) {
    m_driveTrain = driveTrain;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);

    String trajectoryJSON = "paths/SomePath.wpilib.json";
    trajectory = new Trajectory(); 
    try{
      Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON);
      trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
    } catch(IOException ex){
      DriverStation.reportError("Unable to open trajectory: " + trajectoryJSON , ex.getStackTrace());
    }

    ramseteCommand = new RamseteCommand(
      trajectory, 
      m_driveTrain::getPose,
      new RamseteController(Constants.TrajectoryConstants.ramseteGainB, Constants.TrajectoryConstants.ramseteGainZeta),
      new SimpleMotorFeedforward(Constants.TrajectoryConstants.feedForwardKs,
       Constants.TrajectoryConstants.feedForwardKv,
       Constants.TrajectoryConstants.feedForwardKa
       ),
      Constants.kDriveKinematics,
      m_driveTrain::getWheelSpeeds,
      new PIDController(Constants.TrajectoryConstants.feedBackKp, 0, 0),
      new PIDController(Constants.TrajectoryConstants.feedBackKp, 0, 0),
      //ramsete command passes volts to callback
      m_driveTrain::tankDriveVolts,
      m_driveTrain
    );
    
    //reset odometry to trajectory starting position
    //m_trajectoryDrive.resetOdometry(trajectory.getInitialPose());

    //command below is the command used to execute ramsete command, then stop at the end
    //return ramseteCommand.andThen(()-> m_trajectoryDrive.tankDriveVolts(0, 0));


  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveTrain.resetOdometry(trajectory.getInitialPose());
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ramseteCommand.andThen(()-> m_driveTrain.tankDriveVolts(0, 0));
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return(ramseteCommand.isFinished());
    
  }
}
