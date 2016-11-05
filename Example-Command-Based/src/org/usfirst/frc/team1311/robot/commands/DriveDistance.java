package org.usfirst.frc.team1311.robot.commands;

import org.usfirst.frc.team1311.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command {
	double distance, power;
    /**
     * Command to drive a distance measured by encoders
     *
     * @param distance  Distance to drive, based on encoder settings
     * @param power  Power to use, range -1 to 1
     */
    public DriveDistance(double distance, double power) {
        requires(Robot.drivetrain);
    // Define things so that negative power or distance will move in reverse,
    // but we always absolute values for the distances.
        if ( distance < 0 ) {
        	 power = -power;
        }
        this.distance = distance;
        this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive(power, power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(distance) <= Math.abs(Robot.drivetrain.getDistance());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
