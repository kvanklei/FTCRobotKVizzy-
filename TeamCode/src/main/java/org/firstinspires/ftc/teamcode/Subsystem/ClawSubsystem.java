package org.firstinspires.ftc.teamcode.Subsystem;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class ClawSubsystem {

    Servo roller;


    public ClawSubsystem(HardwareMap hm) {
        roller = hm.get(Servo.class, "roller");
    }


    public void p1() {
        roller.setPosition(Constants.roller_intake);
        //roller.setDirection(Servo.Direction.FORWARD);

    }

    public void p2() {
        roller.setPosition(Constants.roller_output);
        //roller.setDirection(Servo.Direction.REVERSE);

    }

    public void stop() {
        roller.setPosition(Constants.roller_stop);
        //roller.setDirection(Servo.Direction.);
    }
}








