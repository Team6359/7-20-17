package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.OI;
import org.usfirst.frc.team6359.robot.Robot;
import org.usfirst.frc.team6359.robot.subsystems.Implement;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command{
	private double _distance;
	
	private double cpi;
	public DriveForward(double Distance){
		requires(Robot.driveTrain);
		
		cpi = 18380 / 83.5;
		_distance = Distance * cpi * -1;
		
		}
	 
		
	@Override
	protected void initialize() {
		Robot.driveTrain.rightEncoder(true);
		Robot.driveTrain.leftEncoder(true);
		Robot.driveTrain.gear(true , false);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		double lEncoder = Robot.driveTrain.leftEncoder(false);
		double rEncoder = Robot.driveTrain.rightEncoder(false);
		double turn = lEncoder - rEncoder;
		turn = turn * 0.005;
		
		double _count = Robot.driveTrain.rightEncoder(false);
	
	if(_count > _distance){
			Robot.driveTrain.Drive(0.25, .25 + turn);
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
