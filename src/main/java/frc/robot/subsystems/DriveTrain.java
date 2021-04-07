// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Encoder; // may not be the correct encoder import
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import java.lang.Math;

import com.ctre.phoenix.sensors.PigeonIMU;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(Constants.leftFrontMotorPort);
  private final WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(Constants.leftBackMotorPort);
  private final WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(Constants.rightFrontMotorPort);
  private final WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(Constants.rightBackMotorPort);

  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);
  
  private DifferentialDrive differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

  private final Encoder leftEncoder = new Encoder(Constants.leftEncoderDIO[0],Constants.leftEncoderDIO[1]);
  private final Encoder rightEncoder = new Encoder(Constants.rightEncoderDIO[0], Constants.rightEncoderDIO[1]);

  double integral = 0;
  double dsError;
  double dTDIntegral;

  double kp = 0.03;
  double min_command = 0.027;

  double tx, ty, area;

  double limelightCorrection = 0;

  double d2dError;

  
// creates odometry class
  private final DifferentialDriveOdometry m_odometry;


 
  private final PigeonIMU pigeonIMU = new PigeonIMU(Constants.pigeonIMUPort);
  

// transforms pigeonIMY yaw output into a Rotation2d object --!! may be returning heading in degrees instead of rotation2d
  public Rotation2d getHeading(){
    double [] ypr_deg = new double [3];
    pigeonIMU.getYawPitchRoll(ypr_deg);
    //if reversed multiply by -1d??
    return Rotation2d.fromDegrees(Math.IEEEremainder(ypr_deg[0], 360.0d));

  }

 
 




  /** Creates a new DriveTrain. */
  public DriveTrain() {
    // leftEncoder.setDistancePerPulse(Constants.TrajectoryConstants.distancePerPulse);
    // rightEncoder.setDistancePerPulse(Constants.TrajectoryConstants.distancePerPulse);
    // resetEncoders();

    m_odometry = new DifferentialDriveOdometry(getHeading());

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    m_odometry.update(getHeading(), leftEncoder.getDistance(), rightEncoder.getDistance());
    SmartDashboard.putNumber("Error", dsError);

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx").getDouble(0);
    ty = table.getEntry("ty").getDouble(0);
    area = table.getEntry("ta").getDouble(0);
    SmartDashboard.putNumber("Distance from Power Port", this.getTargetDistance());
    SmartDashboard.putNumber("Align Error", limelightCorrection);
    SmartDashboard.putNumber("Drive Error", d2dError);
    SmartDashboard.putNumber("PowerPort Angle", tx);


  }
  // gets robots estimated pose --be sure to use consistent units
  public Pose2d getPose(){
    return m_odometry.getPoseMeters();
  }

  // returns the current drivetrain wheel speeds
  public DifferentialDriveWheelSpeeds getWheelSpeeds(){
    return new DifferentialDriveWheelSpeeds(leftEncoder.getRate(), rightEncoder.getRate());
  }

  // resets odometry to specified pose
  public void resetOdometry(Pose2d pose){
    resetEncoders();
    m_odometry.resetPosition(pose, getHeading());
  }
  
  //drive robot with arcade drive
  public void ArcadeDrive(double speed, double rotation){
    differentialDrive.arcadeDrive(-speed, rotation);
  }

  // directly controls left and right motors with voltages
  public void tankDriveVolts(double leftVolts, double rightVolts){
    leftMotors.setVoltage(leftVolts);
    rightMotors.setVoltage(rightVolts);
    differentialDrive.feed();
  }

  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  // returns average encoder readings
  public double getAverageEncoderDistance(){
    return (leftEncoder.getDistance() + rightEncoder.getDistance()) /2.0;

  }

  // get left drivetrain encoder
  public Encoder getLeftEncoder(){
    return leftEncoder;
  }

  // get right drivetrain encoder
  public Encoder getRightEncoder(){
    return rightEncoder;
  }

  // sets max output of the drivetrain
  public void setMaxDriveOutput(double maxOutput){
    differentialDrive.setMaxOutput(maxOutput);
  }

  // resets gyro yaw value

  public void zeroHeading(){
    pigeonIMU.setYaw(0);
    pigeonIMU.setFusedHeading(0);
  }

  public double getTurnRate(){
    double[] xyz_dps = new double[3];
    pigeonIMU.getRawGyro(xyz_dps);
    //value may need to be negative?
    return xyz_dps[2];

    
  }

  // public void driveToZero(double speed){
  //   double actualHeading = pigeonIMU.getFusedHeading();
  //   double p = Constants.pDriveStraight;
  //   double i = Constants.iDriveStraight;
  //   double error = actualHeading; 
  //   dsError = error;
  //   integral += error*0.02;
  //   double correction = error*p + integral*i;

  //   this.ArcadeDrive(speed, -correction);
    
  // }

public void driveToZero_Limelight(double speed){
  double error = tx;
  limelightCorrection = 0;
  if(tx > 1.0){
    limelightCorrection = kp*error + min_command;
  } 
  else if(tx < 1.0){
    limelightCorrection = kp*error - min_command;

  }
  ArcadeDrive(speed, limelightCorrection);

}

  public double getTargetDistance(){
    double a2 = Math.toRadians(ty);
    double d = (Constants.targetHeight -  Constants.lenseHeight)/
    Math.tan(a2 + Constants.lenseAngle);
    return d;
  }
  


  public double driveToDistance(double desiredDistance){
    d2dError = this.getTargetDistance() - desiredDistance;
    dTDIntegral += d2dError* .02;
    double output = d2dError* Constants.dTDProportional + dTDIntegral * Constants.dTDIntegral;
    return output;



  }




}