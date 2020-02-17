/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
//import com.qualcomm.robotcore.util.Range;

/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="Chicken Nugget", group="Iterative Opmode")
//@Disabled
public class chickenNugget extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFront = null;
    private DcMotor rightFront = null;
    private DcMotor leftBack = null;
    private DcMotor rightBack = null;
    private DcMotor arm = null;
    Servo servo1 = null;
    Servo servo2 = null;
    Servo servo3 = null;
    Servo hook1 = null;
    Servo hook2 = null;
    Servo gripper = null;


    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        leftFront  = hardwareMap.get(DcMotor.class, "left_front");
        rightFront = hardwareMap.get(DcMotor.class, "right_front");
        leftBack = hardwareMap.get(DcMotor.class, "left_back");
        rightBack = hardwareMap.get(DcMotor.class, "right_back");
        arm = hardwareMap.get(DcMotor.class, "arm");
        servo1 = hardwareMap.servo.get("servo1");
        servo2 = hardwareMap.servo.get("servo2");
        servo3 = hardwareMap.servo.get("servo3");
        hook1 = hardwareMap.servo.get("hook1");
        hook2 = hardwareMap.servo.get("hook2");
        gripper = hardwareMap.servo.get("gripper");


        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        arm.setDirection(DcMotor.Direction.FORWARD);
        servo1.setPosition(0);
        servo2.setPosition(0);
        servo3.setPosition(0);
        hook1.setPosition(0);
        hook2.setPosition(0);
        gripper.setPosition(0);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        // Setup a variable for each drive wheel to save power level for telemetry
        //double frontLeftPower;
        //double rearLeftPower;
        //double frontRightPower;
        //double rearRightPower;


        // Choose to drive using either Tank Mode, or POV Mode
        // Comment out the method that's not used.  The default below is POV.

        // POV Mode uses left stick to go forward, and right stick to turn.
        // - This uses basic math to combine motions and is easier to drive straight.
        double drive = gamepad1.left_stick_y /2;
        double turn  = gamepad1.right_stick_x/2;
        double chicken = gamepad2.right_stick_x/1.5;
        double frontLeftPower;
        double rearLeftPower;
        double rearRightPower;
        double frontRightPower;

        //double drive = gamepad1.left_stick_y * 0.5;
        //double turn  = gamepad1.right_stick_x;

        // Tank Mode uses one stick to control each wheel.
        // - This requires no math, but it is hard to drive forward slowly and keep straight.
         //leftPower  = -gamepad1.left_stick_y ;
         //rightPower = -gamepad1.right_stick_y ;

        frontLeftPower = drive - turn;
        rearLeftPower = drive - turn;
        frontRightPower = drive + turn;
        rearRightPower = drive + turn;


        frontLeftPower += -gamepad1.right_trigger;
        rearLeftPower += gamepad1.right_trigger;
        rearRightPower += -gamepad1.right_trigger;
        frontRightPower += gamepad1.right_trigger;

        frontLeftPower += gamepad1.left_trigger;
        rearLeftPower += -gamepad1.left_trigger;
        frontRightPower += -gamepad1.left_trigger;
        rearRightPower += gamepad1.left_trigger;

        //rightBack.setPower(rearRightPower);
        //leftBack.setPower(rearLeftPower);
        //leftFront.setPower(frontLeftPower);
        //rightFront.setPower(frontRightPower);

        // Send calculated power to wheels
        rightFront.setPower(frontRightPower);
        rightBack.setPower(rearRightPower);
        leftBack.setPower(rearLeftPower);
        leftFront.setPower(frontLeftPower);
        arm.setPower(chicken);


        if(gamepad1.dpad_up) {
            servo1.setPosition(1);
        }
        else if (gamepad1.dpad_down)  {
            servo1.setPosition(0);
        }

        //if(gamepad1.right_trigger != 0 || gamepad1.left_trigger != 0)
        //{
            //jack.setStrafeSpeed(gamepad1.left_trigger - gamepad1.right_trigger);
        //}
        if(gamepad2.right_bumper){
            gripper.setPosition(1);
        }
        else if (gamepad2.left_bumper){
            gripper.setPosition(0);
        }


        if(gamepad1.a) {
            servo2.setPosition(1);
        }
        else if (gamepad1.b)  {
            servo2.setPosition(0);
        }

        //next
        if(gamepad1.x) {
            servo3.setPosition(1);
        }
        else if (gamepad1.y)  {
            servo3.setPosition(0);
        }

        if(gamepad1.right_bumper){
            hook1.setPosition(1);
            hook2.setPosition(0);

        } else if (gamepad1.left_bumper){

            hook1.setPosition(0);
            hook2.setPosition(1);
        }

        // Show the elapsed game time and wheel power.
        //telemetry.addData("Status", "Run Time: " + runtime.toString());
        //telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
        telemetry.addData("Motors", "front left (%.2f), front right (%.2f)  rear right (%.2f), rear right (%.2f) ",
                frontLeftPower, frontRightPower, rearLeftPower, rearRightPower);
        telemetry.addData("Status", "Run Time: " + runtime.toString());
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
