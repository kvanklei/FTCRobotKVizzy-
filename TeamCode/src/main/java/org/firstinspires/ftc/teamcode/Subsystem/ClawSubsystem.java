package org.firstinspires.ftc.teamcode.Subsystem;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class ClawSubsystem {
    Servo joint;
    Servo roller;

    public ClawSubsystem(HardwareMap hm) {
        joint = hm.get(Servo.class, "joint");
        roller = hm.get(Servo.class, "roller");

    }

    public void rest() {
        joint.setPosition(Constants.rest);
    }

    public void intake() {
        joint.setPosition(Constants.intake);
    }

    public void drop() {
        joint.setPosition(Constants.drop);
    }

    public void p1() {
        roller.setPosition(Constants.roller_p1);
    }

    public void p2() {
        roller.setPosition(Constants.roller_p2);
    }

    public double current_pos() {
        return joint.getPosition();


    }
}






