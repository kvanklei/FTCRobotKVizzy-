package org.firstinspires.ftc.teamcode.Subsystem;

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
    }

    public void p2() {
        roller.setPosition(Constants.roller_output);
    }

    }







