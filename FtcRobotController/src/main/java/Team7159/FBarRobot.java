package Team7159;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import Team7159.Enums.Direction;
import Team7159.Enums.Version;
import Team7159.Utils.MotorGroup;
import Team7159.Utils.RobotComp;
import Team7159.Utils.RobotMath;

/**
 * Created by WILLIAM LIN on 10/26/2017 for the Android Robot Controller.
 * THIS IS PROBABLY A USEFUL CLASS
 */

public class FBarRobot {

    public RobotComp Comp;

    public Servo LAST;
    public Servo RAST;

    public Servo LASB;
    public Servo RASB;

    public DcMotor LFMotor;
    public DcMotor RFMotor;
    public DcMotor LBMotor;
    public DcMotor RBMotor;

    public DcMotor Winch;

    public DcMotor AMotor;

    public Servo AAST;
    public Servo AASB;

    public ColorSensor colorSensor;

    public Servo RA;

    public void init(HardwareMap Map){

        Comp = new RobotComp();

        LFMotor = Map.dcMotor.get("LF");
        RFMotor = Map.dcMotor.get("RF");
        LBMotor = Map.dcMotor.get("LB");
        RBMotor = Map.dcMotor.get("RB");

        AMotor = Map.dcMotor.get("Arm");

        Winch = Map.dcMotor.get("Winch");

        LAST = Map.servo.get("LAST");
        RAST = Map.servo.get("RAST");
        LASB = Map.servo.get("LASB");
        RASB = Map.servo.get("RASB");

        AAST = Map.servo.get("AAST");
        AASB = Map.servo.get("AASB");

        RA = Map.servo.get("RA");

        colorSensor = Map.colorSensor.get("colorSensor");

        LFMotor.setPower(0);
        RFMotor.setPower(0);
        LBMotor.setPower(0);
        RBMotor.setPower(0);

        AMotor.setPower(0);

        Winch.setPower(0);

        LAST.setDirection(Servo.Direction.FORWARD);
        LASB.setDirection(Servo.Direction.FORWARD);
        RAST.setDirection(Servo.Direction.REVERSE);
        RASB.setDirection(Servo.Direction.REVERSE);

        RFMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        RBMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        AMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        LFMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        AMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    public void moveStraight(double power){
        LFMotor.setPower(power);
        RFMotor.setPower(power);
        LBMotor.setPower(power);
        RBMotor.setPower(power);
    }

    public void stop(){
        LFMotor.setPower(0);
        RFMotor.setPower(0);
        LBMotor.setPower(0);
        RBMotor.setPower(0);
    }

    public void turn(Direction direction, int degrees, MotorGroup Right, MotorGroup Left){
        Right.resetEncoders();
        Left.resetEncoders();
        int LeftDistance = Comp.computeTurningPos(direction, degrees, Direction.LEFT, 26.5, Version.TWO);
        int RightDistance = Comp.computeTurningPos(direction, degrees, Direction.RIGHT, 26.5, Version.TWO);
        Left.setTargetPosition(LeftDistance);
        Right.setTargetPosition(RightDistance);
        Left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Left.setPowers(0.5);
        Right.setPowers(0.5);
        while(Left.isBusy()&&Right.isBusy()){}
        Left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Left.setPowers(0);
        Right.setPowers(0);
    }

    public void driveDir(Direction direction, double distance, MotorGroup Right, MotorGroup Left){
        Right.resetEncoders();
        Left.resetEncoders();
        Right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        switch(direction){
            case FORWARDS:
                int pos = -Comp.computePositionD(RobotMath.toMeters(distance), Version.TWO);
                Right.setTargetPosition(pos);
                Left.setTargetPosition(pos);
                break;
            case BACKWARDS:
                pos = Comp.computePositionD(RobotMath.toMeters(distance), Version.TWO);
                Right.setTargetPosition(pos);
                Left.setTargetPosition(pos);
                break;
        }
        Right.setPowers(0.5);
        Left.setPowers(0.5);
        while(Right.isBusy()&&Left.isBusy()){}
        Right.setPowers(0);
        Left.setPowers(0);
        Right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

}
