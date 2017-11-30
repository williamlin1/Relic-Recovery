package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

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

    @Override
    public void runOpMode() throws InterruptedException {


        robot.init(hardwareMap);


        waitForStart();

//        left.addMotor(robot.LFMotor,robot.LBMotor);
//        right.addMotor(robot.RFMotor,robot.RBMotor);

        double posr = 0.3;
        double posl = 0.3;



        robot.RS.setPosition(posr);
        robot.LS.setPosition(posl);



        while(opModeIsActive()) {

            boolean close = gamepad1.x;
            boolean open = gamepad1.b;

            double r = -gamepad1.left_stick_y-gamepad1.left_stick_x;
            double l = -gamepad1.left_stick_y+gamepad1.left_stick_x;

            double a = -gamepad1.right_stick_y;

            double max = Math.max(Math.abs(l), Math.abs(r));

            if(max!=0) {
                r /= max;
                l /= max;
            }else{
                r = 0;
                l = 0;
            }

            while(close){

                posl = posl<=0?0:posl-0.05;
                posr = posr<=0?0:posr-0.05;

                close = gamepad1.x;

                robot.LS.setPosition(posl);
                robot.RS.setPosition(posr);
                Thread.sleep(30);

                telemetry.addData("position of the left  ", posl);
                telemetry.addData("position of the right  ", posr);

                robot.LFMotor.setPower(l);
                robot.LBMotor.setPower(l);
                robot.RFMotor.setPower(r);
                robot.RBMotor.setPower(r);

                robot.AMotor.setPower(a);
            }
            while(open){

                posl = posl<=0?0:posl+0.05;
                posr = posr<=0?0:posr+0.05;

                open = gamepad1.b;

                robot.LS.setPosition(posl);
                robot.RS.setPosition(posr);
                Thread.sleep(30);

                telemetry.addData("position of the left  ", posl);
                telemetry.addData("position of the right  ", posr);

                robot.LFMotor.setPower(l);
                robot.LBMotor.setPower(l);
                robot.RFMotor.setPower(r);
                robot.RBMotor.setPower(r);

                robot.AMotor.setPower(a);

            }

            robot.LS.setPosition(robot.LS.getPosition());
            robot.RS.setPosition(robot.RS.getPosition());

            robot.LFMotor.setPower(l);
            robot.LBMotor.setPower(l);
            robot.RFMotor.setPower(r);
            robot.RBMotor.setPower(r);

            robot.AMotor.setPower(a);
        }
    }
}
