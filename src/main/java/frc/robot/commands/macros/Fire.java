/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands.macros;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.commands.pneumatics.MoveDoubleSolenoid;

public class Fire extends CommandGroup {

  /**
   * Fire a t-shirt.
   */
  public Fire() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.
    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.
    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
    if (Robot.pneumaticsSubsystem.plunger.get() != Value.kReverse) {
      // Seal firing chamber
      addSequential(new MoveDoubleSolenoid(Robot.pneumaticsSubsystem.plunger, Value.kReverse));

      // Wait a bit for the firing chamber to seal
      addSequential(new WaitCommand(1.5));
    }

    // Fire T-shirt
    addSequential(new MoveDoubleSolenoid(Robot.pneumaticsSubsystem.firingMechanism, Value.kForward));

    // Wait a bit for the t-shirt to get fired
    addSequential(new WaitCommand(0.5));

    // Stop releasing air
    addSequential(new MoveDoubleSolenoid(Robot.pneumaticsSubsystem.firingMechanism, Value.kReverse));

    // Open chamber again
    addParallel(new MoveDoubleSolenoid(Robot.pneumaticsSubsystem.plunger, Value.kForward));
  }
}
