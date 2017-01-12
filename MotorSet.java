package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

import java.util.HashSet;
import java.util.Set;

/**
 * Kenny Tang 2017.
 */
public class MotorSet implements DcMotor{

    private Set<DcMotor> motorSet;
    private DcMotor defaultMotor;

    public MotorSet() {
        this.motorSet = new HashSet<>();
    }

    public boolean addMotor(DcMotor motor){
        //Set the default motor to the first motor added
        if(defaultMotor != null)
            defaultMotor = motor;
        return motorSet.add(motor);
    }

    public boolean removeMotor(DcMotor motor){
        return motorSet.remove(motor);
    }

    @Override
    public void setMaxSpeed(int encoderTicksPerSecond) {
        for(DcMotor motor : motorSet)
            motor.setMaxSpeed(encoderTicksPerSecond);
    }

    @Override
    public int getMaxSpeed() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getMaxSpeed() != motor.getMaxSpeed())
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getMaxSpeed();
    }

    @Override
    public DcMotorController getController() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getController().equals(motor.getController()))
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getController();
    }

    @Override
    public int getPortNumber() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getPortNumber() != motor.getPortNumber())
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getPortNumber();
    }

    @Override
    public void setZeroPowerBehavior(ZeroPowerBehavior zeroPowerBehavior) {
        for(DcMotor motor : motorSet)
            motor.setZeroPowerBehavior(zeroPowerBehavior);
    }

    @Override
    public ZeroPowerBehavior getZeroPowerBehavior() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getZeroPowerBehavior().equals(motor.getZeroPowerBehavior()))
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getZeroPowerBehavior();
    }

    @Override
    @Deprecated
    public void setPowerFloat() {
        for(DcMotor motor : motorSet)
            motor.setPowerFloat();
    }

    @Override
    public boolean getPowerFloat() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getPowerFloat() != motor.getPowerFloat())
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getPowerFloat();
    }

    @Override
    public void setTargetPosition(int position) {
        for(DcMotor motor : motorSet)
            motor.setTargetPosition(position);
    }

    @Override
    public int getTargetPosition() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getTargetPosition() != motor.getTargetPosition())
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getTargetPosition();
    }

    @Override
    public boolean isBusy() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.isBusy() != motor.isBusy())
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.isBusy();
    }

    @Override
    public int getCurrentPosition() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getCurrentPosition() != motor.getCurrentPosition())
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getCurrentPosition();
    }

    @Override
    public void setMode(RunMode mode) {
        for(DcMotor motor : motorSet)
            motor.setMode(mode);
    }

    @Override
    public RunMode getMode() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getMode().equals(motor.getMode()))
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getMode();
    }

    @Override
    public void setDirection(Direction direction) {
        for(DcMotor motor : motorSet)
            motor.setDirection(direction);
    }

    @Override
    public Direction getDirection() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getDirection().equals(motor.getDirection()))
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getDirection();
    }

    @Override
    public void setPower(double power) {
        for(DcMotor motor : motorSet)
            motor.setPower(power);
    }

    @Override
    public double getPower() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getPower() != motor.getPower())
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getPower();
    }

    @Override
    public Manufacturer getManufacturer() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getManufacturer().equals(motor.getManufacturer()))
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getManufacturer();
    }

    @Override
    public String getDeviceName() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getDeviceName().equals(motor.getDeviceName()))
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getDeviceName();
    }

    @Override
    public String getConnectionInfo() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getConnectionInfo().equals(motor.getConnectionInfo()))
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getConnectionInfo();
    }

    @Override
    public int getVersion() {
        for(DcMotor motor : motorSet)
            if(defaultMotor.getVersion() != motor.getVersion())
                throw new IllegalStateException("Motors are not synced correctly");
        return defaultMotor.getVersion();
    }

    @Override
    public void resetDeviceConfigurationForOpMode() {
        for(DcMotor motor : motorSet)
            motor.resetDeviceConfigurationForOpMode();
    }

    @Override
    public void close() {
        for(DcMotor motor : motorSet)
            motor.close();
    }
}
