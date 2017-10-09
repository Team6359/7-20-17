package org.usfirst.frc.team6359.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestRun extends CommandGroup{

	public TestRun(){
		
		addSequential(new DriveStrait(36, .25));
		addSequential(new TurnDegrees(90, .3, "l"));
		addSequential(new DriveStrait(36, .25));
		addSequential(new TurnDegrees(90, .3 ,"r"));
		addSequential(new DriveStrait(-36, .25));
		addSequential(new TurnDegrees(90, .3, "l"));
		addSequential(new DriveStrait(-36, .25));
		addSequential(new TurnDegrees(90, .3 ,"r"));
			
	}
	
	
	
	
	
	
}
