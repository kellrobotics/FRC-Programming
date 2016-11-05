package org.usfirst.frc.team1311.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * File also contains other numeric constants or defaults that may need to be tweaked.
 */
public class RobotMap {
/**
* Port numbers
*/
	public static int leftStickPort = 0;
	public static int rightStickPort = 1;

	public static int leftDrivePort = 1;
	public static int rightDrivePort = 0;
	
	public static int leftEncodePortA = 8;
	public static int leftEncodePortB = 9;
	public static int rightEncodePortA = 7;
	public static int rightEncodePortB = 6;
	
	// Note that gyro can only be connected to analog port 0 or 1 due to need for
	// for hardware accumulator
	public static int gyroPort = 0;

/**
* Other constants and numbers
*/

	// Distance per pulse for drive encoders
	
	public static double inchesPerPulse = 0.0291;
		
}
