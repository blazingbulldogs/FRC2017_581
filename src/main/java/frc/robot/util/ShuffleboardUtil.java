package frc.robot.util;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;

/**
 * Expose helpful Shuffleboard properties and methods.
 */
public final class ShuffleboardUtil {
  /** Current time used to help distinguish the name of the Shuffleboard tab. */
  private static final String currentTime = DateTimeFormatter
    .ofPattern("hh:mm:ss")
    .format(ZonedDateTime.now())
    .toString();

  /** String used to identify this Shuffleboard tab from duplicates. */
  private static String tabDistinguisher = Config.id + " " + currentTime;

  /** Shuffleboard tab used for logging. */
  public static final ShuffleboardTab tab = Shuffleboard.getTab(tabDistinguisher);

  /** Graph of joystick values in the order of `x`, `y`, `z`. */
  private final NetworkTableEntry joystickData = tab
    .add("Joystick Output", new double[] { 0, 0, 0 })
    .withPosition(11, 0)
    .withSize(2, 2)
    .withWidget(BuiltInWidgets.kGraph)
    .getEntry();

  /** Shuffleboard number bar for the joystick `x` value */
  private final NetworkTableEntry joyX = tab
    .add("Raw Joystick X", 0)
    .withPosition(0, 2)
    .withWidget(BuiltInWidgets.kNumberBar)
    .getEntry();

  /** Shuffleboard number bar for the joystick `y` value */
  private final NetworkTableEntry joyY = tab
    .add("Negative Joystick Y", 0)
    .withPosition(0, 3)
    .withWidget(BuiltInWidgets.kNumberBar)
    .getEntry();

  /** Shuffleboard number bar for the joystick `z` value */
  private final NetworkTableEntry joyZ = tab
    .add("Raw Joystick Z", 0)
    .withPosition(0, 4)
    .withWidget(BuiltInWidgets.kNumberBar)
    .getEntry();

  /**
   * Log joystick values using a graph and number bars on Shuffleboard.
   *
   * @param x X-axis value to log
   * @param y Y-axis value to log
   * @param z Z-axis value to log
   */
  public final void logJoystickValues(double x, double y, double z) {
    double[] joystickValues = new double[] { x, y, z };

    this.joystickData.setDoubleArray(joystickValues);

    this.joyX.setDouble(x);
    this.joyY.setDouble(y);
    this.joyZ.setDouble(z);
  }
}
