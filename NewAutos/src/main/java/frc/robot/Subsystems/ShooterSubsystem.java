package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ShooterSubsystem extends SubsystemBase {

private final VictorSP m_launchMotor = new VictorSP(0);
private final VictorSP m_kickMotor = new VictorSP(0);


public Command intakeCommand() {
    return runOnce(() -> m_launchMotor.set(-1.0))
        .andThen(run(() -> m_kickMotor.set(-1.0)));
}

public Command holdCommand() {
     return runOnce(() -> m_launchMotor.set(0))
        .andThen(run(() -> m_kickMotor.set(0)));
}

public Command spinUpCommand() {
    return runOnce(() -> m_launchMotor.set(5.0))
        .andThen(run(() -> m_kickMotor.set(0)));
}

public Command launchCommand() {
      return runOnce(() -> m_launchMotor.set(5.0))
        .andThen(run(() -> m_kickMotor.set(1)));
}

}