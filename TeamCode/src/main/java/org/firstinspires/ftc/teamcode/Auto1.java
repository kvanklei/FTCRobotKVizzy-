package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Subsystem.DriveSubsystem;

@Autonomous
public class Auto1 extends LinearOpMode {

    @Override
    public void runOpMode() {

        DriveSubsystem drive_train = new DriveSubsystem(hardwareMap);

        //reset drive motor encoders
        drive_train.reset_encoder();

        waitForStart();

        //move robot forward 1000 ticks
        drive_train.move_ticks(1000,1);



    }
}




