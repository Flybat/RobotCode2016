// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3352.RobotCode2016.subsystems;

import org.usfirst.frc3352.RobotCode2016.RobotMap;
import org.usfirst.frc3352.RobotCode2016.commands.*;
//import edu.wpi.first.wpilibj.CANTalon;
//import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.navx.frc.*;
import edu.wpi.first.wpilibj.PIDController;


/**
 *
 */
public class Drivetrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    //private final CANTalon rightDrive1 = RobotMap.drivetrainrightDrive1;
    //private final CANTalon rightDrive2 = RobotMap.drivetrainrightDrive2;
    //private final CANTalon leftDrive1 = RobotMap.drivetrainleftDrive1;
    //private final CANTalon leftDrive2 = RobotMap.drivetrainleftDrive2;
    private final RobotDrive robotDrive = RobotMap.drivetrainrobotDrive;
    public final Encoder leftEncoder = RobotMap.drivetrainleftEncoder;
    //private final Encoder rightEncoder = RobotMap.drivetrainrightEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public final AHRS navx = RobotMap.navx;
    public final PIDController turnController 	  = RobotMap.turnController;
    public final PIDController distanceController = RobotMap.distanceController;
    public final PIDController leftController	  = RobotMap.drivetrainLeftController;
    public final PIDController rightController 	  = RobotMap.drivetrainRightController;


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new Drive());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void drive(double leftVal, double rightVal){
    	robotDrive.tankDrive(leftVal, rightVal);
    }
}

