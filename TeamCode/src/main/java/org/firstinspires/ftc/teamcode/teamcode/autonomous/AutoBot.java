package org.firstinspires.ftc.teamcode.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.teamcode.general.GeneralUtil;
import org.firstinspires.ftc.teamcode.teamcode.manual.HardwareBot;

// Declare that the OpMode is Autonomous and is named AutoBot
@Autonomous(name="AutoBot", group="Auto")
public class AutoBot extends Auto {

    @Override
    public void prep() throws InterruptedException {
        robot = new HardwareBot(hardwareMap);

        robot.mecanum();

        robot.arm();

        robot.block();
    }

    @Override
    public void run() throws InterruptedException {
        ColorSensor sensorColor = hardwareMap.get(ColorSensor.class, "sensor_color_distance");
        DcMotor[] motors = GeneralUtil.optArray(robot.fl, robot.fr, robot.bl, robot.br);


        double[] northeast = GeneralUtil.polarMecanum(45, 1);
        double[] southeast = GeneralUtil.polarMecanum(-45, 1);
        double[] southwest = GeneralUtil.polarMecanum(180 + 45, 1);
        double[] northwest = GeneralUtil.polarMecanum(180 - 45, 1);
        double[] north = GeneralUtil.polarMecanum(0, 1);
        double[] south = GeneralUtil.polarMecanum(180, 1);
        double[] east = GeneralUtil.polarMecanum(90, 1);
        double[] west = GeneralUtil.polarMecanum(270, 1);


    }
}

