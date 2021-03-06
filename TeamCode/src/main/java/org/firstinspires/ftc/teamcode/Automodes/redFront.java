package org.firstinspires.ftc.teamcode.Automodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.HINT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import Team7159.Enums.Colors;
import Team7159.Enums.Direction;
import Team7159.FBarRobot;
import Team7159.Utils.MotorGroup;

/**
 * Created by WILLIAM LIN on 11/28/2017 for the Relic Recovery game.
 * THIS IS PROBABLY A USEFUL CLASS
 */

//0 is up, 0.6 is down

@Autonomous(name = "redFront")
public class redFront extends LinearOpMode {

    VuforiaLocalizer vuforia;
    VuforiaLocalizer.Parameters parameters;

    FBarRobot robot = new FBarRobot();

    MotorGroup Right = new MotorGroup();
    MotorGroup Left = new MotorGroup();

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        Left.addMotor(robot.LFMotor,robot.LBMotor);
        Right.addMotor(robot.RFMotor,robot.RBMotor);

        robot.AAST.setPosition(0);
        robot.AASB.setPosition(0.4);

        robot.colorSensor.enableLed(true);

        parameters = new VuforiaLocalizer.Parameters(com.qualcomm.ftcrobotcontroller.R.id.cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "AVktbtv/////AAAAGY1koTqeTUyKsH17S4sxg5FdzjlL4sab4r1TteImHLQZaxsQP96TVimg0LSECJMSTY" +
                "/hMmyl4Ko8WqEFHdESFWl5CNgqDIkVJsLD4ivpj1OAwtHu6z1Me1lnhV/DlBshYL9nsfqWCvVyPPpMkYBj3DRGGI" +
                "6OHwD29CokKIxnknH8sV/k8xdVFSAmsRqBney+t4+c7vmUw39q7qrsE63Pf6wnFxYLkDz4uFvjy3IHbX3/OLojTN" +
                "Gk4/sHOWnME0c8EEVXUZAoXPM/7jJK/ksBrYMPyJTZOeMPhcTMtjsPNMVx54p5yICLcIGjqPwTih1Z88RGDGKIuY" +
                "vIrnSMjUnJNZtshuuqadeAXk2HyGS6DR3K";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        parameters.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;
        vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        vuforia.setFrameQueueCapacity(6);
        Vuforia.setHint(HINT.HINT_MAX_SIMULTANEOUS_IMAGE_TARGETS, 4);

        VuforiaTrackables Images = this.vuforia.loadTrackablesFromAsset("RelicVuMark");

        VuforiaTrackable template = Images.get(0);

        waitForStart();

        Images.activate();
        //swing servo down
        robot.AAST.setPosition(0.8);
        Thread.sleep(1000);
        //0.5 is placeholder for straight down as far as possible

        int r = robot.colorSensor.red();
        int b = robot.colorSensor.blue();

        telemetry.addData("red  ", r);
        telemetry.addData("blue  ", b);
        telemetry.update();

        Colors frontC = r>b? Colors.RED: Colors.BLUE;
        if(r==b){
            telemetry.addData(" r and b are the same", "a");
            telemetry.update();
        }else if(frontC.equals(Colors.RED)){
            // hit to wherever
            robot.AASB.setPosition(0.4);
        }else{
            robot.AASB.setPosition(1.0);
        }

        robot.colorSensor.enableLed(false);

        robot.AAST.setPosition(0);

        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(template);

        if(vuMark.equals(RelicRecoveryVuMark.CENTER)){
            telemetry.addData("vuMark ", "In the center");
            telemetry.update();

            robot.driveDir(Direction.BACKWARDS,36, Right, Left);
            robot.turn(Direction.RIGHT,90,Right,Left);
            robot.driveDir(Direction.FORWARDS,10, Right, Left);
            //do some center stuff
        }else if(vuMark.equals(RelicRecoveryVuMark.LEFT)){
            telemetry.addData("vuMark ", "In the left");
            telemetry.update();

            robot.driveDir(Direction.BACKWARDS,28, Right, Left);
            robot.turn(Direction.RIGHT,90,Right,Left);
            robot.driveDir(Direction.FORWARDS,10, Right, Left);
            // do some left stuff
        }else if(vuMark.equals(RelicRecoveryVuMark.RIGHT)){
            telemetry.addData("vuMark ", "In the right");
            telemetry.update();

            robot.driveDir(Direction.BACKWARDS,45, Right, Left);
            robot.turn(Direction.RIGHT,90,Right,Left);
            robot.driveDir(Direction.FORWARDS,10, Right, Left);

            // do some right stuff
        }else{
            telemetry.addData("vuMark ", "who nose");
            telemetry.update();

            robot.driveDir(Direction.BACKWARDS,36, Right, Left);
            robot.turn(Direction.RIGHT,90,Right,Left);
            robot.driveDir(Direction.FORWARDS,10, Right, Left);

            //it's unknown, just go to the center i suppose
        }
    }
}