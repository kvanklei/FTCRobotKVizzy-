package org.firstinspires.ftc.teamcode.Subsystem;

import androidx.core.math.MathUtils;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.Constants;

public class DriveSubsystem {
        DcMotorEx bl;
        DcMotorEx br;
        IMU imu;
        IMU.Parameters imu_param;
        YawPitchRollAngles robot_orientation;
        public DriveSubsystem(HardwareMap hm) {
            bl = hm.get(DcMotorEx.class, "bl");
            br = hm.get(DcMotorEx.class, "br");

            bl.setDirection(DcMotorSimple.Direction.FORWARD);
            br.setDirection(DcMotorSimple.Direction.REVERSE);

           ////imu parameters
           //imu_param = new IMU.Parameters(
           //        new RevHubOrientationOnRobot(
           //                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
           //                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
           //        )
           //);
            //initializing imu
           // imu.initialize(imu_param);
        }

        public void arcade_drive(double y, double x) {
            bl.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
            br.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

            bl.setPower(y+x);
            br.setPower(y-x);
        }

       public void move_ticks(int ticks, double speed) {
        //reset encoder first
        this.reset_encoder();
        //this.reset_encoder();
        br.setTargetPosition(ticks);
        bl.setTargetPosition(ticks);
        br.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        br.setPower(speed);
        bl.setPower(speed);
        }

    public void reset_encoder() {
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

  // public double get_Yaw() {
  //     robot_orientation = imu.getRobotYawPitchRollAngles();
  //     return robot_orientation.getYaw(AngleUnit.DEGREES);
  // }

    //goes from -180 to 180
  //public void rotate_degrees(double target) {
  //    while (this.get_Yaw() != target) {
  //        double distance = target - this.get_Yaw();

  //        //sets motor speeds
  //       br.setPower(MathUtils.clamp(distance * Constants.rot_kP, -1, 1));
  //        bl.setPower(MathUtils.clamp(-distance * Constants.rot_kP, -1, 1));
  //    }
  //

    //checks if motors are busy
    public boolean bl_busy() {
        return bl.isBusy();
    }
    public boolean br_busy() {
        return br.isBusy();
    }



    }
