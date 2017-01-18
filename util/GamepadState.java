package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.HashMap;
import java.util.Map;

/**
 * Kenny Tang 2017.
 */
public class GamepadState {

    private Gamepad gamepad;
    private Map<GamepadKey, Object> gamepadStates;
    private Map<GamepadKey, Object> lastGamepadStates;

    public GamepadState(Gamepad gamepad) {
        this.gamepad = gamepad;
        gamepadStates = new HashMap<>();
        lastGamepadStates = new HashMap<>();
    }

    public void updateStates() {
        lastGamepadStates.putAll(gamepadStates);
        gamepadStates.put(GamepadKey.a, gamepad.a);
        gamepadStates.put(GamepadKey.b, gamepad.b);
        gamepadStates.put(GamepadKey.x, gamepad.x);
        gamepadStates.put(GamepadKey.y, gamepad.y);
        gamepadStates.put(GamepadKey.lB, gamepad.left_bumper);
        gamepadStates.put(GamepadKey.lT, gamepad.left_trigger);
        gamepadStates.put(GamepadKey.rB, gamepad.right_bumper);
        gamepadStates.put(GamepadKey.rT, gamepad.right_trigger);
        gamepadStates.put(GamepadKey.up, gamepad.dpad_up);
        gamepadStates.put(GamepadKey.down, gamepad.dpad_down);
        gamepadStates.put(GamepadKey.left, gamepad.dpad_left);
        gamepadStates.put(GamepadKey.right, gamepad.dpad_right);
        gamepadStates.put(GamepadKey.lSX, gamepad.left_stick_x);
        gamepadStates.put(GamepadKey.lSY, gamepad.left_stick_y);
        gamepadStates.put(GamepadKey.rSX, gamepad.right_stick_x);
        gamepadStates.put(GamepadKey.rSY, gamepad.right_stick_y);
    }

    public boolean getDigitalValue(GamepadKey gamepadKey) {
        return (boolean) gamepadStates.get(gamepadKey);
    }

    public double getAnalogValue(GamepadKey gamepadKey) {
        return (double) gamepadStates.get(gamepadKey);
    }

    public boolean isHeld(GamepadKey gamepadKey) {
        return (boolean) gamepadStates.get(gamepadKey) && (boolean) lastGamepadStates.get(gamepadKey);
    }

    public boolean isToggled(GamepadKey gamepadKey) {
        return (boolean) gamepadStates.get(gamepadKey) && !(boolean) lastGamepadStates.get(gamepadKey);
    }
}
