package org.firstinspires.ftc.teamcode.Subsystem;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

    public class DriveSubsystem {
        DcMotorEx bl;
        DcMotorEx br;

        public DriveSubsystem(HardwareMap hm) {
            bl = hm.get(DcMotorEx.class, "bl");
            br = hm.get(DcMotorEx.class, "br");

            bl.setDirection(DcMotorSimple.Direction.FORWARD);
            br.setDirection(DcMotorSimple.Direction.REVERSE);
        }

        public void arcade_drive(double y, double x) {
            bl.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
            br.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

            bl.setPower(y+x);
            br.setPower(y-x);
        }

    }
