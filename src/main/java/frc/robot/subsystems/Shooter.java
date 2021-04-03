// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj.DigitalInput;
// import edu.wpi.first.wpilibj.Spark;
// import frc.robot.Constants;
// import edu.wpi.first.wpilibj.Encoder; // may not be the correct encoder import



// public class Shooter extends SubsystemBase {
//   /** Creates a new Shooter. */
//   private final Spark flywheelMotor = new Spark(Constants.flywheelMotorPort);

//   private final Spark hoodMotor = new Spark(Constants.hoodMotorPort);

//   private final DigitalInput hoodHomeLimitSwitch = new DigitalInput(Constants.hoodHomeLimitSwitchPort);

//   private final Encoder hoodEncoder = new Encoder(Constants.hoodEncoderDIO[0],Constants.hoodEncoderDIO[1]);




//   //use these methods to control the flywheel
//   public void runFlywheelMotorForward() {
//     flywheelMotor.set(Constants.flywheelMotorSpeedScalar);
//   }

//   public void runFlywheelMotorOff() {
//     flywheelMotor.set(0);
//   }

//   public void homeHood() {
//     if (hoodHomeLimitSwitch.get()) {
//       hoodMotor.set(0);
//       hoodEncoder.reset();
//     }
//     else {
//       hoodMotor.set(Constants.hoodHomingSpeedScalar);
//     }

//   }


//   public Shooter() {}

//   @Override
//   public void periodic() {
//     // This method will be called once per scheduler run
//   }
// }
