package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.opmode.TelemetryImpl;

import Team7159.FBarRobot;

/**
 * Created by WILLIAM LIN on 11/2/2017 for the Android Robot Controller.
 * THIS IS PROBABLY A USEFUL CLASS
 */

@TeleOp(name="tester")
public class Tester extends LinearOpMode {

    FBarRobot robot = new FBarRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

        boolean left;
        boolean right;

        while(opModeIsActive()){

     //       robot.RA.setPosition(0.5+gamepad1.left_stick_x/2);

     //       robot.RAS.setPosition(0.5+gamepad1.left_stick_x);
     //       robot.LAS.setPosition(0.5+gamepad1.right_stick_x);

         //   robot.colorSensor.alpha();

            telemetry.addData("red  ", robot.colorSensor.red());
            telemetry.addData("blue  ", robot.colorSensor.blue());
            telemetry.addData("green  ", robot.colorSensor.green());
            telemetry.addData("argb   ", robot.colorSensor.argb());
            telemetry.addData("alpha   ", robot.colorSensor.alpha());
            telemetry.update();
//
//            telemetry.addData("arm thing     ", robot.RA.getPosition());
//            telemetry.update();
//
//            Thread.sleep(100);

//            telemetry.addData("left    ", robot.LAS.getPosition());
//            telemetry.addData("right   ", robot.RAS.getPosition());
//            telemetry.update();
////
////            Thread.sleep(50);
//
//            while(up){
//                posa = posa>=1?1:posa+0.05;
//                robot.AAS.setPosition(posa);
//                up = gamepad1.y;
//                telemetry.addData("aas     ", posa);
//                telemetry.addData("left    ", robot.LAS.getPosition());
//                telemetry.addData("right   ", robot.RAS.getPosition());
//                Thread.sleep(50);
//                telemetry.update();
//            }
//
//
//            while(down){
//                posa = posa<=0?0:posa-0.05;
//                robot.AAS.setPosition(posa);
//                down = gamepad1.a;
//                telemetry.addData("aas     ", posa);
//                telemetry.addData("left    ", robot.LAS.getPosition());
//                telemetry.addData("right   ", robot.RAS.getPosition());
//                Thread.sleep(50);
//                telemetry.update();
//            }





//            left = gamepad1.x;
//            right = gamepad1.b;
//            up = gamepad1.y;
//            down = gamepad1.a;
//
//            while(left){
//                posb = posb>=1?1:posb+0.05 ;
//                robot.SAB.setPosition(posb);
//                left = gamepad1.x;
//                telemetry.addData("top  ", post);
//                telemetry.addData("bottom  ", posb);
//                Thread.sleep(50);
//                telemetry.update();
//            }
//
//            while(right){
//                posb = posb<=0?0:posb-0.05;
//                robot.SAB.setPosition(posb);
//                right = gamepad1.b;
//                telemetry.addData("top  ", post);
//                telemetry.addData("bottom  ", posb);
//                Thread.sleep(50);
//                telemetry.update();
//            }
//
//            while(up){
//                post = post>=1?1:post+0.05;
//                robot.SAT.setPosition(post);
//                up = gamepad1.y;
//                telemetry.addData("top  ", post);
//                telemetry.addData("bottom  ", posb);
//                Thread.sleep(50);
//                telemetry.update();
//            }
//
//            while(down){
//                post = post<=0?0:post-0.05;
//                robot.SAT.setPosition(post);
//                down = gamepad1.a;
//                telemetry.addData("top  ", post);
//                telemetry.addData("bottom  ", posb);
//                Thread.sleep(50);
//                telemetry.update();
//            }
//
//
//            telemetry.addData("top  ", post);
//            telemetry.addData("bottom  ", posb);

        }
    }
}
