package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveSubsystem;

public class TestCommand extends Command{
    private final DriveSubsystem driveSubsystem;
    private final double distance;
    private double encoderSetpoint;

    public TestCommand(DriveSubsystem driveSubsystem, double distance) {
        this.driveSubsystem = driveSubsystem;
        this.distance = distance;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        encoderSetpoint = driveSubsystem.getAverageEncoderDistance() + distance;
        System.out.println("Drive start");
    }

    @Override
    public void execute() {
        driveSubsystem.setMotors(.5, .5);
    }

    @Override
    public void end(boolean interrupted){
        driveSubsystem.setMotors(0, 0);
        System.out.println("Drive ended");
    }

    @Override
    public boolean isFinished() {
        if (driveSubsystem.getAverageEncoderDistance()  > encoderSetpoint){
            return true;
        }
        else {
            return false;
        }
    }
}
