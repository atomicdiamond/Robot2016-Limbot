package com.team3925.robot2016.commands;

import com.team3925.robot2016.Robot;
import static com.team3925.robot2016.Constants.DO_MANUAL_CLIMBER;

import com.team3925.robot2016.OI;
import com.team3925.robot2016.subsystems.Climber;
import com.team3925.robot2016.util.SmartdashBoardLoggable;
import com.team3925.robot2016.util.hidhelpers.XboxHelper;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Controls the candy cane arms on the robot for
 * lifting up at end of match
 */
public class Climb extends Command implements SmartdashBoardLoggable {
	
	private final Climber climber = Robot.candyCanes;
	
	public Climb () {
		requires(climber);
	}
	
	@Override
	protected void initialize() {
		climber.setClimbMotor(0);
	}
	
	@Override
	protected void execute() {
		climber.setClimberSolenoid(true);
		
		if (DO_MANUAL_CLIMBER) {
			
			climber.setClimbMotor(Robot.oi.getCandyCanes_Set());
			
		} else {
			// routine goes here
		}
	}
	
	@Override
	protected void end() {
		climber.setClimbMotor(0);
	}
	
	@Override
	protected void interrupted() {
		climber.setClimbMotor(0);
	}
	
	@Override
	protected boolean isFinished() { return false; }

	@Override
	public void logData() {
	}

	@Override
	public String getFormattedName() {
		return "Climber_";
	}
	
}
