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
@TeleOp(name = "TeleOp")
public class TeleOpNew extends LinearOpMode{

    private FBarRobot robot = new FBarRobot();

    MotorGroup Left;
    MotorGroup Right;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

        double posrt = 0.5;
        double posrb = 1;
        double poslt = 0.4;
        double poslb = 0.75;

        robot.RAST.setPosition(posrt);
        robot.RASB.setPosition(posrb);
        robot.LAST.setPosition(poslt);
        robot.LASB.setPosition(poslb);

        while(opModeIsActive()) {

            robot.AASB.setPosition(0);
            robot.AAST.setPosition(0.4);

            if(gamepad1.y){
                robot.AMotor.setPower(1);
            }else if(gamepad1.a){
                robot.AMotor.setPower(-0.5);
            }else{
                robot.AMotor.setPower(0);
            }

            double rightFront = gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x;
            double rightBack = gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x;
            double leftFront = gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x;
            double leftBack = gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x;

            if(!gamepad1.left_stick_button) {
                double maxLeft = Math.max(Math.abs(leftFront), Math.abs(leftBack));
                double maxRight = Math.max(Math.abs(rightFront), Math.abs(rightBack));
                double max = Math.max(Math.abs(maxLeft), Math.abs(maxRight));

                if(max > 1.0){
                    leftFront /= max;
                    leftBack /= max;
                    rightFront /= max;
                    rightBack /= max;
                }
                leftFront = leftFront *0.7;
                leftBack = leftBack*0.7;
                rightFront = rightFront*0.7;
                rightBack = rightBack*0.7;
            }else{
                rightFront = rightFront>0?1:-1;
                rightBack = rightBack>0?1:-1;
                leftFront = leftFront>0?1:-1;
                leftBack = leftBack>0?1:-1;
            }

            //  gamepad1.left_trigger>0{

            robot.LFMotor.setPower(leftFront);
            robot.LBMotor.setPower(leftBack);
            robot.RFMotor.setPower(rightFront);
            robot.RBMotor.setPower(rightBack);


            if(gamepad1.right_bumper){
                robot.RA.setPosition(0);
            }

            if(gamepad1.right_trigger>0){
                robot.RA.setPosition(0.2);
            }

            boolean open = gamepad1.left_trigger>0;
            if(open){
                posrt = posrt-0.08<0.2?0.2:posrt-0.08;
                posrb = posrb+0.08>0.8?0.8:posrb+0.08;
                poslt = poslt-0.08<0?0:poslt-0.08;
                poslb = poslb+0.08>0.8?0.8:poslb+0.08;

                robot.RAST.setPosition(posrt);
                robot.RASB.setPosition(posrb);
                robot.LAST.setPosition(poslt);
                robot.LASB.setPosition(poslb);

                telemetry.addData("posrt     ", posrt);
                telemetry.addData("posrb     ", posrb);
                telemetry.addData("poslt     ", poslt);
                telemetry.addData("posrlb    ", poslb);
                telemetry.update();
            }

            boolean close = gamepad1.left_bumper;

            if(close){
                posrt = posrt+0.08>1?1:posrt+0.08;
                posrb = posrb-0.08<0?0:posrb-0.08;
                poslt = poslt+0.08>0.75?0.75:poslt+0.08;
                poslb = poslb-0.08<0?0:poslb-0.08;

                robot.RAST.setPosition(posrt);
                robot.RASB.setPosition(posrb);
                robot.LAST.setPosition(poslt);
                robot.LASB.setPosition(poslb);
            }

            boolean extend = gamepad1.dpad_left;
            if(extend){
                robot.Winch.setPower(0.52);
            }else{
                robot.Winch.setPower(0);
            }
        }
    }
}