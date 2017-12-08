package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import Team7159.FBarRobot;
import Team7159.Utils.MotorGroup;

/**
 * Created by WILLIAM LIN on 10/26/2017 for the Android Robot Controller.
 * THIS IS PROBABLY A USEFUL CLASS
 */
@TeleOp(name="TeleOp4Bar")
public class TeleOp4Bar extends LinearOpMode{

    private FBarRobot robot = new FBarRobot();

//    MotorGroup left;
//    MotorGroup right;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

//        left.addMotor(robot.LFMotor,robot.LBMotor);
//        right.addMotor(robot.RFMotor,robot.RBMotor);

        double posr = 0.4;
        double posl = 0.1;



        robot.RAS.setPosition(posr);
        robot.LAS.setPosition(posl);

        while(opModeIsActive()) {

            double rightFront = gamepad1.left_stick_y + gamepad1.right_stick_x + gamepad1.left_stick_x;
            double rightBack = gamepad1.left_stick_y + gamepad1.right_stick_x - gamepad1.left_stick_x;
            double leftFront  = gamepad1.left_stick_y - gamepad1.right_stick_x - gamepad1.left_stick_x;
            double leftBack = gamepad1.left_stick_y - gamepad1.right_stick_x + gamepad1.left_stick_x;

            double maxLeft = Math.max(Math.abs(leftFront), Math.abs(leftBack));
            double maxRight = Math.max(Math.abs(rightFront),Math.abs(rightBack));
            double max = Math.max(Math.abs(maxLeft),Math.abs(maxRight));

            if(max > 1.0){
                leftFront /= max;
                leftBack /= max;
                rightFront /= max;
                rightBack /= max;
            }

            robot.AAS.setPosition(0);


          //  gamepad1.left_trigger>0{

            boolean open = gamepad1.b;
            boolean close = gamepad1.x;
            boolean half = gamepad1.y;

            if(close){
                robot.RAS.setPosition(1.0);
                robot.LAS.setPosition(0.82);
            }

            if(open){
                robot.RAS.setPosition(0.4);
                robot.LAS.setPosition(0.1);
            }

            if(half){
                robot.RAS.setPosition(0.7);
                robot.LAS.setPosition(0.41);
            }

            double a = -gamepad1.right_stick_y;

            robot.LFMotor.setPower(leftFront);
            robot.LBMotor.setPower(leftBack);
            robot.RFMotor.setPower(rightFront);
            robot.RBMotor.setPower(rightBack);

            robot.AMotor.setPower(a);

            boolean extend = gamepad1.dpad_left;
            while(extend){

                rightFront = gamepad1.left_stick_y + gamepad1.right_stick_x + gamepad1.left_stick_x;
                rightBack = gamepad1.left_stick_y + gamepad1.right_stick_x - gamepad1.left_stick_x;
                leftFront  = gamepad1.left_stick_y - gamepad1.right_stick_x - gamepad1.left_stick_x;
                leftBack = gamepad1.left_stick_y - gamepad1.right_stick_x + gamepad1.left_stick_x;

                robot.AMotor.setPower(a);

                maxLeft = Math.max(Math.abs(leftFront), Math.abs(leftBack));
                maxRight = Math.max(Math.abs(rightFront),Math.abs(rightBack));
                max = Math.max(Math.abs(maxLeft),Math.abs(maxRight));

                if(max > 1.0){
                    leftFront /= max;
                    leftBack /= max;
                    rightFront /= max;
                    rightBack /= max;
                }

                robot.Winch.setPower(0.6);
                extend = gamepad1.dpad_left;
                robot.AMotor.setPower(a);

                robot.LFMotor.setPower(leftFront);
                robot.LBMotor.setPower(leftBack);
                robot.RFMotor.setPower(rightFront);
                robot.RBMotor.setPower(rightBack);
            }

            robot.Winch.setPower(0);
        }
    }
}