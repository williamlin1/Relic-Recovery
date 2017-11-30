package Team7159.MiscStuff;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by willi on 8/31/2017.
 */

public class HolonomicDude {

    public DcMotor RFMotor;
    public DcMotor RBMotor;
    public DcMotor LFMotor;
    public DcMotor LBMotor;


    public void init(HardwareMap Map){

        RFMotor = Map.dcMotor.get("frontRight");
        RBMotor = Map.dcMotor.get("backRight");
        LFMotor = Map.dcMotor.get("frontLeft");
        LBMotor = Map.dcMotor.get("backLeft");

        RFMotor.setPower(0);
        RBMotor.setPower(0);
        LFMotor.setPower(0);
        LBMotor.setPower(0);

        RFMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LFMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
