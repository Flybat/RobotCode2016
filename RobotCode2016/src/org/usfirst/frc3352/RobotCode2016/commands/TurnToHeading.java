package org.usfirst.frc3352.RobotCode2016.commands;

import org.usfirst.frc3352.RobotCode2016.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnToHeading extends Command {
	
	double target;
	double angle;
	double error, integral, p;
	double kP, kI;
	int onTargetCounter;

    public TurnToHeading(double heading) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	target = heading;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	angle = Robot.drivetrain.getAngle();
    	kP = .08;
    	kI = 0.0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angle = Robot.drivetrain.getAngle();
    	error = target-angle;
    	
    	if(Math.abs(error)<3) error = 0;
    	
    	integral += error*kI;
    	
    	p = error *kP;
    	
    	Robot.drivetrain.arcade(0, p+integral);
    	
    	if(error == 0){
    		onTargetCounter++;
    	}else{
    		onTargetCounter = 0;
    	}
    	
    	SmartDashboard.putNumber("drivetrain error", error);
    	SmartDashboard.putNumber("drivetrain angle", angle);
    	SmartDashboard.putNumber("drivetrain target", target);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return onTargetCounter>4;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
