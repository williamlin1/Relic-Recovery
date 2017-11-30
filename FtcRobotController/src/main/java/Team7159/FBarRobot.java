package Team7159;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by WILLIAM LIN on 10/26/2017 for the Android Robot Controller.
 * THIS IS PROBABLY A USEFUL CLASS
 */

public class FBarRobot {

    public Servo LS;
    public Servo RS;

    public DcMotor LFMotor;
    public DcMotor RFMotor;
    public DcMotor LBMotor;
    public DcMotor RBMotor;

    public DcMotor AMotor;

    public void init(HardwareMap Map){

        LFMotor = Map.dcMotor.get("LF");
        RFMotor = Map.dcMotor.get("RF");
        LBMotor = Map.dcMotor.get("LB");
        RBMotor = Map.dcMotor.get("RB");

        AMotor = Map.dcMotor.get("Arm");

        LS = Map.servo.get("LS");
        RS = Map.servo.get("RS");


        LFMotor.setPower(0);
        RFMotor.setPower(0);
        LBMotor.setPower(0);
        RBMotor.setPower(0);

        AMotor.setPower(0);

        LS.setDirection(Servo.Direction.FORWARD);
        RS.setDirection(Servo.Direction.REVERSE);

        LFMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        LBMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        LFMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        AMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }
}
