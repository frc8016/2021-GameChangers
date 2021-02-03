// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ExtendIntake;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
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
  //Command
  private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_driveTrain);
  private final ExtendIntake m_ExtendIntake = new ExtendIntake(m_Intake);
  

  //IO
  private final XboxController operatorController = new XboxController(Constants.XboxControllerPort);
  private final JoystickButton XboxA = new JoystickButton(operatorController, Constants.ButtonA);
  private final JoystickButton XboxB = new JoystickButton(operatorController, Constants.ButtonB);


  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_driveTrain.setDefaultCommand(m_arcadeDrive);
  }


  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    XboxA.whenPressed(m_ExtendIntake);
    XboxB.whenPressed(m_RetractIntake);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
