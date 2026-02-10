package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;

public final class Constants {
    public static final int kDriverControllerPort = 0;
    public static final TalonFX intakeMotorID = new TalonFX(0);
    public static final TalonFX deployMotorID = new TalonFX(1);
    public static final double intakePosition = 10;
    public static final double idlePosition = 0;
}
