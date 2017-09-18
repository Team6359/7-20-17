package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.OI;
import org.usfirst.frc.team6359.robot.Robot;
import org.usfirst.frc.team6359.robot.subsystems.Implement;

import edu.wpi.first.wpilibj.command.Command;

public class UseImplement extends Command {
	
	public UseImplement(){
		requires(Robot.implement);
	}
	
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		Implement.Intake(OI.driveStick.getRawButton(1));
		
		Implement.Climber(OI.driveStick.getRawButton(3), OI.driveStick.getRawButton(4));
		
		Implement.Shooter(OI.driveStick.getThrottle());
		
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
