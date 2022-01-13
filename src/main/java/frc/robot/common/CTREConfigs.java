package frc.robot.common;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;
import com.ctre.phoenix.sensors.SensorTimeBase;

public class CTREConfigs {
    
    public TalonFXConfiguration swerveDriveConfig;
    public TalonFXConfiguration swerveSteerConfig;
    public CANCoderConfiguration swerveCancoderConfig;

    public CTREConfigs(){
        swerveDriveConfig = new TalonFXConfiguration();
        swerveSteerConfig = new TalonFXConfiguration();
        swerveCancoderConfig = new CANCoderConfiguration();

        swerveDriveConfig.initializationStrategy = SensorInitializationStrategy.BootToZero;
        swerveDriveConfig.slot0.kP = Constants.Swerve.kDriveKP;
        swerveDriveConfig.slot0.kI = Constants.Swerve.kDriveKI;
        swerveDriveConfig.slot0.kD = Constants.Swerve.kDriveKD;
        swerveDriveConfig.supplyCurrLimit = new SupplyCurrentLimitConfiguration(
            true,
            Constants.Swerve.kDriveContinuousCurrentLimit,
            Constants.Swerve.kDrivePeakCurrentLimit,
            Constants.Swerve.kDrivePeakCurrentDuration
        );

        swerveSteerConfig.initializationStrategy = SensorInitializationStrategy.BootToZero;
        swerveSteerConfig.slot0.kP = Constants.Swerve.kSteerKP;
        swerveSteerConfig.slot0.kI = Constants.Swerve.kSteerKI;
        swerveSteerConfig.slot0.kD = Constants.Swerve.kSteerKD;
        swerveSteerConfig.supplyCurrLimit = new SupplyCurrentLimitConfiguration(
            true,
            Constants.Swerve.kSteerContinuousCurrentLimit,
            Constants.Swerve.kSteerPeakCurrentLimit,
            Constants.Swerve.kSteerPeakCurrentDuration
        );

        swerveCancoderConfig.absoluteSensorRange = AbsoluteSensorRange.Unsigned_0_to_360;
        swerveCancoderConfig.initializationStrategy = SensorInitializationStrategy.BootToAbsolutePosition;
        swerveCancoderConfig.sensorTimeBase = SensorTimeBase.PerSecond;
    }
}