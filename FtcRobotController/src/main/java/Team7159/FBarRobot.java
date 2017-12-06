package Team7159;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import Team7159.Enums.Direction;
import Team7159.Enums.Version;
import Team7159.Utils.MotorGroup;

/**
 * Created by WILLIAM LIN on 10/26/2017 for the Android Robot Controller.
 * THIS IS PROBABLY A USEFUL CLASS
 */

public class FBarRobot {

    public Servo LAS;
    public Servo RAS;

    public DcMotor LFMotor;
    public DcMotor RFMotor;
    public DcMotor LBMotor;
    public DcMotor RBMotor;

    public DcMotor Winch;

    public DcMotor AMotor;

    public Servo AAS;

    public ColorSensor colorSensor;

    public void init(HardwareMap Map){

        LFMotor = Map.dcMotor.get("LF");
        RFMotor = Map.dcMotor.get("RF");
        LBMotor = Map.dcMotor.get("LB");
        RBMotor = Map.dcMotor.get("RB");

        AMotor = Map.dcMotor.get("Arm");

        Winch = Map.dcMotor.get("Winch");

        LAS = Map.servo.get("LAS");
        RAS = Map.servo.get("RAS");

        AAS = Map.servo.get("AAS");

        colorSensor = Map.colorSensor.get("colorSensor");

        LFMotor.setPower(0);
        RFMotor.setPower(0);
        LBMotor.setPower(0);
        RBMotor.setPower(0);

        AMotor.setPower(0);

        Winch.setPower(0);

        LAS.setDirection(Servo.Direction.FORWARD);
        RAS.setDirection(Servo.Direction.REVERSE);

        RFMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        RBMotor.setDirection(DcMotorSimple.Direction.REVERSE);

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

//    public void turn(Direction direction, int degrees, MotorGroup Right, MotorGroup Left){
//        Right.resetEncoders();
//        Left.resetEncoders();
//        int LeftDistance = Comp.computeTurningPos(direction, degrees,Direction.LEFT, 19.0, Version.TWO);
//        int RightDistance = Comp.computeTurningPos(direction, degrees,Direction.RIGHT, 19.0, Version.TWO);
//        Left.setTargetPosition(LeftDistance);
//        Right.setTargetPosition(RightDistance);
//        Left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        Right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        Left.setPowers(0.5);
//        Right.setPowers(0.5);
//        while(Left.isBusy()&&Right.isBusy()){
//        }
//        Left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        Right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        Left.setPowers(0);
//        Right.setPowers(0);
//    }

}
