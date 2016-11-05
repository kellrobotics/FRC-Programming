package org.usfirst.frc.team1311.robot.commands;

import org.usfirst.frc.team1311.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Turn extends Command {
	double angle, power;
    /**
     * Command to turn based on gyro reading.  This is very
     * basic and will overshoot.  Real world would need tweaking,
     * profiling and/or PID operation.  Robot will spin in place,
     * with +power on one drive, -power on the other.
     * @param angle  Angle in degrees to turn to
     * @param power  Power setting, range -1 to 1
     */
	public Turn(double angle, double power) {
        requires(Robot.drivetrain);    
// Define things so that negative angle will turn left,
// but we always absolute values for the angles.
        if ( angle < 0 ) {
        	 power = -power;
        }
        this.angle = angle;
        this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive(power, -power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.print("Angle: " + Robot.drivetrain.getAngle() + "\n");

        return Math.abs(angle) <= Math.abs(Robot.drivetrain.getAngle());
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
