// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/
// package frc.robot.commands.pneumatics;

// import edu.wpi.first.wpilibj.command.InstantCommand;
// import edu.wpi.first.wpilibj.DoubleSolenoid;
// import frc.robot.Robot;

// /**
//  * Instant command to move a double solenoid.
//  */
// public class MoveDoubleSolenoid extends InstantCommand {
//   /** The solenoid to move. */
//   private DoubleSolenoid targetSolenoid;

//   /** The value that the double solenoid should be set to. */
//   private DoubleSolenoid.Value newValue;

//   /**
//    * Creates the command to set the double solenoid to a value.
//    * @param solenoid The solenoid that should be moved
//    * @param value The value that the double solenoid should be set to
//    */
//   public MoveDoubleSolenoid(DoubleSolenoid solenoid, DoubleSolenoid.Value value) {
//     super();
//     requires(Robot.pneumaticsSubsystem);

//     this.targetSolenoid = solenoid;
//     this.newValue = value;
//   }

//   @Override
//   protected void initialize() {
//     this.targetSolenoid.set(this.newValue);
//   }
// }
