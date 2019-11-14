package frc.robot.util;

import edu.wpi.first.wpilibj.Filesystem;
import frc.robot.util.controls.ports.joysticks.LeftJoystick;
import io.github.cdimascio.dotenv.Dotenv;

/**
 * Stores the configuration for the robot.
 */
public final class Config {
  /** The loader for getting environnment variables from the system or the `.env` file. */
  private static final Dotenv dotenv = Dotenv.configure().directory(Filesystem.getDeployDirectory() + "/.env").load();

  /** ID of the robot. */
  public static final String id = dotenv.get("ROBOT_IDENTIFIER");

  /** The value of the exponent used to scale joystick values. */
  public static final float joystickValueExponent = Float.parseFloat(dotenv.get("JOYSTICK_VALUE_EXPONENT"));

  /** Which joystick from the controller should be used for driving. */
  public static final LeftJoystick preferredDrivingJoystick = new LeftJoystick();
}
