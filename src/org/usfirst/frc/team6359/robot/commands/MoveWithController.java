package org.usfirst.frc.team6359.robot.commands;

import org.usfirst.frc.team6359.robot.OI;
import org.usfirst.frc.team6359.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class MoveWithController extends Command{

	public MoveWithController() {
		
		requires(Robot.driveTrain);
		
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void execute(Hand left, Hand right) {
		boolean up, down;
		double xIn, yIn;
		
		xIn = OI.controller.getX(left);
		yIn = OI.controller.getY(left);
		up = OI.controller.getBumper(right);		
		down = OI.controller.getBumper(left);
	
		
		
		
		Robot.driveTrain.DriveArcade(xIn, yIn);
		Robot.driveTrain.gear(up, down);
		
		if (up == true){
			System.out.println("upshift");
		}
		else{}
		
		if (down == true){
			
			System.out.println("downshift");
		
		
		
		
		}
	}
}
	

	
	

