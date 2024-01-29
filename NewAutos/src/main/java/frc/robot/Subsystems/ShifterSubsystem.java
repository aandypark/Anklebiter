package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class ShifterSubsystem extends SubsystemBase {
    private final DoubleSolenoid m_doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 0);

   

public void up(){

     m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
      
}
public void down(){

     m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
      
}




 public Command RunPistonForwardCommand() {
        return new FunctionalCommand(
                () -> {
                    System.out.println("-----------------Starting shooter forward--------------");
                    
                    
                },
                () -> up(),
                (interrupted) -> down(),
                () ->  false, this);
    }
}


