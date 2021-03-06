package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Kenny Tang 2017.
 * Permitted for use on the Round Rock High School Robotics Team
 * FTC Team #11019
 */
public class HardwareRoRoRoboat {

    //Robot Hardware
    private HardwareMap hwMap;
    private DcMotor rightFront;
    private DcMotor leftFront;
    private DcMotor rightRear;
    private DcMotor leftRear;
    private Gamepad gamepad;
    private MotorSet leftMotors;
    private MotorSet rightMotors;
    private MotorSet allMotors;
    private GamepadState gamepadState;

    //Constructor to initialize the Hardware class
    public HardwareRoRoRoboat(HardwareMap hwMap, Gamepad gamepad) {
        //Set the hardware map to the teleop's
        this.hwMap = hwMap;
        //Initializing Hardware
        leftFront = hwMap.dcMotor.get("left_front");
        leftRear = hwMap.dcMotor.get("left_rear");
        rightFront = hwMap.dcMotor.get("right_front");
        rightRear = hwMap.dcMotor.get("right_rear");
        //Initialize the motor sets
        leftMotors = new MotorSet();
        rightMotors = new MotorSet();
        allMotors = new MotorSet();
        leftMotors.addMotor(leftFront);
        leftMotors.addMotor(leftRear);
        rightMotors.addMotor(rightFront);
        rightMotors.addMotor(rightRear);
        allMotors.addMotor(leftFront);
        allMotors.addMotor(leftRear);
        allMotors.addMotor(rightFront);
        allMotors.addMotor(rightRear);
        //Setting up the hardware
        rightMotors.setDirection(DcMotorSimple.Direction.REVERSE);
        leftMotors.setDirection(DcMotorSimple.Direction.FORWARD);
        allMotors.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //Initialize the gamepad
        this.gamepad = gamepad;

    }

    //Set the power of all motors
    public void driveAllPower(double power) {
        allMotors.setPower(power);
    }

    //Set the power of the left and right motors
    public void drivePower(double powerLeft, double powerRight) {
        leftMotors.setPower(powerLeft);
        rightMotors.setPower(powerRight);
    }

    //Drive to the amount given using the power given
    public void driveEncode(int leftAmount, int rightAmount, double power) {
        leftMotors.addToPosition(leftAmount);
        rightMotors.addToPosition(rightAmount);
        allMotors.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        allMotors.setPower(power);
    }

    //Drive to the amount given lerping to the power given
    public void driveEncodeLerp(int leftAmount, int rightAmount, double power) {
        leftMotors.addToPosition(leftAmount);
        rightMotors.addToPosition(rightAmount);
        allMotors.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        double lerpPower = 0.0d;
        long lastTime = System.nanoTime();
        long curTime;
        while(lerpPower < power) {
            curTime = System.nanoTime();
            lerpPower = lerp(lerpPower, power, nanoToSeconds(curTime - lastTime));
            allMotors.setPower(lerpPower);
            lastTime = System.nanoTime();
        }
        allMotors.setPower(power);
    }

    //Stop all motors and reset the encoder
    public void stopAndReset() {
        allMotors.setPower(0.0d);
        allMotors.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    //Reverse the direction of the motors
    public void reverseDirections() {
        allMotors.reverseDirections();
    }

    //Convert nanoseconds to seconds
    private double nanoToSeconds(long nanotime) {
        return nanotime / 1000000000.0d;
    }

    //Lerp between an initial value and a target value with a ∆t
    private double lerp(double initial, double target, double deltaTime) {
        return (1 - deltaTime) * initial + deltaTime * target;
    }

    //Getters
    public MotorSet getLeftMotors() {
        return leftMotors;
    }

    public MotorSet getRightMotors() {
        return rightMotors;
    }
}
