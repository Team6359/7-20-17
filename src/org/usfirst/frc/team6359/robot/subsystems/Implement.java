package org.usfirst.frc.team6359.robot.subsystems;

import org.usfirst.frc.team6359.robot.commands.MoveWithJoystick;
import org.usfirst.frc.team6359.robot.commands.UseImplement;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Implement extends Subsystem {
	
	public static SpeedController intake, climber, shooter;

	
	public Implement(){
		
		intake = new Victor(5);
		climber = new Victor(6);
		shooter = new Victor(8);
		
		intake.setInverted(true);
		climber.setInverted(true);
		shooter.setInverted(true);
		
	}
	
	public static void Intake(boolean Button2){
	
		if(Button2){
			intake.set(1);
			
		}
		else{
			intake.set(0);
		}
		
	}
	
	public static void Climber(double leftTrigger,boolean Button4){
		
		if(leftTrigger > 0){
			climber.set(leftTrigger);
		}
		else if(Button4){
			climber.set(-1);
		}
		else{
			climber.set(0);
		}
	}
			
	public static void Shooter(double Throttle){
		
		shooter.set(Throttle);
		
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
			
			setDefaultCommand(new UseImplement());
	}


}
