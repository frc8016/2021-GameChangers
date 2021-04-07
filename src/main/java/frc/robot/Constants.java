  
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
	public static final int joyPaddleAxis = 3;
	public static final int button1 = 1;
	public static final int button2 = 2;
	public static final int button3 = 3;
	public static final int button4 = 4;
	public static final int button5 = 5;
	public static final int button6 = 6;
	public static final int button7 = 7;
	public static final int button8 = 8;
	public static final int button9 = 9;
	public static final int button10 = 10;
	public static final int button11 = 11;
	public static final int button12 = 12;

	public static final double pDriveStraight = 0.035;
	public static final double iDriveStraight = 0.2;

//intake
	public static final int IntakeMotorPort = 0;
	public static final int IntakeActuationMotorPort = 1;

	public static final int IntakeUpperLimitSwitchPort = 4;
	public static final int IntakeLowerLimitSwitchPort = 5;

//shooter
	public static final int flywheelMotorPort = 10;
	// public static final int hoodMotorPort = 1;
	// public static final int hoodHomeLimitSwitchPort = 1;

	// public static final int [] hoodEncoderDIO = {4,5};

	public static final int shooterIntakeMotorPort = 3;
	public static final double shooterIntakeScalar = 0.75;


//scalars
	public static final double IntakeMotorSpeedScalar = 0.4;
	public static final double IntakeActuationMotorScalar = 0.4;
	public static final double hoodHomingSpeedScalar = 0.25;
	public static final double flywheelMotorSpeedScalar = 1;


	/**The value of IntakeActuationMotorScalar was chosen arbotrarily
	 and will likely need to be adjusted. **/
	


	public static final int XboxControllerPort = 1;

	public static final int LeftAxisX = 0;
	public static final int LeftAxisY = 1;
	public static final int RightAxisX = 4;
	public static final int RightAxisY = 5;

	public static final int TriggerLeft = 2;
	public static final int TriggerRight = 3;

	public static final int ButtonLeft = 5;
	public static final int ButtonRight = 6;

	public static final int ButtonA = 1;
	public static final int ButtonB = 2;
	public static final int ButtonX = 3;
	public static final int ButtonY = 4;

	public static final int ButtonBack = 7;
	public static final int ButtonMenu = 8;

	public static final int ButtonStickLeft = 9;
	public static final int ButtonStickRight = 10;

	public static final double kTrackWidthMeters = 0;
	public static final  DifferentialDriveKinematics kDriveKinematics =
	new DifferentialDriveKinematics(kTrackWidthMeters);
	public static final double flywheelSpeedScalar = 0;

	public static final int cenrifugeMotorPort = 2;
	public static final double centrifugeScalar = -0.25;

	public static final double IntakeExtendMotorScalar = 0.3;
	public static final double IntakeRetractMotorScalar = 0.5;

	public static final double pFlywheel = 2e-3;
	public static final double iFlywheel = 4e-4;
	public static final double dFlywheel = 4e-4;
	public static final double ffFlywheel = 4.81e-6;
	public static final double flyWheelRPM = 5000;
	public static final double izFlywheel = 0.000015;
	public static final double maxFlywheel = 1;
	public static final double minFlywheel = -1;

	public static final double targetHeight = 2.438;
	public static final double lenseHeight = 0.4445;
	//in radians
	public static final double lenseAngle = .4712;

	public static final double dTDProportional = .5;
	public static final double dTDIntegral = 0;
	
	public static final double greenZoneShootingDistance = 1.5; //meters
	public static final double yellowZoneShootingDistance = 2.5; //meters
	public static final double blueZoneShootingDistance = 4.1; //meters
	public static final double reintroductionZoneDistance = 7.1; //meters

	

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

	public final class ProjectileConstants{
		public static final double g = -9.81;
		public static final double y = 0;
		//height of camera
		public static final double yInitial = 0;
		public static final double tanTheta_d = 0;
		//cosine of shooter angle squared
		public static final double cosThetaSqrd = 0;

	}
}
