package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import Team7159.FBarRobot;
import Team7159.Utils.MotorGroup;

/**
 * Created by WILLIAM LIN on 10/26/2017 for the Android Robot Controller.
 * THIS IS PROBABLY A USEFUL CLASS
 */
@Disabled
@TeleOp(name="TeleOp4Bar")
public class TeleOp4Bar extends LinearOpMode{

    private FBarRobot robot = new FBarRobot();

//    MotorGroup left;
//    MotorGroup right;

    double maxLeft;
    double maxRight;
    double max;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

        double posr = 0.4;
        double posl = 0.1;



        robot.RAST.setPosition(posr);
        robot.RASB.setPosition(posr);
        robot.LAST.setPosition(posl);
        robot.LASB.setPosition(posl);

        while(opModeIsActive()) {

            double rightFront = gamepad1.left_stick_y + gamepad1.left_stick_x;
            double rightBack = gamepad1.left_stick_y - gamepad1.left_stick_x;
            double leftFront = gamepad1.left_stick_y - gamepad1.left_stick_x;
            double leftBack = gamepad1.left_stick_y + gamepad1.left_stick_x;
            if(Math.sqrt(Math.pow(gamepad1.left_stick_y,2)+Math.pow(gamepad1.left_stick_x,2))<0.4) {
                rightFront /= 2;
                rightBack /= 2;
                leftFront /= 2;
                leftBack /= 2;
            }

            boolean turning = gamepad1.left_stick_button;
            double thing = gamepad1.left_stick_x;
            while(turning){
                if(thing>0){
                    robot.RFMotor.setPower(0.5);
                    robot.RBMotor.setPower(0.5);
                    robot.LFMotor.setPower(-0.5);
                    robot.LBMotor.setPower(-0.5);
                }else if(thing < 0){
                    robot.RFMotor.setPower(-0.5);
                    robot.RBMotor.setPower(-0.5);
                    robot.LFMotor.setPower(0.5);
                    robot.LBMotor.setPower(0.5);
                }
                turning = gamepad1.left_stick_button;
            }

            double maxLeft = Math.max(Math.abs(leftFront), Math.abs(leftBack));
            double maxRight = Math.max(Math.abs(rightFront),Math.abs(rightBack));
            double max = Math.max(Math.abs(maxLeft),Math.abs(maxRight));

            if(max > 1.0){
                leftFront /= max;
                leftBack /= max;
                rightFront /= max;
                rightBack /= max;
            }

            robot.AAST.setPosition(0);

                //  gamepad1.left_trigger>0{

            robot.LFMotor.setPower(leftFront);
            robot.LBMotor.setPower(leftBack);
            robot.RFMotor.setPower(rightFront);
            robot.RBMotor.setPower(rightBack);
            robot.AMotor.setPower(-gamepad1.right_stick_y);

            if(gamepad1.right_bumper){
                robot.RA.setPosition(0);
            }

            if(gamepad1.right_trigger>0){
                robot.RA.setPosition(0.2);
            }

            boolean open = gamepad1.left_trigger>0;
            while(open){

                posr = posr-0.04<0.4?0.4:posr-0.04;
                posl = posl-0.04<0.1?0.1:posl-0.04;

                robot.RAST.setPosition(posr);
                robot.RASB.setPosition(posr);
                robot.LAST.setPosition(posl);
                robot.LASB.setPosition(posl);

                rightFront = gamepad1.left_stick_y + gamepad1.left_stick_x;
                rightBack = gamepad1.left_stick_y - gamepad1.left_stick_x;
                leftFront  = gamepad1.left_stick_y - gamepad1.left_stick_x;
                leftBack = gamepad1.left_stick_y + gamepad1.left_stick_x;

                turning = gamepad1.left_stick_button;
                thing = gamepad1.left_stick_x;
                while(turning){
                    if(thing>0){
                        robot.RFMotor.setPower(0.5);
                        robot.RBMotor.setPower(0.5);
                        robot.LFMotor.setPower(-0.5);
                        robot.LBMotor.setPower(-0.5);
                    }else if(thing < 0){
                        robot.RFMotor.setPower(-0.5);
                        robot.RBMotor.setPower(-0.5);
                        robot.LFMotor.setPower(0.5);
                        robot.LBMotor.setPower(0.5);
                    }
                    turning = gamepad1.left_stick_button;
                }

                robot.AMotor.setPower(-gamepad1.right_stick_y);

                if(Math.sqrt(Math.pow(gamepad1.left_stick_y,2)+Math.pow(gamepad1.left_stick_x,2))<0.4) {
                    rightFront /= 2;
                    rightBack /= 2;
                    leftFront /= 2;
                    leftBack /= 2;
                }

                maxLeft = Math.max(Math.abs(leftFront), Math.abs(leftBack));
                maxRight = Math.max(Math.abs(rightFront),Math.abs(rightBack));
                max = Math.max(Math.abs(maxLeft),Math.abs(maxRight));

                if(max > 1.0){
                    leftFront /= max;
                    leftBack /= max;
                    rightFront /= max;
                    rightBack /= max;
                }


                robot.LFMotor.setPower(leftFront);
                robot.LBMotor.setPower(leftBack);
                robot.RFMotor.setPower(rightFront);
                robot.RBMotor.setPower(rightBack);

                if(gamepad1.right_bumper){
                    robot.RA.setPosition(0);
                }

                if(gamepad1.right_trigger>0){
                    robot.RA.setPosition(0.1);
                }

                open = gamepad1.left_trigger>0;

                Thread.sleep(10);

            }

            boolean close = gamepad1.left_bumper;

            while(close){

                posr = posr+0.025>1?1:posr+0.025;
                posl = posl+0.025>0.82?0.82:posl+0.025;

                robot.RAST.setPosition(posr);
                robot.RASB.setPosition(posr);
                robot.LAST.setPosition(posl);
                robot.LASB.setPosition(posl);

                rightFront = gamepad1.left_stick_y + gamepad1.left_stick_x;
                rightBack = gamepad1.left_stick_y - gamepad1.left_stick_x;
                leftFront  = gamepad1.left_stick_y - gamepad1.left_stick_x;
                leftBack = gamepad1.left_stick_y + gamepad1.left_stick_x;

                turning = gamepad1.left_stick_button;
                thing = gamepad1.left_stick_x;
                while(turning){
                    if(thing>0){
                        robot.RFMotor.setPower(0.5);
                        robot.RBMotor.setPower(0.5);
                        robot.LFMotor.setPower(-0.5);
                        robot.LBMotor.setPower(-0.5);
                    }else if(thing < 0){
                        robot.RFMotor.setPower(-0.5);
                        robot.RBMotor.setPower(-0.5);
                        robot.LFMotor.setPower(0.5);
                        robot.LBMotor.setPower(0.5);
                    }
                    turning = gamepad1.left_stick_button;
                }

                robot.AMotor.setPower(-gamepad1.right_stick_y);


                if(Math.sqrt(Math.pow(gamepad1.left_stick_y,2)+Math.pow(gamepad1.left_stick_x,2))<0.4) {
                    rightFront /= 2;
                    rightBack /= 2;
                    leftFront /= 2;
                    leftBack /= 2;
                }

                maxLeft = Math.max(Math.abs(leftFront), Math.abs(leftBack));
                maxRight = Math.max(Math.abs(rightFront),Math.abs(rightBack));
                max = Math.max(Math.abs(maxLeft),Math.abs(maxRight));

                if(max > 1.0){
                    leftFront /= max;
                    leftBack /= max;
                    rightFront /= max;
                    rightBack /= max;
                }

                robot.LFMotor.setPower(leftFront);
                robot.LBMotor.setPower(leftBack);
                robot.RFMotor.setPower(rightFront);
                robot.RBMotor.setPower(rightBack);

                if(gamepad1.right_bumper){
                    robot.RA.setPosition(0);
                }

                if(gamepad1.right_trigger>0){
                    robot.RA.setPosition(0.1);
                }

                close = gamepad1.left_bumper;
            }


            boolean extend = gamepad1.dpad_left;
            while(extend){

                rightFront = gamepad1.left_stick_y + gamepad1.left_stick_x;
                rightBack = gamepad1.left_stick_y - gamepad1.left_stick_x;
                leftFront  = gamepad1.left_stick_y - gamepad1.left_stick_x;
                leftBack = gamepad1.left_stick_y + gamepad1.left_stick_x;

                turning = gamepad1.left_stick_button;
                thing = gamepad1.left_stick_x;
                while(turning){
                    if(thing>0){
                        robot.RFMotor.setPower(0.5);
                        robot.RBMotor.setPower(0.5);
                        robot.LFMotor.setPower(-0.5);
                        robot.LBMotor.setPower(-0.5);
                    }else if(thing < 0){
                        robot.RFMotor.setPower(-0.5);
                        robot.RBMotor.setPower(-0.5);
                        robot.LFMotor.setPower(0.5);
                        robot.LBMotor.setPower(0.5);
                    }
                    turning = gamepad1.left_stick_button;
                }

                robot.AMotor.setPower(-gamepad1.right_stick_y);

                maxLeft = Math.max(Math.abs(leftFront), Math.abs(leftBack));
                maxRight = Math.max(Math.abs(rightFront),Math.abs(rightBack));
                max = Math.max(Math.abs(maxLeft),Math.abs(maxRight));

                if(max > 1.0){
                    leftFront /= max;
                    leftBack /= max;
                    rightFront /= max;
                    rightBack /= max;
                }

                robot.Winch.setPower(0.52);
                extend = gamepad1.dpad_left;

                robot.LFMotor.setPower(leftFront);
                robot.LBMotor.setPower(leftBack);
                robot.RFMotor.setPower(rightFront);
                robot.RBMotor.setPower(rightBack);
            }

            robot.Winch.setPower(0);
        }
    }
}