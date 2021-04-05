// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterIntake;

public class StopShooterIntake extends CommandBase {
  ShooterIntake m_shooterIntake;
  /** Creates a new StopShooterIntake. */
  public StopShooterIntake(ShooterIntake shooterIntake) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shooterIntake = shooterIntake;
    addRequirements(m_shooterIntake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooterIntake.stopShooterIntake();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
