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

@Autonomous(name="Ahhaha Blue")
public class Ahhaha extends LinearOpMode {
    private DcMotor leftFront = null;
    private DcMotor rightFront = null;
    private DcMotor leftBack = null;
    private DcMotor rightBack = null;
    Servo snowPlow = null;
    Servo paddle1 = null;
    Servo paddle2 = null;
    Servo dumper = null;
    //Sensor color = null;

    @Override
    public void runOpMode() throws InterruptedException {
        leftFront  = hardwareMap.get(DcMotor.class, "left_front");
        rightFront = hardwareMap.get(DcMotor.class, "right_front");
        leftBack = hardwareMap.get(DcMotor.class, "left_back");
        rightBack = hardwareMap.get(DcMotor.class, "right_back");
        snowPlow = hardwareMap.servo.get("snowPlow");
        paddle1 = hardwareMap.servo.get("paddle1");
        paddle2 = hardwareMap.servo.get("paddle2");
        dumper = hardwareMap.servo.get("dumper");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        snowPlow.setPosition(0);
        paddle1.setPosition(0);
        paddle2.setPosition(0);
        dumper.setPosition(0);

        waitForStart();

        //drive back a little and strafe left
        DriveBackwards(.35);
        Thread.sleep(1000);
        strafeLeft(.62);
        Thread.sleep(1000);

        //Drive back to foundation
        DriveBackwards(.8);
        Thread.sleep(1000);
        stop(1);
        Thread.sleep(1000);

        //grab foundation and go forwards
        paddle1.setPosition(1);
        paddle2.setPosition(1);
        Thread.sleep(1000);
        DriveForward(.75);
        Thread.sleep(1000);
        stop(1);
        Thread.sleep(1000);

        //lift the servo up
        paddle1.setPosition(0);
        Thread.sleep(1000);
        paddle2.setPosition(0);
        Thread.sleep(1000);
        stop(1);

        //go sideways to the right
        strafeRight(1.2);
        Thread.sleep(1000);

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
