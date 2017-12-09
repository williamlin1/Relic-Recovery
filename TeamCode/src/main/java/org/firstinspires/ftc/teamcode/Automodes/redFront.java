package org.firstinspires.ftc.teamcode.Automodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Team7159.Enums.Colors;
import Team7159.Enums.Side;
import Team7159.FBarRobot;
import Team7159.Utils.ColorManip;

/**
 * Created by WILLIAM LIN on 11/28/2017 for the Relic Recovery game.
 * THIS IS PROBABLY A USEFUL CLASS
 */

//0 is up, 0.6 is down

@Autonomous(name = "redFront")
public class redFront extends LinearOpMode {

    FBarRobot robot = new FBarRobot();
    ColorManip color;

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);
        robot.AAS.setPosition(0);

        robot.colorSensor.enableLed(true);

        waitForStart();

        //swing servo down
        robot.AAS.setPosition(0.8);
        Thread.sleep(2000);
        //0.5 is placeholder for straight down as far as possible

        int r = robot.colorSensor.red();
        int b = robot.colorSensor.blue();

        telemetry.addData("red  ", r);
        telemetry.addData("blue  ", b);
        telemetry.update();

        Colors frontC = r>b?Colors.RED:Colors.BLUE;
        if(r==b){
            telemetry.addData(" r and b are the same", "a");
            telemetry.update();
            Thread.sleep(500);
            robot.AAS.setPosition(0);
            robot.moveStraight(-0.5);
            Thread.sleep(1150);
            robot.stop();
            return;
        }
        if(frontC.equals(Colors.RED)){
            //Hit back, placeholder value

            robot.moveStraight(-0.5);
            Thread.sleep(500);
            robot.stop();
            robot.moveStraight(0.5);
            Thread.sleep(500);
            robot.stop();
        }else{
            //Hit foward, placeholder value
//            robot.SAB.setPosition(0.7);
            robot.moveStraight(0.5);
            Thread.sleep(500);
            robot.stop();
            robot.moveStraight(-0.5);
            Thread.sleep(800);
            robot.stop();
        }

        robot.colorSensor.enableLed(false);

        robot.AAS.setPosition(0);

        robot.moveStraight(-0.5);

        Thread.sleep(1150);

        robot.stop();
        //back as far as possible
//        robot.SAB.setPosition(1);
        //Resetting top to back
//        robot.SAT.setPosition(1);


        //VUFORIA STUFF THAT IM NOT DOING RIGHT NOW

        Side side = Side.CENTER;
//        Side side is wahtever side its suppsdeo to be on

        if(side.equals(Side.CENTER)){
            //go put it in the center
        }else if(side.equals(Side.LEFT)){
            //go to teh left
        }else if(side.equals(Side.RIGHT)){
            //go to the right
        }else if(side.equals(Side.NONEFOUND)){
            //stop
        }

    }
}
