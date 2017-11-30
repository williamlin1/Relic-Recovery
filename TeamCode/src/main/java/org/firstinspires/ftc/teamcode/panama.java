package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Team7159.FBarRobot;
import Team7159.PanamaOld.panabot;
import Team7159.Utils.MotorGroup;

/**
 * Created by WILLIAM LIN on 10/26/2017 for the Android Robot Controller.
 * THIS IS PROBABLY A USEFUL CLASS
 */
@TeleOp(name="panama")
public class panama extends LinearOpMode{

    panabot robot = new panabot();


    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        Boolean shoot = false;

        waitForStart();


        while(opModeIsActive()) {

            shoot = gamepad1.y;
            while(shoot) {

                double r = -gamepad1.left_stick_y - gamepad1.left_stick_x;
                double l = -gamepad1.left_stick_y + gamepad1.left_stick_x;


                double max = Math.max(Math.abs(l), Math.abs(r));

                if (max != 0) {
                    r /= max;
                    l /= max;
                } else {
                    r = 0;
                    l = 0;
                }

                robot.left.setPower(l);
                robot.right.setPower(r);
                robot.shooter.setPower(-0.75);
                shoot = gamepad1.y;
            }
            double r = -gamepad1.left_stick_y - gamepad1.left_stick_x;
            double l = -gamepad1.left_stick_y + gamepad1.left_stick_x;


            double max = Math.max(Math.abs(l), Math.abs(r));

            if (max != 0) {
                r /= max;
                l /= max;
            } else {
                r = 0;
                l = 0;
            }

            robot.left.setPower(l);
            robot.right.setPower(r);

            robot.shooter.setPower(0);

        }
    }
}