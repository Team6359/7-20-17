package org.usfirst.frc.team6359.robot.subsystems;

import java.util.Timer;
import java.util.TimerTask;

import org.usfirst.frc.team6359.robot.OI;
import org.usfirst.frc.team6359.robot.Robot;
import org.usfirst.frc.team6359.robot.commands.MoveWithController;
import org.usfirst.frc.team6359.robot.commands.MoveWithJoystick;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	//gear 
	int gear;
	double gearVal;
	String gearNumber;
	// DriveArcade 
	double x, y, leftSpeed, rightSpeed, speed;
	double speedLimit = 1;
	//Drive 
	public static SpeedController l1, l2, r1, r2;
	
	Encoder encRight = new Encoder(0,1,true);
	Encoder encLeft = new Encoder(2,3,true);
	
	ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	
	
	
	public DriveTrain(){
	
		//speed controller type and PWM port
		l1 = new Victor(4);
		l2 = new Victor(3);
		r1 = new Victor(2);
		r2 = new Victor(1);
		
		
			
		//inverts speed controllers
		l1.setInverted(false);
		l2.setInverted(false);
		r1.setInverted(true);
		r2.setInverted(true);
		}
	
	
	public double rightEncoder(boolean reset){
		
		
		if(reset){
			encRight.reset();
			}
		else{}
		
		return encRight.getRaw();
		}
	
	
	
	public double leftEncoder(boolean reset){
		
		if(reset){
			encLeft.reset();
			}
		else{}
		
		return encLeft.getRaw();
		}
	
	
	public double gyro(boolean reset){
		
		
		if(reset){
			gyro.reset();
		}
		else{}
		
		return gyro.getAngle();
	}
	
	
	
	public void gear(boolean up, boolean down){
		
		/* 	gear: gear variable that is changed (0 or 1)
			gearVal: gear's power value
			gearNumber: gear output that is displayed (Lo or Hi)
		*/
		
		//changes the gear
		if (up == true){
			gear = gear + 1;
		}
		else{}
		
		if (down == true){
			gear = gear - 1;	
		}
		else{}
		
		if (gear > 1){
			gear = 1;
		}
		else{}
		
		if (gear < 0){
			gear = 0;
		}
		else{}
		
		//assigns the gear's power value
		switch (gear){
		
			case 0: gearVal = .38;
				break;
			case 1: gearVal = 1;
				break;
		}
		
		//changes "0" and "1" to "Lo" and "Hi"
		if(gear == 0){
			gearNumber = "Lo";
		}
		else{
			gearNumber = "Hi";
		}
		
		//sends gear information to the dsOutput subsystem
		Robot.dsOutput.gear(gear, gearVal, gearNumber);
	
	}
	
	public void DriveArcade(double xAxis, double yAxis){
		
		/*	x: robot move value
		 * 	y: robot rotation value
		 * 	speedLimit: limits max power
		 * 	leftSpeed: left side power
		 * 	rightSpeed: right side power 
		 * 	speed: average of left and right power
		 */
		
		//squares joystick inputs
		if(yAxis >= 0){
			y = yAxis * yAxis;
		}
		else{ 
			y = (yAxis * yAxis) * -1;
		}
		if(xAxis >= 0){
			x = xAxis * xAxis;
		}
		else{ 
			x = (xAxis * xAxis) * -1;
		}
		
		//formula for arcade drive
		leftSpeed = (y + x) * speedLimit; 
		rightSpeed = (y - x) * speedLimit;
		speed = (leftSpeed + rightSpeed) / 2;
		
		//sends power numbers to Drive method
		Drive(leftSpeed, rightSpeed);
		
		//sends Drive Arcade information to sdOutput subsystem
		Robot.dsOutput.drive(x, y, speedLimit, leftSpeed, rightSpeed, speed);
		
		}
	
	
	
	
	public void Drive(double leftSpeed, double rightSpeed){
		
		//sets speed controllers
		l1.set(leftSpeed * gearVal);
		l2.set(leftSpeed * gearVal);
		r1.set(rightSpeed * gearVal);
		r2.set(rightSpeed * gearVal);
		
		
		}
	
	public void initDefaultCommand() {
		
		//subsystem's default command
		setDefaultCommand(new MoveWithJoystick());
		
	}
	
}