
package org.usfirst.frc.team1311.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1311.robot.commands.AutoMode;
import org.usfirst.frc.team1311.robot.subsystems.DriveTrain;

/**
 * Project Example-Command-Based
 * by Gary Lewis, Mentor, Kell Robotics, team 1311
 * 
 * Short (yes, really) demonstration of a Command-Based program.
 * Note that the simple tank drive with two joysticks and two motors
 * from the Iterative example program is now defined as the default
 * command in the DriveTrain subsystem, and so will run during teleop
 * without being explicitly called in this file.
 * 
 * Implements the following (in other files):
 * 	RobotMap.java contains ports, constants, etc. in one place.
 *  OI.java contains all operator interface items (only the joysticks, in this case)
 *  A single subsystem, DriveTrain, which is the only interface to the drive motors,
 *    encoders, and gyro.
 *  Three commands:
 *    DriveDistance
 *    DriveWithJoysticks
 *    Turn.java
 *  One command chain, which is called during autonomous mode:
 *    AutoMode
 */
public class Robot extends IterativeRobot {

    public static DriveTrain drivetrain;
	public static OI oi;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        drivetrain = new DriveTrain();
       // instantiate the command used for the autonomous period
        autonomousCommand = new AutoMode();
		
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
         if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
