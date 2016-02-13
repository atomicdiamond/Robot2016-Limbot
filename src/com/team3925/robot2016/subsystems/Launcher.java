package com.team3925.robot2016.subsystems;

import static com.team3925.robot2016.Constants.LAUNCHER_AIM_MOTOR_SPEED_MULTIPLIED;

import com.team3925.robot2016.Constants;
import com.team3925.robot2016.RobotMap;
import com.team3925.robot2016.util.SmartdashBoardLoggable;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.hal.CanTalonJNI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Launcher extends Subsystem implements SmartdashBoardLoggable {

    private final CANTalon motorLeft = RobotMap.launcherMotorLeft;
    private final CANTalon motorRight = RobotMap.launcherMotorRight;
    private final CANTalon motorAim = RobotMap.launcherMotorAim;
    private final DoubleSolenoid puncherSolenoid = RobotMap.launcherPuncherSolenoid;
//    Sensor for ball goes here
    
    private boolean hasBall = false;
    
    /**
     * @param speed
     */
    public void setIntakeSpeeds(double speed) {
    	motorLeft.set(speed);
    	motorRight.set(speed);
    }
    
    public void changeAimControlMode(TalonControlMode mode) {
    	motorAim.changeControlMode(mode);
    }
    
    public void setAimProfile(int profile) {
    	profile = Math.min(1, Math.max(0, profile));
    	motorAim.setProfile(profile);
    }
    
    public void setAimPID(double p, double i, double d, double f, int izone, double closeLoopRampRate, int profile) {
    	profile = Math.min(1, Math.max(0, profile));
    	motorAim.setPID(p, i, d, f, izone, closeLoopRampRate, profile);
    }
    
    public void setAim(double output) {
    	motorAim.set(output);
    }
    
    public void setAimMotorSpeed(double speed) {
    	setAimMotorSpeed(speed, true);
    }
    
    public void setAimMotorSpeed(double speed, boolean doLimits) {
    	if (doLimits) {
	    	if (getAimMotorPosition() <= 10)
	    		speed = Math.max(speed, 0);
	    	if (getAimMotorPosition() >= (Constants.LAUNCHER_MAX_HEIGHT+10))
	    		speed = Math.min(speed, 0);
    	}
    	
    	SmartDashboard.putNumber("Launcher_Aim_Speed_Is_Broke?_Test", speed);
    	
    	motorAim.set(speed * LAUNCHER_AIM_MOTOR_SPEED_MULTIPLIED);
    }
    
    public void update() {
    	hasBall = false; //TODO add sensor for ball
    }
    
    public boolean hasBall() {
    	return hasBall;
    }
    
    public double getAimMotorPosition() {
    	return -motorAim.getEncPosition();
    }
    
    public void setPuncher(boolean isHigh) {
    	puncherSolenoid.set(isHigh ? Value.kForward:Value.kReverse);
    }
    
    @Override
    public void logData() {
//    	putNumberSD("MotorLeft", motorLeft.get());
//    	putNumberSD("MotorRight", motorRight.get());
    	putNumberSD("AimMotorSpeed", motorAim.getSpeed());
    	putNumberSD("MotorAimPosition", getAimMotorPosition());
    	putStringSD("MotorAimMode", motorAim.getControlMode().toString());
    }
    
    @Override
    public String getFormattedName() {
    	return "Launcher_";
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

