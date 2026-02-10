package frc.robot.subsystems.states;

public enum IntakeState {
  IDLE(
      IntakeConstants.INTAKE_IDLE,
      IntakeConstants.INTAKE_IDLE),

  INTAKE(
      IntakeConstants.INTAKE_OUT,
      IntakeConstants.INTAKE),

  OUTTAKE(
      IntakeConstants.INTAKE_OUT,
      IntakeConstants.OUTTAKE);

  private double intakePosition;
  private double intakeRotation;

  IntakeState(double intakePosition, double intakeRotation) {
    this.intakePosition = intakePosition;
    this.intakeRotation = intakeRotation;
  }

  public double getIntakePosition() {
    return intakePosition;
  }

  public double getIntakeRotation() {
    return intakeRotation;
  }
}
