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
		
		requires(Robot.driveTrain);
	}

	
	@Override
	protected void initialize() {
	}

	
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
		up = OI.driveStick.getRawButton(10);
		down = OI.driveStick.getRawButton(9);
		
		//sends joystick and bumper inputs to driveTrain subsystem
		Robot.driveTrain.DriveArcade(rX, lY);
		Robot.driveTrain.gear(up, down);
		
		//runs gyro subsystem
		Robot.driveTrain.gyro(false);
		//prints gyro output
		System.out.println(Robot.driveTrain.gyro(false));
				
		//sets controller rumble when gears are changed
		Robot.dsOutput.rumble(up, down, 1);
		
	 }

	
	@Override
	protected boolean isFinished() {
		return false;
	}


	@Override
	protected void end() {
	}

	
	@Override
	protected void interrupted() {
	}
}
