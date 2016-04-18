package com.team3925.robot2016.commands;

import com.team3925.robot2016.Robot;
import com.team3925.robot2016.subsystems.Launcher;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CollectBall extends Command {
	
	private final Launcher launcher = Robot.launcher;
	
	public CollectBall() {
		super("CollectBall");
		
		SmartDashboard.putNumber("Launcher_IntakeSpeedFar", -0.4);
		SmartDashboard.putNumber("Launcher_IntakeSpeedNear", 1);
		requires(launcher);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		launcher.setArmSetpoint(0);
		launcher.setPuncherSolenoid(false);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		launcher.setFlywheelFarSetpoint(SmartDashboard.getNumber("Launcher_IntakeSpeedFar"));
		launcher.setFlywheelNearSetpoint(SmartDashboard.getNumber("Launcher_IntakeSpeedNear"));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.oi.getCommandCancel();
	}

	// Called once after isFinished returns true
	protected void end() {
		launcher.setFlywheelFarSetpoint(0);
		launcher.setFlywheelNearSetpoint(0);
		launcher.setPuncherSolenoid(true);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
