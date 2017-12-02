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

    FBarRobot robot = new FBarRobot();

//    MotorGroup left;
//    MotorGroup right;

    int first = 0;
    int second = 0;

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

            first = second;
            second = robot.AMotor.getCurrentPosition();


            boolean close = gamepad1.x;
            boolean open = gamepad1.b;

            double r = -gamepad1.left_stick_y-gamepad1.left_stick_x;
            double l = -gamepad1.left_stick_y+gamepad1.left_stick_x;

            r = r*Math.abs(r);
            l = l*Math.abs(l);

            double a = -gamepad1.right_stick_y;

            double max = Math.max(Math.abs(l), Math.abs(r));

            if(max!=0) {
                if(max >=1) {
                    r /= max;
                    l /= max;
                }else{
                    continue;
                }
            }else{
                r = 0;
                l = 0;
            }

            while(close){

                first = second;
                second = robot.AMotor.getCurrentPosition();

                posl = posl<=0.1?0.1:posl-0.05;
                posr = posr<=0.4?0.4:posr-0.05;

                r = -gamepad1.left_stick_y-gamepad1.left_stick_x;
                l = -gamepad1.left_stick_y+gamepad1.left_stick_x;

                r = r*Math.abs(r);
                l = l*Math.abs(l);

                 max = Math.max(Math.abs(l), Math.abs(r));

                if(max!=0) {
                    if(max >=1) {
                        r /= max;
                        l /= max;
                    }else{
                        continue;
                    }
                }else{
                    r = 0;
                    l = 0;
                }

                close = gamepad1.x;

                robot.LAS.setPosition(posl);
                robot.RAS.setPosition(posr);
                Thread.sleep(30);

                telemetry.addData("position of the left  ", posl);
                telemetry.addData("position of the right  ", posr);

                robot.LFMotor.setPower(l);
                robot.LBMotor.setPower(l);
                robot.RFMotor.setPower(r);
                robot.RBMotor.setPower(r);


                boolean extend = gamepad1.dpad_left;
                while(extend){

                    r = -gamepad1.left_stick_y-gamepad1.left_stick_x;
                    l = -gamepad1.left_stick_y+gamepad1.left_stick_x;

                    if(first<=second){
                    //    robot.AMotor.setPower(0);
                        first = second;
                        second = robot.AMotor.getCurrentPosition();
                    }else{
                        robot.AMotor.setTargetPosition(first);
                        robot.AMotor.setPower(0.1);
                    }


                    max = Math.max(Math.abs(l), Math.abs(r));

                    if(max!=0) {
                        if(max >=1) {
                            r /= max;
                            l /= max;
                        }else{
                            continue;
                        }
                    }else{
                        r = 0;
                        l = 0;
                    }

                    robot.Winch.setPower(0.3);
                    extend = gamepad1.dpad_left;
                    robot.AMotor.setPower(a);
                    robot.LFMotor.setPower(l);
                    robot.LBMotor.setPower(l);
                    robot.RFMotor.setPower(r);
                    robot.RBMotor.setPower(r);

                }

//                if(first == 0 &&second == 0){
//                    robot.AMotor.setPower(0);
//                }
                if(first<=second){
                    first = second;
                    second = robot.AMotor.getCurrentPosition();
                }else{
                    robot.AMotor.setTargetPosition(first);
                    robot.AMotor.setPower(0.1);
                }

                robot.Winch.setPower(0);
//                left.setPowers(l);
//                right.setPowers(r);

                robot.AMotor.setPower(a);
            }

            while(open){

                first = second;
                second = robot.AMotor.getCurrentPosition();

                r = -gamepad1.left_stick_y-gamepad1.left_stick_x;
                l = -gamepad1.left_stick_y+gamepad1.left_stick_x;

                r = r*Math.abs(r);
                l = l*Math.abs(l);

                max = Math.max(Math.abs(l), Math.abs(r));

                if(max!=0) {
                    if(max >=1) {
                        r /= max;
                        l /= max;
                    }else{
                        continue;
                    }
                }else{
                    r = 0;
                    l = 0;
                }

                if(first<=second){
                    first = second;
           //         robot.AMotor.setPower(0);
                    second = robot.AMotor.getCurrentPosition();
                }else{
                    robot.AMotor.setTargetPosition(first);
                    robot.AMotor.setPower(0.1);
                }

                posl = posl>=1?1:posl+0.05;
                posr = posr>=1?1:posr+0.05;

                open = gamepad1.b;

                robot.LAS.setPosition(posl);
                robot.RAS.setPosition(posr);
                Thread.sleep(30);

                telemetry.addData("position of the left  ", posl);
                telemetry.addData("position of the right  ", posr);

                robot.LFMotor.setPower(l);
                robot.LBMotor.setPower(l);
                robot.RFMotor.setPower(r);
                robot.RBMotor.setPower(r);

//                left.setPowers(l);
//                right.setPowers(r);

                robot.AMotor.setPower(a);

                boolean extend = gamepad1.dpad_left;
                while(extend){
                    if(first<=second){
                        first = second;
                        second = robot.AMotor.getCurrentPosition();
                    }else{
                        robot.AMotor.setTargetPosition(first);
                        robot.AMotor.setPower(0.1);
                    }
                    r = -gamepad1.left_stick_y-gamepad1.left_stick_x;
                    l = -gamepad1.left_stick_y+gamepad1.left_stick_x;

                    r = r*Math.abs(r);
                    l = l*Math.abs(l);

                    max = Math.max(Math.abs(l), Math.abs(r));

                    if(max!=0) {
                        if(max >=1) {
                            r /= max;
                            l /= max;
                        }else{
                            continue;
                        }
                    }else{
                        r = 0;
                        l = 0;
                    }

                    robot.Winch.setPower(0.3);
                    extend = gamepad1.dpad_left;
                    robot.AMotor.setPower(a);
                    robot.LFMotor.setPower(l);
                    robot.LBMotor.setPower(l);
                    robot.RFMotor.setPower(r);
                    robot.RBMotor.setPower(r);
                }

                robot.Winch.setPower(0);
            }

            robot.LAS.setPosition(robot.LAS.getPosition());
            robot.RAS.setPosition(robot.RAS.getPosition());

            max = Math.max(Math.abs(l), Math.abs(r));

            if(max!=0) {
                if(max >=1) {
                    r /= max;
                    l /= max;
                }else{
                    continue;
                }
            }else{
                r = 0;
                l = 0;
            }

            robot.LFMotor.setPower(l);
            robot.LBMotor.setPower(l);
            robot.RFMotor.setPower(r);
            robot.RBMotor.setPower(r);

//            left.setPowers(l);
//            right.setPowers(r);

            boolean extend = gamepad1.dpad_left;
            while(extend){

                if(first<=second){
                    first = second;
                    second = robot.AMotor.getCurrentPosition();
                }else{
                    robot.AMotor.setTargetPosition(first);
                    robot.AMotor.setPower(0.1);
                }

                robot.Winch.setPower(0.3);
                extend = gamepad1.dpad_left;
                robot.AMotor.setPower(a);

            }

            if(first<=second){
                first = second;
                second = robot.AMotor.getCurrentPosition();
            }else{
                robot.AMotor.setTargetPosition(first);
                robot.AMotor.setPower(0.1);
            }


            robot.Winch.setPower(0);

            robot.AMotor.setPower(a);
        }
    }
}