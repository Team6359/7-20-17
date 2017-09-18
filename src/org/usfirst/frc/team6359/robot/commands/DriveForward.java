package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.OI;
import org.usfirst.frc.team6359.robot.Robot;
import org.usfirst.frc.team6359.robot.subsystems.Implement;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command{
	private double _distance;
	private double _count;
	public DriveForward(double Distance){
		requires(Robot.driveTrain);
		_distance = Distance;
		_count = 0;
	}

	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if(_count < _distance){
			
			
			Robot.driveTrain.Drive(.1, .1);
			_count ++;
		}
		else{
			Robot.driveTrain.Drive(0, 0);
		}
		
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
