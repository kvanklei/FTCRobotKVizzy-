package org.firstinspires.ftc.teamcode.Subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.teamcode.Constants;

public class PivotSubsystem {
    DcMotorEx pivot1;
    DcMotorEx pivot2;

    public PivotSubsystem (HardwareMap hm) {
        pivot1 = hm.get(DcMotorEx.class,"pivot1");
        pivot2 = hm.get(DcMotorEx.class, "pivot2");

        pivot1.setDirection(DcMotorSimple.Direction.FORWARD);
        pivot2.setDirection(DcMotorSimple.Direction.REVERSE);

        update_pidf(Constants.pivot_p, Constants.pivot_i, Constants.pivot_d, Constants.pivot_f1);

    }

    public void p1(){
        update_pidf(Constants.pivot_p, Constants.pivot_i, Constants.pivot_d, Constants.pivot_f1);

        pivot1.setTargetPosition(Constants.pivot1_p1);
        pivot1.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        pivot1.setPower(0.5);

        pivot2.setTargetPosition(Constants.pivot2_p1);
        pivot2.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        pivot2.setPower(0.5);

    } public void p2(){
        update_pidf(Constants.pivot_p, Constants.pivot_i, Constants.pivot_d, Constants.pivot_f1);

        pivot1.setTargetPosition(Constants.pivot1_p2);
        pivot1.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        pivot1.setPower(0.5);

        pivot2.setTargetPosition(Constants.pivot2_p2);
        pivot2.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        pivot2.setPower(0.5);

    } public void p3(){
        update_pidf(Constants.pivot_p, Constants.pivot_i, Constants.pivot_d, Constants.pivot_f1);

        pivot1.setTargetPosition(Constants.pivot1_p3);
        pivot1.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        pivot1.setPower(0.5);

        pivot2.setTargetPosition(Constants.pivot2_p3);
        pivot2.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        pivot2.setPower(0.5);
    }
    public void stop() {
        pivot1.setPower(0);
        pivot2.setPower(0);
    }

    public int p1_current_pos() {
        return pivot1.getCurrentPosition();
    }
    public int p2_current_pos() {
        return pivot2.getCurrentPosition();
    }
    public int target_pos() {
        return pivot1.getTargetPosition();
    }


    public void update_pidf(double p, double i, double d, double f) {
        PIDFCoefficients pidf_vals = new PIDFCoefficients(p, i, d, f);
        pivot1.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, pidf_vals);
        pivot2.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, pidf_vals);
    }


}

