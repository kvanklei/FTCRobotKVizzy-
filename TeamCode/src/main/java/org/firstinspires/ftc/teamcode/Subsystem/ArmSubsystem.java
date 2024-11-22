package org.firstinspires.ftc.teamcode.Subsystem;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.teamcode.Constants;

public class ArmSubsystem {
    DcMotorEx arm;

    public ArmSubsystem(HardwareMap hm) {
        arm = hm.get(DcMotorEx.class, "arm");

        arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        arm.setDirection(DcMotorSimple.Direction.REVERSE);

        update_pidf(Constants.arm_p, Constants.arm_i, Constants.arm_d, Constants.arm_f1);
    }

    public void p1() {
        update_pidf(Constants.arm_p, Constants.arm_i, Constants.arm_d, Constants.arm_f1);
        arm.setTargetPosition(Constants.arm_p1);
        arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        arm.setPower(.5);

    }

    public void p2() {
        update_pidf(Constants.arm_p, Constants.arm_i, Constants.arm_d, Constants.arm_f1);
        arm.setTargetPosition(Constants.arm_p2);
        arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        arm.setPower(0.5);

    }

    public void p3() {
        update_pidf(Constants.arm_p, Constants.arm_i, Constants.arm_d, Constants.arm_f1);
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

    public void update_pidf(double p, double i, double d, double f) {
        PIDFCoefficients pidf_vals = new PIDFCoefficients(p, i, d, f);
        arm.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, pidf_vals);
    }
    public void periodic() {
        telemetry.addData("Current Arm Position", arm. getCurrentPosition());
    }
}
