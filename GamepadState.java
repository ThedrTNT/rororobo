package org.firstinspires.ftc.teamcode;

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
        gamepadStates.put(GamepadKey.a, gamepad.a);
    }

    public boolean getDigitalKey(GamepadKey gamepadKey) {
        return (boolean) gamepadStates.get(gamepadKey);
    }

    public double getAnalogKey(GamepadKey gamepadKey) {
        return (double) gamepadStates.get(gamepadKey);
    }

    public double isHeld(GamepadKey gamepadKey) {
        return (boolean) gamepadStates.get(gamepadKey) && (boolean) lastGamepadStates.get(gamepadKey)
    }
}
