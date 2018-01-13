package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Team7159.PanamaOld.MecanumV2;

/**
 * Created by William on 10/5/2016.
 * Teleop for Mecanum drive
 */
@Disabled
@TeleOp(name="Mecanum")
public class TeleOpMode extends LinearOpMode {

    MecanumV2 Robot = new MecanumV2();

    double leftFront;
    double leftBack;
    double rightFront;
    double rightBack;

    double servoPosition = 0.43;

    boolean forwards = true;

    @Override
    public void runOpMode() throws InterruptedException{
        Robot.init(hardwareMap);

        waitForStart();
        while(opModeIsActive()){

            rightFront = gamepad1.left_stick_y - gamepad1.right_stick_x - gamepad1.left_stick_x;
            rightBack = gamepad1.left_stick_y - gamepad1.right_stick_x + gamepad1.left_stick_x;
            leftFront  = gamepad1.left_stick_y + gamepad1.right_stick_x + gamepad1.left_stick_x;
            leftBack = gamepad1.left_stick_y + gamepad1.right_stick_x - gamepad1.left_stick_x;

            double maxLeft = Math.max(Math.abs(leftFront), Math.abs(leftBack));
            double maxRight = Math.max(Math.abs(rightFront),Math.abs(rightBack));
            double max = Math.max(Math.abs(maxLeft),Math.abs(maxRight));

            if(max > 1.0){
                leftFront /= max;
                leftBack /= max;
                rightFront /= max;
                rightBack /= max;
            }

            Robot.RFMotor.setPower(rightFront);
            Robot.RBMotor.setPower(rightBack);
            Robot.LFMotor.setPower(leftFront);
            Robot.LBMotor.setPower(leftBack);
        }
    }
}