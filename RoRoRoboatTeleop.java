package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.util.GamepadKey;
import org.firstinspires.ftc.teamcode.util.GamepadState;
import org.firstinspires.ftc.teamcode.util.HardwareRoRoRoboat;

/**
 * Kenny Tang 2017.
 */
@TeleOp
public class RoRoRoboatTeleop extends OpMode {

    private HardwareRoRoRoboat robot;
    private GamepadState gamepad;
    private static final double DEADZONE = .01d;

    @Override
    public void init() {
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        try {
            robot = new HardwareRoRoRoboat(hardwareMap, gamepad1, telemetry);
            gamepad = robot.getGamepadState();
        } catch (Exception e) {
            telemetry.addData("Error: ", e.getCause().toString());
            telemetry.update();
        }
    }

    //Run your main code here
    @Override
    public void loop() {
        try {
        /*
         * Movement:
         * Convert joystick values to axis
         * Vertical is the triggers, bound from [-1, 1]
         * Horizontal is the x axis of the right joystick, bound from [-1, 1]
         * To translate into motor power, leftPower is always what horizontal is, but we need to multiply it by vertical
         * rightPower is just negative leftPower
         * Must check that horizontal is not 0, if it is near 0 (deadzone), then set left and right power to vertical
         */
            double vertical = gamepad.getAnalogValue(GamepadKey.rT) - gamepad.getAnalogValue(GamepadKey.lT);
            double horizontal = gamepad.getAnalogValue(GamepadKey.rSX);
            double leftPower = horizontal * vertical;
            double rightPower = -leftPower;
            if (Math.abs(horizontal) < DEADZONE) {
                leftPower = vertical;
                rightPower = vertical;
            }
            robot.lerpToPower(leftPower, rightPower);

        /*
         * Vortex Spinner
         * Bumpers control the direction, left is negative, right is positive
         */

            if (gamepad.getDigitalValue(GamepadKey.lB))
                robot.setVortexPower(1.0d);
            else if (gamepad.getDigitalValue(GamepadKey.rB))
                robot.setVortexPower(-1.0d);
            else
                robot.setVortexPower(0.0d);
            //Update the gamepad states
            gamepad.updateStates();
            telemetry.update();
        } catch (Exception e) {
            telemetry.addData("Error: ", e.getCause().toString());
            telemetry.update();
        }
    }

    @Override
    public void stop() {
        robot.stopAndReset();
    }
}
