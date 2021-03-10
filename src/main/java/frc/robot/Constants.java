  
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
//drivetrain
	public static final int leftFrontMotorPort = 0;
	public static final int leftBackMotorPort = 1;
	public static final int rightFrontMotorPort = 2;
	public static final int rightBackMotorPort = 3;

	public static final int [] leftEncoderDIO = {0,1};
	public static final int [] rightEncoderDIO = {2,3};

	public static final int pigeonIMUPort = 0;

	public static final int joystickPort = 0;

	public static final int joyXAxis = 0;
	public static final int joyYAxis = 1;
	public static final int joyZAxis = 2;

	public static final int IntakeMotorPort = 0;

	public static final int IntakeSolenoidPort1 = 0;
	public static final int IntakeSolenoidPort2 = 1;

	public static final double IntakeMotorSpeedScalar = .5;

	public static final int XboxControllerPort = 1;

	public static final int LeftAxisX = 0;
	public static final int LeftAxisY = 1;
	public static final int RightAxisX = 4;
	public static final int RightAxisY = 5;

	public static final int TriggerLeft = 2;
	public static final int TriggerRight = 3;

	public static final int ButtonLeft = 4;
	public static final int ButtonRight = 5;

	public static final int ButtonA = 0;
	public static final int ButtonB = 1;
	public static final int ButtonX = 2;
	public static final int ButtonY = 3;

	public static final int ButtonBack = 6;
	public static final int ButtonMenu = 7;

	public static final int ButtonStickLeft = 8;
	public static final int ButtonStickRight = 9;

	public static final double kTrackWidthMeters = 0;
	public static final  DifferentialDriveKinematics kDriveKinematics =
	new DifferentialDriveKinematics(kTrackWidthMeters);
	

	public final class TrajectoryConstants{
		public static final double feedForwardKs = 0;
		public static final double feedForwardKv = 0;
		public static final double feedForwardKa = 0;

		public static final double feedBackKp = 0;
		
		public static final double kMaxSpeedMetersPerSecond = 0;
		public static final double kMaxAccelerationMetersPerSecondSquared = 0;

		public static final double ramseteGainB = 2;
		public static final double ramseteGainZeta = .7;
		public static final double distancePerPulse = 0;

		

		

	}
}
