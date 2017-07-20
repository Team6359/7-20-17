package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.commands.MoveWithJoystick;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	public static SpeedController l1, l2, r1, r2;
	
	
	
	public DriveTrain(){
	
		l1 = new Victor(4);
		l2 = new Victor(3);
		r1 = new Victor(2);
		r2 = new Victor(1);
		
		r1.setInverted(true);
		r2.setInverted(true);
		
		
	
	
	
	
	}
	
	
	public void DriveArcade(double xAxis, double yAxis){
		
		double leftSpeed = yAxis + xAxis;
		double rightSpeed = yAxis - xAxis;
		
		Drive(leftSpeed, rightSpeed);
		
		
		
		
		
		
	}
	public void Drive(double leftSpeed, double rightSpeed){
		
		l1.set(leftSpeed);
		l2.set(leftSpeed);
		r1.set(rightSpeed);
		r2.set(rightSpeed);
		
		
		
		
	}
	
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		
		setDefaultCommand(new MoveWithJoystick());
		
		
		
		
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}