package org.firstinspires.ftc.teamcode.Subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Constants;

public class ArmSubsystem {
    DcMotor arm;
    public ArmSubsystem(HardwareMap hm) {
        arm = hm.get(DcMotorEx.class, "arm");

        arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        arm.setDirection(DcMotorSimple.Direction.REVERSE);

    }
    public void p1() {
        arm.setTargetPosition(Constants.arm_p1);
        arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        arm.setPower(.5);

    }public void p2() {
        arm.setTargetPosition(Constants.arm_p2);
        arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        arm.setPower(0.5);

    }public void p3() {
        arm.setTargetPosition(Constants.arm_p3);
        arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        arm.setPower(0.5);
    }
    public void stop() {
        arm.setPower(0);
    }

    public int current_pos() {
        return arm.getCurrentPosition();
    }

    public int target_pos() {
        return arm.getTargetPosition();
    }

}
