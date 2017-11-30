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
        double posr = 0.3;
        double posl = 0.3;
        waitForStart();

        boolean left = false;
        boolean right = false;

        while(opModeIsActive()){
            left = gamepad1.x;
            right = gamepad1.b;
            while(left){
                posl = posl<=0?0:posl-0.05 ;
                robot.LS.setPosition(posl);
                left = gamepad1.x;
                telemetry.addData("left  ", posl);
                telemetry.addData("right  ", posr);
                Thread.sleep(50);
                telemetry.update();
            }

            while(right){
                posr = posr<=0?0:posr-0.05;
                robot.RS.setPosition(posr);
                right = gamepad1.b;
                telemetry.addData("left  ", posl);
                telemetry.addData("right  ", posr);
                Thread.sleep(50);
                telemetry.update();
            }



            telemetry.addData("left  ", posl);
            telemetry.addData("right  ", posr);

        }
    }
}
