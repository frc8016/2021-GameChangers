// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.DriveStraight;
import frc.robot.commands.DriveToDistance;
import frc.robot.commands.ManualShooterSpeed;
import frc.robot.commands.RunShooterIntake;
import frc.robot.commands.StopCentrifuge;
import frc.robot.commands.StopShooter;
import frc.robot.commands.StopShooterIntake;
import frc.robot.commands.spinCentrifuge;
import frc.robot.commands.ExtendIntake;
import frc.robot.commands.RetractIntake;

// import frc.robot.commands.UnjamIntake;
// import frc.robot.commands.exampleRamseteCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.ShooterIntake;
import frc.robot.subsystems.centrifuge;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
 
  //Subsystem
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final Intake m_Intake = new Intake();
  private final Shooter m_Shooter = new Shooter();
  private final ShooterIntake m_ShooterIntake = new ShooterIntake();
  private final centrifuge m_Centrifuge = new centrifuge();

  
  //Command

  private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_driveTrain);
  private final ExtendIntake m_ExtendIntake = new ExtendIntake(m_Intake);
  private final RetractIntake m_RetractIntake = new RetractIntake(m_Intake);
  // private final UnjamIntake m_UnjamIntake = new UnjamIntake(m_Intake);
  // private final exampleRamseteCommand m_ExampleRamseteCommand = new exampleRamseteCommand(m_driveTrain);
  private final DriveToDistance m_DriveToDistance = new DriveToDistance(m_driveTrain);
  private final DriveStraight m_DriveStraight = new DriveStraight(m_driveTrain);
  private final ManualShooterSpeed m_ManualShooterSpeed = new ManualShooterSpeed(m_Shooter);
  private final RunShooterIntake m_RunShooterIntake = new RunShooterIntake(m_ShooterIntake);
  private final StopShooterIntake m_StopShooterIntake = new StopShooterIntake(m_ShooterIntake);
  private final StopShooter m_StopShooter = new StopShooter(m_Shooter);
  private final spinCentrifuge m_SpinCentrifuge = new spinCentrifuge(m_Centrifuge);
  private final StopCentrifuge m_StopCentrifuge = new StopCentrifuge(m_Centrifuge);


  //IO
  private final Joystick driverController = new Joystick(Constants.joystickPort);
  private final XboxController operatorController = new XboxController(Constants.XboxControllerPort);
  private final JoystickButton XboxA = new JoystickButton(operatorController, Constants.ButtonA);
  private final JoystickButton XboxB = new JoystickButton(operatorController, Constants.ButtonB);
  private final JoystickButton XboxY = new JoystickButton(operatorController, Constants.ButtonY);
  private final JoystickButton Joy3 = new JoystickButton(driverController, Constants.button3);
  private final JoystickButton Joy4 = new JoystickButton(driverController, Constants.button4);
  private final JoystickButton Joy5 = new JoystickButton(driverController, Constants.button5);
  private final JoystickButton Joy6 = new JoystickButton(driverController, Constants.button6);
  private final JoystickButton Joy7 = new JoystickButton(driverController, Constants.button7);
  private final JoystickButton Joy8 = new JoystickButton(driverController, Constants.button8);
  private final JoystickButton Joy1 = new JoystickButton(driverController, Constants.button1);
  private final JoystickButton Joy9 = new JoystickButton(driverController, Constants.button9);
  private final JoystickButton Joy10 = new JoystickButton(driverController, Constants.button10);
  private final JoystickButton Joy2 = new JoystickButton(driverController, Constants.button2);

  

  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_driveTrain.setDefaultCommand(m_arcadeDrive);
    // m_Intake.setDefaultCommand(m_RetractIntake);
    m_Shooter.setDefaultCommand(m_StopShooter);
    m_ShooterIntake.setDefaultCommand(m_StopShooterIntake);
  }


  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //these definitely work

    // XboxA.whenPressed(m_ExtendIntake);
    // XboxB.whenPressed(m_RetractIntake);
    // XboxY.whenPressed(m_UnjamIntake);
    Joy7.whenPressed(m_DriveStraight);
    Joy8.whenPressed(m_arcadeDrive);
    Joy9.whenPressed(m_StopShooter);
    Joy10.whenPressed(m_ManualShooterSpeed);
    Joy1.whenHeld(m_RunShooterIntake);
    Joy1.whenReleased(m_StopShooterIntake);
    Joy4.whenPressed(m_SpinCentrifuge);
    Joy6.whenPressed(m_StopCentrifuge);
    Joy3.whenPressed(m_ExtendIntake);
    Joy5.whenPressed(m_RetractIntake);
    Joy2.whenHeld(m_DriveToDistance);
    Joy2.whenReleased(m_arcadeDrive);

    //These may work. Keep as comments until tested.
    // XboxA.toggleWhenPressed(m_ExtendIntake, true);
    // XboxB.toggleWhenPressed(m_RetractIntake, true);
    // XboxY.toggleWhenPressed(m_UnjamIntake, true);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {


    return null;
    
  }
}
