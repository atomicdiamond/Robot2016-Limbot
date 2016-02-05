package com.team3925.robot2016.commands;

import com.team3925.robot2016.Robot;
import com.team3925.robot2016.subsystems.DriveTrain;
import com.team3925.robot2016.util.DriveTrainSignal;

import edu.wpi.first.wpilibj.command.Command;


public class TurnInPlace extends Command {
	private final DriveTrain driveTrain = Robot.driveTrain;
	
    public TurnInPlace(double heading) {
        requires(Robot.driveTrain);
        driveTrain.setTurnSetPoint(heading);
    }
    
    public TurnInPlace(double heading, double maxVel) {
    	requires(Robot.driveTrain);
    	driveTrain.setTurnSetPoint(heading, maxVel);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.update();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return driveTrain.controllerOnTarget() || driveTrain.getController() == null;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.setOpenLoopSpeeds(DriveTrainSignal.NEUTRAL);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	driveTrain.setOpenLoopSpeeds(DriveTrainSignal.NEUTRAL);
    }
}
