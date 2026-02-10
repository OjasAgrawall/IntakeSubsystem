package frc.robot;

import frc.robot.subsystems.IntakeSubsytem;
import frc.robot.subsystems.states.IntakeState;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
    private final IntakeSubsytem IntakeSubsytem = new IntakeSubsytem();
    private final CommandXboxController m_driverController = new CommandXboxController(Constants.kDriverControllerPort);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        m_driverController
            .b()
            .onTrue(IntakeSubsytem.setStateCommand(IntakeState.INTAKE))
            .onFalse(IntakeSubsytem.setStateCommand(IntakeState.IDLE));

        m_driverController
            .a()
            .onTrue(IntakeSubsytem.setStateCommand(IntakeState.OUTTAKE))
            .onFalse(IntakeSubsytem.setStateCommand(IntakeState.IDLE));
    }

    // public Command getAutonomousCommand() {

    // }
}
