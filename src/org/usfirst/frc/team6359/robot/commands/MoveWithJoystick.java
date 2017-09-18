package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6359.robot.OI;
import org.usfirst.frc.team6359.robot.Robot;

/**
 *
 */
public class MoveWithJoystick extends Command {
	public MoveWithJoystick() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		/* up: right bumper boolean
		 * down: left bumper boolean
		 * xIn: left joystick x input
		 * yIn: left joystick y input
		 * rX: right joystick x input
		 * rY: right Joystick y input
		 */
		
		boolean up, down;
		double lX, lY, rX, rY;
		
		//left joystick values
		lX = OI.driveStick.getRawAxis(0);
		lY = OI.driveStick.getRawAxis(1);
		//right joystick values
		rX = OI.driveStick.getRawAxis(4);
		rY = OI.driveStick.getRawAxis(5);
		
		//bumper inputs for gear changes
		up = OI.driveStick.getRawButton(6);
		down = OI.driveStick.getRawButton(5);
		
		//sends joystick and bumper inputs to driveTrain subsystem
		Robot.driveTrain.DriveArcade(lX, lY);
		Robot.driveTrain.gear(up, down);
		
		//sets controller rumble when gears are changed
		Robot.dsOutput.rumble(up, down, 1);
		
	 }

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
