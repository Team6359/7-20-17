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
		
		Implement.Intake(OI.driveStick.getRawButton(6));
		//right bumper
		Implement.Climber(OI.driveStick.getRawAxis(2), OI.driveStick.getRawButton(4));
		//up: left trigger, down: y button
		Implement.Shooter(OI.driveStick.getRawAxis(3));
		//right trigger
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
