package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Team7159.FBarRobot;

/**
 * Created by WILLIAM LIN on 11/2/2017 for the Android Robot Controller.
 * THIS IS PROBABLY A USEFUL CLASS
 */

//@Disabled
@TeleOp(name="tester")
public class Tester extends LinearOpMode {

    FBarRobot robot = new FBarRobot();

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        waitForStart();

//        boolean left;
//        boolean right;

        while(opModeIsActive()){
            robot.colorSensor.enableLed(gamepad1.x);
            robot.RA.setPosition(0.5+gamepad1.right_stick_y/2);
//            robot.RASB.setPosition(0.5+gamepad1.right_stick_x/2);
//            robot.LAST.setPosition(0.5+gamepad1.left_stick_y/2);
//            robot.LASB.setPosition(0.5+gamepad1.left_stick_x/2);

            telemetry.addData("RA     ", robot.RA.getPosition());
//            telemetry.addData("LASB     ", robot.LASB.getPosition());
//            telemetry.addData("RAST     ", robot.RAST.getPosition());
//            telemetry.addData("RASB     ", robot.RASB.getPosition());
            telemetry.update();
        }
    }
}
