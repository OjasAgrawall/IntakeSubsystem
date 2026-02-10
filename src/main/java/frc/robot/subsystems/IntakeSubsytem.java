// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants;
import frc.robot.subsystems.states.*;

public class IntakeSubsytem extends SubsystemBase {
    // we have two motors
    // one motor deploys and brings in the enitre intak
    // one runs the intake
    // we need to spin deploymotor to two presets, out and in
    // we need to spin intakemotor two directions, intake and outtake
    private TalonFX intakeMotor;
    private TalonFX deployMotor;

    private IntakeState state;

    public IntakeSubsytem() {
        intakeMotor = Constants.intakeMotorID;
        deployMotor = Constants.deployMotorID;

        state = IntakeState.IDLE;
    }

    public Command setIntakeCommand(double position) {
        return runOnce(() -> {
            setIntakePosition(position);
        });
    }

    public Command spinIntakeCommand(double speed) {
        return runOnce(() -> {
            spinIntake(speed);
        });
    }

    public void setIntakePosition(double position) {
        PositionDutyCycle request = new PositionDutyCycle(position);
        deployMotor.setControl(request);
    }

    public void spinIntake(double speed) {
        DutyCycleOut request = new DutyCycleOut(speed);
        intakeMotor.setControl(request);
    }

    public void setState(IntakeState state) {
        this.state = state;
    }

    public IntakeState getState() {
        return state;
    }

    public Command setStateCommand(IntakeState state) {
        return this.runOnce(() -> setState(state));
    }

    public void handleStates(){
        switch (state) {
            case IDLE:
            case INTAKE:
            case OUTTAKE:
                setIntakeCommand(state.getIntakePosition());
                spinIntakeCommand(state.getIntakeRotation());
                break;
        
            default:
                setIntakeCommand(0);
                spinIntakeCommand(0);
        }
    }

    @Override
    public void periodic() {
        handleStates();
    }

    @Override
    public void simulationPeriodic() {
    }
}
