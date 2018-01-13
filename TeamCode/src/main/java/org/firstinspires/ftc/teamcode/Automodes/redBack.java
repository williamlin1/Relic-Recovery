package org.firstinspires.ftc.teamcode.Automodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import Team7159.Enums.Colors;
import Team7159.Enums.Direction;
import Team7159.Enums.Side;
import Team7159.FBarRobot;
import Team7159.Utils.ColorManip;
import Team7159.Utils.MotorGroup;

/**
 * Created by WILLIAM LIN on 11/28/2017 for the Relic Recovery game.

 */

@Autonomous(name = "redBack")
public class redBack extends LinearOpMode {

    FBarRobot robot = new FBarRobot();
    ColorManip color;

    MotorGroup Left = new MotorGroup();
    MotorGroup Right = new MotorGroup();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        Left.addMotor(robot.LFMotor,robot.LBMotor);
        Right.addMotor(robot.RFMotor,robot.RBMotor);

        robot.AAST.setPosition(0);

        robot.colorSensor.enableLed(true);

        waitForStart();

        //swing servo down
        robot.AAST.setPosition(0.8);
        Thread.sleep(2000);

        int r = robot.colorSensor.red();
        int b = robot.colorSensor.blue();

        telemetry.addData("red  ", r);
        telemetry.addData("blue  ", b);
        telemetry.update();

        Colors frontC = r>b?Colors.RED:Colors.BLUE;
        if(r==b){
            telemetry.addData(" r and b are the same", "a");
            telemetry.update();
        }else if(frontC.equals(Colors.RED)){
            //Wherever back is
            robot.AASB.setPosition(0.6);
        }else{
            //Wherever front is
            robot.AASB.setPosition(0.8);
        }

        //VUFORIOS THIS SHIT MY DUDEEEEEE

        robot.driveDir(Direction.FORWARDS,35,Right,Left);
        robot.turn(Direction.RIGHT, 90, Right,Left);

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
