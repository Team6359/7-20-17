package org.usfirst.frc.team6359.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DSOutput extends Subsystem{

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void rumble(Boolean right, Boolean left, double amplitude){
		
		RumbleType rightSide, leftSide;
		rightSide = GenericHID.RumbleType.kRightRumble;
		leftSide = GenericHID.RumbleType.kLeftRumble;		
		
		if(right){
			OI.driveStick.setRumble(rightSide, amplitude);
			}
		else{
			OI.driveStick.setRumble(rightSide, 0);
		}
		
		if(left){
			OI.driveStick.setRumble(leftSide, amplitude);
		}
		else{
		OI.driveStick.setRumble(leftSide, 0);
		}	
		
	}
	
	public void gear(int gear, double gearVal, String gearNumber){
		
		SmartDashboard.putString(null, gearNumber);
		
		/*System.out.println("gearVal: " + gearVal);
		System.out.println("gearNumber: " + gearNumber);
		System.out.println("gear: " + gear);
		*/
	}
	
	public  void drive(double x, double y, double speedLimit, double leftSpeed, double rightSpeed, double speed){
		//System.out.println(x);
		//System.out.println(y);
		//System.out.println(speedLimit);
		//System.out.println(leftSpeed);
		//System.out.println(rightSpeed);
		//System.out.println(speed);
	}


}
