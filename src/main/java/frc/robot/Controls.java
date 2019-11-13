/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
// import frc.robot.commands.pneumatics.MoveDoubleSolenoid;
import frc.robot.util.Config;
import frc.robot.util.controls.ports.Buttons;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public final class Controls {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.
  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:
  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());
  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  public static final Joystick driveJoystick = new Joystick(RobotMap.controllerPort);
  private final JoystickButton aButton = new JoystickButton(driveJoystick, Buttons.a);
  private final JoystickButton bButton = new JoystickButton(driveJoystick, Buttons.b);

  public Controls() {
    // aButton.whenPressed(new MoveDoubleSolenoid(Robot.pneumaticsSubsystem.solenoid, Value.kForward));
    // aButton.whenReleased(new MoveDoubleSolenoid(Robot.pneumaticsSubsystem.solenoid, Value.kReverse));

    // bButton.whenPressed(new MoveDoubleSolenoid(Robot.pneumaticsSubsystem.solenoid, Value.kOff));
  }

  /**
   * Scales a value to be more precise at lower values.
   * @return Scaled value
   */

  public static double scale(double value) {
    return Math.copySign(Math.pow(value, Config.joystickValueExponent), value);
  }

  /**
   * Disable event listeners for inputs when the program is shutting down.
   */
  public void close() {
    this.aButton.close();
  }
}
