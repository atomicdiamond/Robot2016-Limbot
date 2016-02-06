package com.team3925.robot2016;

import static com.team3925.robot2016.Constants.DRIVETRAIN_ENCODER_FACTOR;
import static com.team3925.robot2016.Constants.LAUNCHER_AIM_IZONE;
import static com.team3925.robot2016.Constants.LAUNCHER_AIM_KD;
import static com.team3925.robot2016.Constants.LAUNCHER_AIM_KF;
import static com.team3925.robot2016.Constants.LAUNCHER_AIM_KI;
import static com.team3925.robot2016.Constants.LAUNCHER_AIM_KP;
import static com.team3925.robot2016.Constants.LAUNCHER_AIM_PROFILE;
import static com.team3925.robot2016.Constants.LAUNCHER_AIM_RAMP_RATE;
import static com.team3925.robot2016.Constants.LAUNCHER_SHOOTER_IZONE;
import static com.team3925.robot2016.Constants.LAUNCHER_SHOOTER_KF;
import static com.team3925.robot2016.Constants.LAUNCHER_SHOOTER_KI;
import static com.team3925.robot2016.Constants.LAUNCHER_SHOOTER_KP;
import static com.team3925.robot2016.Constants.LAUNCHER_SHOOTER_PROFILE;
import static com.team3925.robot2016.Constants.LAUNCHER_SHOOTER_RAMP_RATE;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static Compressor compressor;
	
    public static SpeedController driveTrainMotorLeftA;
    public static SpeedController driveTrainMotorLeftB;
    public static SpeedController driveTrainMotorLeftC;
    public static SpeedController driveTrainMotorRightA;
    public static SpeedController driveTrainMotorRightB;
    public static SpeedController driveTrainMotorRightC;
    public static Encoder driveTrainEncoderLeft;
    public static Encoder driveTrainEncoderRight;
    public static DoubleSolenoid driveTrainShifterSolenoid;

    public static CANTalon launcherMotorAim;
    public static CANTalon launcherMotorLeft;
    public static CANTalon launcherMotorRight;
    public static DoubleSolenoid launcherPuncherSolenoid;
    
    public static PowerDistributionPanel pdp;

    public static void init() {
    	
//    	compressor = new Compressor();
//    	compressor.start();
    	
    	boolean invertLeft = true;
    	boolean invertRight = false;
    	
        driveTrainMotorLeftA = new Talon(3);
        LiveWindow.addActuator("DriveTrain", "MotorLeftA", (Talon) driveTrainMotorLeftA);
        driveTrainMotorLeftA.setInverted(invertLeft);
        
        driveTrainMotorLeftB = new Talon(4);
        LiveWindow.addActuator("DriveTrain", "MotorLeftB", (Talon) driveTrainMotorLeftB);
        driveTrainMotorLeftB.setInverted(invertLeft);
        
        driveTrainMotorLeftC = new Talon(5);
        LiveWindow.addActuator("DriveTrain", "MotorLeftC", (Talon) driveTrainMotorLeftC);
        driveTrainMotorLeftC.setInverted(invertLeft);
        
        driveTrainMotorRightA = new Talon(0);
        LiveWindow.addActuator("DriveTrain", "MotorRightA", (Talon) driveTrainMotorRightA);
        driveTrainMotorRightA.setInverted(invertRight);
        
        driveTrainMotorRightB = new Talon(1);
        LiveWindow.addActuator("DriveTrain", "MotorRightB", (Talon) driveTrainMotorRightB);
        driveTrainMotorRightB.setInverted(invertRight);
        
        driveTrainMotorRightC = new Talon(2);
        LiveWindow.addActuator("DriveTrain", "MotorRightC", (Talon) driveTrainMotorRightC);
        driveTrainMotorRightB.setInverted(invertRight);
        
        driveTrainEncoderLeft = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "EncoderLeft", driveTrainEncoderLeft);
        driveTrainEncoderLeft.setDistancePerPulse(DRIVETRAIN_ENCODER_FACTOR);
        driveTrainEncoderLeft.setPIDSourceType(PIDSourceType.kRate);
        
        driveTrainEncoderRight = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "EncoderRight", driveTrainEncoderRight);
        driveTrainEncoderRight.setDistancePerPulse(DRIVETRAIN_ENCODER_FACTOR);
        driveTrainEncoderRight.setPIDSourceType(PIDSourceType.kRate);
        
        driveTrainShifterSolenoid = new DoubleSolenoid(0, 1);
        LiveWindow.addActuator("DriveTrain", "ShifterSolenoid", driveTrainShifterSolenoid);
        
        
        
        launcherPuncherSolenoid = new DoubleSolenoid(3, 2);
        LiveWindow.addActuator("Launcher", "PuncherSolenoid", launcherPuncherSolenoid);
        
        
        launcherMotorAim = new CANTalon(2);
        LiveWindow.addActuator("Launcher", "AimMotor", launcherMotorAim);
        launcherMotorAim.setFeedbackDevice(FeedbackDevice.PulseWidth);
        launcherMotorAim.changeControlMode(TalonControlMode.Position);
        launcherMotorAim.enableBrakeMode(true);
        launcherMotorAim.setPIDSourceType(PIDSourceType.kDisplacement);
        launcherMotorAim.setPID(LAUNCHER_AIM_KP, LAUNCHER_AIM_KI, LAUNCHER_AIM_KD,
        		LAUNCHER_AIM_KF, LAUNCHER_AIM_IZONE, LAUNCHER_AIM_RAMP_RATE, LAUNCHER_AIM_PROFILE);
        
        
        launcherMotorLeft = new CANTalon(0);
        LiveWindow.addActuator("Launcher", "MotorLeft", launcherMotorLeft);
        launcherMotorLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        launcherMotorLeft.changeControlMode(TalonControlMode.Speed); //TODO check if we want to use speed
        launcherMotorLeft.setPIDSourceType(PIDSourceType.kRate);
        launcherMotorLeft.setPID(LAUNCHER_SHOOTER_KP, LAUNCHER_SHOOTER_KI, LAUNCHER_AIM_KD,
        		LAUNCHER_SHOOTER_KF, LAUNCHER_SHOOTER_IZONE, LAUNCHER_SHOOTER_RAMP_RATE, LAUNCHER_SHOOTER_PROFILE);
        
        launcherMotorRight = new CANTalon(1);
        LiveWindow.addActuator("Launcher", "MotorRight", launcherMotorRight);
        launcherMotorRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        launcherMotorRight.changeControlMode(TalonControlMode.Follower);
        launcherMotorRight.set(launcherMotorLeft.getDeviceID());
        launcherMotorRight.reverseOutput(true);
//        launcherMotorRight.setPIDSourceType(launcherMotorLeft.getPIDSourceType());
//        launcherMotorRight.setPID(LAUNCHER_SHOOTER_KP, LAUNCHER_SHOOTER_KI, LAUNCHER_AIM_KD,
//        		LAUNCHER_SHOOTER_KF, LAUNCHER_SHOOTER_IZONE, LAUNCHER_SHOOTER_RAMP_RATE, LAUNCHER_SHOOTER_PROFILE);
        
    }
}
