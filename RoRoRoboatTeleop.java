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
        double vertical = gamepad.getAnalogValue(GamepadKey.rT) - gamepad.getAnalogValue(GamepadKey.lT);
        double horizontal = gamepad.getAnalogValue(GamepadKey.rSX);
        robot.lerpToPower(vertical, vertical);
        //Update the gamepad states
        gamepad.updateStates();
    }

    @Override
    public void stop() {
        robot.stopAndReset();
    }
}
