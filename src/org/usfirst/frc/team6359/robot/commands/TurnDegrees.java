package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnDegrees extends Command {
	private boolean finish;
	private double degs, count, spd;
	private String dir;
	public TurnDegrees(double degrees, double speed, String direction){
		requires(Robot.driveTrain);
		
		spd = speed;
		dir = direction;
		//what to do when turning left
		if(dir == "l"){
			degs = degrees * -1;
		}
		// what to do when turning right
		else{
			degs = degrees;
		}
		}

	protected void initialize() {
		//reset gyro
		Robot.driveTrain.gyro(true);
		//sets it to low gear
		Robot.driveTrain.gear(false, true);
		//makes the command not finish
		finish = false;
		}
	
	public void execute(){
		
		count = Robot.driveTrain.gyro(false);
			
		//when to turn right
		if (dir == "r"){
			//how and how long to turn
			if(degs > count){
				Robot.driveTrain.Drive(spd, -spd);
			}
			//when to stop
			else{
				Robot.driveTrain.Drive(0, 0);
				//finish the command
				finish = true;
			}
		}
		else{
			//how and how long to turn
			if(degs < count){
			Robot.driveTrain.Drive(-spd, spd);
			}
			//when to stop
			else{
				Robot.driveTrain.Drive(0, 0);
				//finish the command
				finish = true;
			}
		}
		
		System.out.println(count);
		
	}
	
	@Override
	protected boolean isFinished() {
		
		//finish the command
		return finish;
	}

}
