package com.team3925.robot2016;

/**
 *	A class holding all the constants of the project
 */
public class Constants {
	private Constants() {};
	
	// Loop time of the program
	public static final double DELTA_TIME = 0.020; // 20 ms
	
	public static enum AutoStartPos {
		COURTYARD, CENTER, DO_NOTHING;
	}

	public static final AutoStartPos AUTO_START_LOCATION = AutoStartPos.CENTER;
	public static final boolean DO_LOG_AHRS_VALUES = true;
	public static final boolean DO_LOG_PDP_VALUES = false;

	public static final double XBOX_AXIS_TOLERANCE = 0.1;

	public static final double GLOBAL_MAX_SHOOTER_PWR = 1;
	public static final double LAUNCHER_AIM_MOTOR_SPEED_MULTIPLIED = 0.6;
	
	public static final double MAX_ACCEL_M_SEC2 = 0.923;
	public static final double MAX_VEL_M_SEC = 1.973;
	
	
	// MECHANICAL CONSTANTS
	public static final double WHEEL_DIAMETER = 6.0; // inches (inflated)
	
	
	
//	DRIVETRAIN CONSTANTS
	public static final double GLOBAL_MAX_DRIVE_TRAIN_PWR = 1;
	
//	Straight Gyro Drive PID Constants
	//TODO: tune gyro straight drive pid
	public static final double GYRO_DRIVE_KP = 1;
	public static final double GYRO_DRIVE_KI = 0;
	public static final double GYRO_DRIVE_KD = 0;
	
//	Launcher PID Constants
	//TODO: tune shooter pid
	public static final double LAUNCHER_AIM_KP = 1;
	public static final double LAUNCHER_AIM_KI = 0;
	public static final double LAUNCHER_AIM_KD = 0;
	public static final double LAUNCHER_AIM_KF = 0;
	public static final double LAUNCHER_AIM_RAMP_RATE = 1;//ramp rate is maximum acceleration in voltage/second
	public static final int LAUNCHER_AIM_IZONE = 0; // izone eliminates
	public static final int LAUNCHER_AIM_PROFILE = 0;
	
	public static final double LAUNCHER_WHEELS_KP = 1;
	public static final double LAUNCHER_WHEELS_KI = 0;
	public static final double LAUNCHER_WHEELS_KD = 0;
	public static final double LAUNCHER_WHEELS_KF = 0;
	public static final double LAUNCHER_WHEELS_RAMP_RATE = 1;//ramp rate is maximum acceleration in voltage/second
	public static final int LAUNCHER_WHEELS_IZONE = 0; // izone eliminates
	public static final int LAUNCHER_WHEELS_PROFILE = 0;
	
	public static final double MAX_LAUNCHER_HEIGHT = 700;
	
	
	
//	Drivetrain PID Constants
	// DRIVETRAIN CONSTANTS
	
	private static final int DRIVETRAIN_ENCODER_TICKS = 128 * 4;
	public static final double DRIVETRAIN_ENCODER_FACTOR = Math.PI * WHEEL_DIAMETER / DRIVETRAIN_ENCODER_TICKS * (97d/77d);
	private static final double MAX_VALUE_MULTIPLIER = 0.8;
	
	public static final double MAX_DRIVETRAIN_VEL_M_PER_SEC = 2.6 * MAX_VALUE_MULTIPLIER;
	public static final double MAX_DRIVETRAIN_ACCEL_M_PER_SEC2 = 2.5 * MAX_VALUE_MULTIPLIER;
	public static final double MAX_ROTATION_VELOCITY_RADS_PER_SEC = 6.3 * MAX_VALUE_MULTIPLIER;
	public static final double MAX_ROTATION_ACCEL_RADS_PER_SEC2 = 570 * MAX_VALUE_MULTIPLIER;
	
    public static double kDriveMaxSpeedInchesPerSec = 82;
    public static double kDriveMaxAccelInchesPerSec2 = 79;
	
    // Left PID constants
	public static final double DRIVETRAIN_LEFT_KP = .35;
	public static final double DRIVETRAIN_LEFT_KI = .005;
	public static final double DRIVETRAIN_LEFT_KD = 0;
	
	// Right PID Constants
	public static final double DRIVETRAIN_RIGHT_KP = .35;
	public static final double DRIVETRAIN_RIGHT_KI = 0.005;
	public static final double DRIVETRAIN_RIGHT_KD = 0;
    
    public static final double DRIVETRAIN_ON_TARGET_ERROR = .05;
	
}
