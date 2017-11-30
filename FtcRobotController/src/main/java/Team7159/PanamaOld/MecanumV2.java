package Team7159.PanamaOld;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * Created by William on 12/13/2016.
 */

public class MecanumV2 {

    HardwareMap HW;

//    public ColorSensor AdafruitSensor;
//    public DeviceInterfaceModule DIM;

    public DcMotor RFMotor;
    public DcMotor RBMotor;
    public DcMotor LFMotor;
    public DcMotor LBMotor;

 //   public Servo RServo;
 //   public Servo LServo;


    public void init(HardwareMap Map){
        HW = Map;

//        DIM = HW.deviceInterfaceModule.get("DIM");
//        DIM.setDigitalChannelMode(5, DigitalChannelController.Mode.OUTPUT);

//        AdafruitSensor = HW.colorSensor.get("Adafruit_Sensor");

        RFMotor = HW.dcMotor.get("FR");
        RBMotor = HW.dcMotor.get("BR");
        LFMotor = HW.dcMotor.get("FL");
        LBMotor = HW.dcMotor.get("BL");

//        RServo = HW.servo.get("Right_Servo");
//        LServo = HW.servo.get("Left_Servo");

        RFMotor.setPower(0);
        RBMotor.setPower(0);
        LFMotor.setPower(0);
        LBMotor.setPower(0);

        RFMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LFMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        RFMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        RBMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        //1 side will be reversed, we are assuming that it is the right side

//        L1Motor.setDirection(DcMotorSimple.Side.REVERSE);
//        L2Motor.setDirection(DcMotorSimple.Side.REVERSE);
    }



    private ElapsedTime period = new ElapsedTime();

    public void waitForTick(long periodMs) throws InterruptedException {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}
