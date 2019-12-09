package org.firstinspires.ftc.teamcode;

import android.hardware.Sensor;
//driscoll is the zodiac killer. no fucking way!!!! What!!! noooo!!! But he is my niBBa, how? I like cokeane.
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import android.hardware.Sensor;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 /**
 * Created by colethompson on 10/27/17.
 */

@Autonomous(name="Ahhaha")
public class Ahhaha extends LinearOpMode {
    DcMotor leftMotor = null;
    DcMotor rightMotor = null;
    //DcMotor leftMotorBack = null;
    //DcMotor rightMotorBack = null;
    //DcMotor glyphMotor = null;
    //DcMotor armMotor = null;

    Servo dumper =null;
    Servo paddle = null;
    Servo snowPlow = null;

    @Override
    public void runOpMode() throws InterruptedException {
        //frontR = hardwareMap.dcMotor.get("frontR");
        //frontL = hardwareMap.dcMotor.get("frontL");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        //leftMotorBack = hardwareMap.dcMotor.get("leftMotorBack");
        //rightMotorBack = hardwareMap.dcMotor.get("rightMotorBack");
        //glyphMotor = hardwareMap.dcMotor.get("glyphMotor");
        //snowPlow = hardwareMap.servo.get("snowPlow");
        dumper = hardwareMap.servo.get("dumper");
        paddle = hardwareMap.servo.get("paddle");
        snowPlow = hardwareMap.servo.get("snowPlow");
        //armMotor.setPower(0);
        //armServo1.setPosition(0);
        //armServo2.setPosition(0);
        waitForStart();

        //armServo2.setPosition(1);
        //armMotor.setPower(-1);
        /*Thread.sleep(3700);
        //armMotor.setPower(0);
        DriveForward(0);
        Thread.sleep(1000);

        turnRight(.5);
        Thread.sleep(2050);
        DriveForward(0);
        Thread.sleep(1000);

        DriveForward(.33);
        Thread.sleep(1200);
        DriveForward(0);
        Thread.sleep(1000);
         */

        //position to get block
        DriveForward(.5);
        Thread.sleep(1000);
        turnRight(.2);
        Thread.sleep(1000);
        DriveForward(.5);
        Thread.sleep(1000);
        //pick up block
        snowPlow.setPosition(0);
        Thread.sleep(1000);
        turnLeft(.5);
        Thread.sleep(1000);
        DriveForward(0);
        Thread.sleep(1000);
        turnRight(.5);
        Thread.sleep(1000);
        DriveForward(0);
        Thread.sleep(1000);
        dumper.setPosition(-1);

        //park over center line
        Thread.sleep(1000);
        DriveBackwards(0);

    }

    public void DriveForward(double power) {
        //frontL.setPower(power);
        //frontR.setPower(power);
        leftMotor.setPower(power);
        //glyphMotor.setPower(-1);
        //leftMotorBack.setPower(power);
        //rightMotorBack.setPower(-power);
        rightMotor.setPower(power);
    }

    public void DriveBackwards(double power) {
        //frontL.setPower(power);
        //frontR.setPower(power);
        //glyphMotor.setPower(-1);
        //leftMotorBack.setPower(-power);
        leftMotor.setPower(-power);
        rightMotor.setPower(-power);
        //rightMotorBack.setPower(power);
    }

    public void turnRight(double power) {
        //glyphMotor.setPower(-1);
        //leftMotorBack.setPower(-power);
        leftMotor.setPower(power);
        rightMotor.setPower(power);
        //rightMotorBack.setPower(-power);
        //frontR.setPower(power);
        //frontL.setPower(-power);
    }


    public void turnLeft(double power) {
        //glyphMotor.setPower(-1);
        //leftMotorBack.setPower(-power);
        leftMotor.setPower(-power);
        rightMotor.setPower(-power);
        //rightMotorBack.setPower(-power);
        //frontR.setPower(power);
        //frontL.setPower(-power);
    }
}
