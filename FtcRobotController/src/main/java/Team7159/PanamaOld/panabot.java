package Team7159.PanamaOld;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by WILLIAM LIN on 10/26/2017 for the Android Robot Controller.
 * THIS IS PROBABLY A USEFUL CLASS
 */

public class panabot {

    public DcMotor left;
    public DcMotor right;

    public DcMotor shooter;

    public void init(HardwareMap Map){

        left = Map.dcMotor.get("LF");
        right = Map.dcMotor.get("RF");

        shooter = Map.dcMotor.get("shoot");

        left.setPower(0);
        right.setPower(0);

        shooter.setPower(0);

        left.setDirection(DcMotorSimple.Direction.REVERSE);

        left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        shooter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }
}