// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants;

public class IntakeSubsytem extends SubsystemBase {
    // we have two motors
    // one motor deploys and brings in the enitre intak
    // one runs the intake
    // we need to spin deploymotor to two presets, out and in
    // we need to spin intakemotor two directions, intake and outtake
    private TalonFX intakeMotor;
    private TalonFX deployMotor;

    public IntakeSubsytem() {
        intakeMotor = Constants.intakeMotor;
        deployMotor = Constants.deployMotor;
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

    public Command stopIntake() {
        return runOnce(() -> {
            stopIntakeMotor();
        });
    }

    // this can be used to create the presets
    public void setIntakePosition(double position) {
        // what is the difference
        // intakeMotor.setPosition(position);
        deployMotor.setControl(new PositionDutyCycle(position));
    }

    public void spinIntake(double speed) {
        intakeMotor.set(speed);
    }

    public void stopIntakeMotor() {
        intakeMotor.stopMotor();
    }

    public boolean exampleCondition() {
        return false;
    }

    @Override
    public void periodic() {
    }

    @Override
    public void simulationPeriodic() {
    }
}
