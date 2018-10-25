package org.usfirst.frc.team581.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team581.subsystems.Drive;
import org.usfirst.frc.team581.subsystems.Pneumatics;
import org.usfirst.frc.team581.subsystems.Turret;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
  // final String defaultAuto = "Default";
  // final String customAuto = "My Auto";
  // String autoSelected;
  // SendableChooser<String> chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  public static DriverControl driverControl;
  public static final Drive drive = new Drive();
  public static final Turret turret = new Turret();
  public static final Pneumatics pneumatics = new Pneumatics();

  /**
   * Run when the robot is initialized.
   */
  public void robotInit() {
    // chooser.addDefault("Default Auto", defaultAuto);
    // chooser.addObject("My Auto", customAuto);
    // SmartDashboard.putData("Auto choices", chooser);
    driverControl = new DriverControl();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString line to get the
   * auto name from the text box below the Gyro. You can add additional auto modes
   * by adding additional comparisons to the switch structure below with
   * additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */

  /*
   * public void autonomousInit() { autoSelected = chooser.getSelected(); //
   * autoSelected = SmartDashboard.getString("Auto Selector", // defaultAuto);
   * System.out.println("Auto selected: " + autoSelected); }
   */

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during operator control.
   */
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    // if (autonomousCommand != null) autonomousCommand.cancel();
    Scheduler.getInstance().removeAll();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    LiveWindow.run();
  }
}
