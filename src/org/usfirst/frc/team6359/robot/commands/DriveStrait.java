package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStrait extends Command {

private double _distance, spd;
private boolean finish;
	
	private double cpi;
	public DriveStrait(double Distance, double speed){
		requires(Robot.driveTrain);
		
		cpi = 18380 / 83.5;
		_distance = Distance * cpi;
		spd = speed;
		}
	 
		
	@Override
	protected void initialize() {
		//reset encoders
		Robot.driveTrain.rightEncoder(true);
		Robot.driveTrain.leftEncoder(true);
		//put it in high gear
		Robot.driveTrain.gear(true , false);
		//make the command not finish
		finish = false;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		double lEncoder = Robot.driveTrain.leftEncoder(false);
		double rEncoder = Robot.driveTrain.rightEncoder(false);
		
		//proportional controller
		double turn = lEncoder - rEncoder;
		turn = turn * 0.005;
		
		//total distance
		double _count = Robot.driveTrain.rightEncoder(false);
		
	//run when the distance is negative so it goes backwards
	if(_distance < 0){	
		//drive until the encoder matches the distance
		if(_count > _distance){
			Robot.driveTrain.Drive(spd, spd + turn);
		}
		//stop when past the distance
		else{
			Robot.driveTrain.Drive(0, 0);	
			finish = true;
		}
	}
	
	
	//run when the distance is positive so it goes forward
	if(_distance > 0){
		//drive until the encoder matches the distance
		if(_count < _distance){
			Robot.driveTrain.Drive(-0.25, -0.25 + turn);
		}
		//stop when past the distance
		else{
			Robot.driveTrain.Drive(0, 0);
			finish = true;
		}
	}
	
	
	}

	
	@Override
	protected boolean isFinished() {
		//finish the command
		return finish;
	}

}
