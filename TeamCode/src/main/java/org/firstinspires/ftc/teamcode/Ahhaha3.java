package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//driscoll is the zodiac killer. no fucking way!!!! What!!! noooo!!! But he is my niBBa, how? I like cokeane.

/**
 /**
 * Created by colethompson on 10/27/17.
 */

@Autonomous(name="goright")
public class Ahhaha3 extends LinearOpMode {
    private DcMotor leftFront = null;
    private DcMotor rightFront = null;
    private DcMotor leftBack = null;
    private DcMotor rightBack = null;
    Servo servo1 = null;
    Servo hook1 = null;
    Servo hook2 = null;
    Servo servo2 = null;
    Servo servo3 = null;
    //Sensor color = null;

    @Override
    public void runOpMode() throws InterruptedException {
        leftFront  = hardwareMap.get(DcMotor.class, "left_front");
        rightFront = hardwareMap.get(DcMotor.class, "right_front");
        leftBack = hardwareMap.get(DcMotor.class, "left_back");
        rightBack = hardwareMap.get(DcMotor.class, "right_back");
        servo1 = hardwareMap.servo.get("servo1");
        hook1 = hardwareMap.servo.get("hook1");
        hook2 = hardwareMap.servo.get("hook2");
        servo2 = hardwareMap.servo.get("servo2");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        servo1.setPosition(0);
        hook2.setPosition(0);
        hook1.setPosition(1);
        servo2.setPosition(0);

        waitForStart();

       strafeRight(.25);

    }

    //Drive forwards
    public void DriveForward(double power) {

        leftFront.setPower(-power / 2 );
        leftBack.setPower(-power / 2);

        rightFront.setPower(-power / 2);
        rightBack.setPower(-power / 2);

    }

    //Drive backwards
    public void DriveBackwards(double power) {

        leftFront.setPower(power / 2);
        leftBack.setPower(power / 2);

        rightFront.setPower(power / 2);
        rightBack.setPower(power / 2);

    }

    //Turn the robot right
    public void turnRight(double power) {

        leftFront.setPower(-power / 2);
        leftBack.setPower(-power / 2);

        rightFront.setPower(power / 2);
        rightBack.setPower(power / 2);

    }

    //Turn the robot left
    public void turnLeft(double power) {

        leftFront.setPower(power / 2);
        leftBack.setPower(power / 2);

        rightFront.setPower(-power / 2);
        rightBack.setPower(-power / 2);

    }

    //Strafe the robot to the left
    public void strafeLeft(double power){
        leftFront.setPower(-power / 2);
        leftBack.setPower(power / 2);

        rightFront.setPower(power / 2);
        rightBack.setPower(-power / 2);

    }

    //Strafe the robot to the right
    public void strafeRight(double power){
        leftFront.setPower(power / 2);
        leftBack.setPower(-power / 2);

        rightFront.setPower(-power / 2);
        rightBack.setPower(power / 2);

    }

    public void stop(double power){
        leftFront.setPower(0);
        leftBack.setPower(0);

        rightFront.setPower(0);
        rightBack.setPower(0);
    }

}
