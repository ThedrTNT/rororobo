package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.util.GamepadKey;
import org.firstinspires.ftc.teamcode.util.GamepadState;
import org.firstinspires.ftc.teamcode.util.HardwareRoRoRoboat;

/**
 * Kenny Tang 2017.
 */
public class RoRoRoboatTeleop extends OpMode {

    private HardwareRoRoRoboat robot;
    private GamepadState gamepad;
    private static final double DEADZONE = .01d;
    @Override
    public void start() {
        robot = new HardwareRoRoRoboat(hardwareMap, gamepad1);
        gamepad = new GamepadState(gamepad1);
    }

    @Override
    public void init() {
        robot.stopAndReset();
    }

    @Override
    public void init_loop() {

    }

    //Run your main code here
    @Override
    public void loop() {
        //Movement
        double vertical = gamepad.getAnalogValue(GamepadKey.rT) - gamepad.getAnalogValue(GamepadKey.lT);
        double horizontal = gamepad.getAnalogValue(GamepadKey.rSX);
        double leftPower = horizontal * vertical;
        double rightPower = -leftPower;
        if(Math.abs(horizontal) < DEADZONE) {
            leftPower = vertical;
            rightPower = vertical;
        }
        robot.lerpToPower(leftPower, rightPower);

        if(gamepad.getDigitalValue(GamepadKey.lB))
            robot.setVortexPower(1.0d);
        else if(gamepad.getDigitalValue(GamepadKey.rB))
            robot.setVortexPower(-1.0d);
        else
            robot.setVortexPower(0.0d);
        //Update the gamepad states
        gamepad.updateStates();
    }

    @Override
    public void stop() {
        robot.stopAndReset();
    }
}
