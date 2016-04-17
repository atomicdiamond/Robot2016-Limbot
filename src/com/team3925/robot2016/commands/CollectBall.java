package com.team3925.robot2016.commands;

import com.team3925.robot2016.Robot;
import com.team3925.robot2016.subsystems.Launcher;

import edu.wpi.first.wpilibj.command.Command;

public class CollectBall extends Command {
	
	private final Launcher launcher = Robot.launcherNew;
	
	public CollectBall() {
		super("CollectBall");
		
		requires(launcher);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		launcher.setArmSetpoint(0);
		launcher.setFlywheelFarSetpoint(1);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.oi.getCommandCancel();
	}

	// Called once after isFinished returns true
	protected void end() {
		launcher.setFlywheelFarSetpoint(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
