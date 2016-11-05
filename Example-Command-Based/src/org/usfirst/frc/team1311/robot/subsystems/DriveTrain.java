package org.usfirst.frc.team1311.robot.subsystems;

import org.usfirst.frc.team1311.robot.RobotMap;
import org.usfirst.frc.team1311.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

//**

public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Victor leftDrive, rightDrive;
	Encoder leftEncode, rightEncode;
	AnalogGyro gyro;

	/**
     * Subsystem for controlling drive motors, reading encoders and gyro.
     */		
	public DriveTrain() {
    	leftDrive = new Victor(RobotMap.leftDrivePort);
    	rightDrive = new Victor(RobotMap.rightDrivePort);
    	//Drive Encoders 
    	leftEncode = new Encoder(RobotMap.leftEncodePortA, RobotMap.leftEncodePortB);
    	rightEncode = new Encoder(RobotMap.rightEncodePortA, RobotMap.rightEncodePortB);
    	// Set to read in inches
    	leftEncode.setDistancePerPulse(RobotMap.inchesPerPulse);
       	rightEncode.setDistancePerPulse(RobotMap.inchesPerPulse);
       	
       	gyro = new AnalogGyro(RobotMap.gyroPort);
       	gyro.initGyro();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoysticks());
    }
    
	/**
     * Drive two motors with individual power settings.
     * Range of each is -1 to 1.
     * Sign is corrected so that + is forward in both cases.
     * @param leftside  Left power setting
     * @param rightside  Right power setting
     */		
    public void drive(double leftside, double rightside) {
		leftDrive.set(leftside);   		
		rightDrive.set(-rightside);    		  	
    }
	/**
     * Drive two motors using specified joysticks
     * @param joyleft  Left joystick
     * @param joyright  Right Joystick
     */
	public void driveJoy(Joystick joyleft, Joystick joyright) {
    	//normal drive
    	double leftside, rightside;
    	leftside = joyleft.getY();
    	rightside = joyright.getY();
    	if (Math.abs(leftside) > .2) {    		
    		leftDrive.set(-leftside);   		
    	}
    	else {    		
    		leftDrive.set(0);    		
    	}
    	if (Math.abs(rightside)> .2) {    		
    		rightDrive.set(rightside);    		
    	}
    	else {   		
    		rightDrive.set(0);    		
    	}
    }

	/**
	 * Gets the angle relative to last reset.
	 * @return angle in degrees.
	 */
	public double getAngle() {
		return gyro.getAngle();
	}

	/**
	 * Gets the drive encoder distance relative to last reset, using the average of the two sides.
	 * @return distance
	 */
	public double getDistance() {
		return (leftEncode.getDistance() + rightEncode.getDistance())/2;
	}

	/**
	 * Reset gyro and drive train encoders
	 */
	public void reset() {
		gyro.reset();
		leftEncode.reset();
		rightEncode.reset();
	}

}

