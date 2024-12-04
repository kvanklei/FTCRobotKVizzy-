package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.ClawSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.PivotSubsystem;



@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        DriveSubsystem dt = new DriveSubsystem(hardwareMap);
        ArmSubsystem arm = new ArmSubsystem(hardwareMap);
        PivotSubsystem pivot = new PivotSubsystem(hardwareMap);
        ClawSubsystem claw = new ClawSubsystem(hardwareMap);

        waitForStart();
        while (opModeIsActive()) {
            double left_y = gamepad1.left_stick_y;
            double right_x = gamepad1.right_stick_x;

            //drivetrain drive in arcade
            dt.arcade_drive(left_y, right_x);

            if (gamepad2.a) {
                arm.p1();

            } else if (gamepad2.b) {
                arm.p2();

            } else if (gamepad2.y) {
                arm.p3();

            } else {
                arm.stop();
            }

            //pivot stuff

            if (gamepad2.dpad_down){
                pivot.p1();
            }
            else if (gamepad2.dpad_right) {
                pivot.p2();
            }
            else if (gamepad2.dpad_up) {
                pivot.p3();
            }
            else {
                pivot.stop();
            }

            // claw stuff

            // resting position for joint
            }
            if (gamepad2.right_stick_x > 0.2) {
               claw.p1();
            }
            else if (gamepad2.right_stick_x < -0.2){
                claw.p2();
            }



            //telemetry data
            telemetry.addData("Arm Current Position", arm.current_pos());
            telemetry.addData("Arm Target Position", arm.target_pos());
            telemetry.addData("Pivot 1 Current Position", pivot.p1_current_pos());
            telemetry.addData("Pivot 2 Current Position", pivot.p2_current_pos());
            telemetry.addData("Pivot Target Position", pivot.target_pos());
            telemetry.update();
        }
    }


