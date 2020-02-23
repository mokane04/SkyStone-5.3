package org.firstinspires.ftc.teamcode.teamcode.autonomous;

import android.os.Build;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.teamcode.general.GeneralUtil;
import org.firstinspires.ftc.teamcode.teamcode.manual.HardwareBot;

// Declare that the OpMode is Autonomous and is named AutoBot
@Autonomous(name="Simpleton", group="Auto")
public class Simpleton extends Auto {


    @Override
    public void prep() throws InterruptedException {
        robot = new HardwareBot(hardwareMap);
        robot.mecanum();
    }

    @Override
    public void run() throws InterruptedException {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            robot.fl.ifPresent(fl -> {
                robot.fr.ifPresent(fr -> {
                    robot.bl.ifPresent(bl -> {
                        robot.br.ifPresent(br -> {
                            DcMotor[] motors = new DcMotor[]{fl, fr, bl, br};

                            double[] northeast = GeneralUtil.polarMecanum(45, 1);
                            double[] southeast = GeneralUtil.polarMecanum(-45, 1);
                            double[] southwest = GeneralUtil.polarMecanum(180 + 45, 1);
                            double[] northwest = GeneralUtil.polarMecanum(180 - 45, 1);
                            double[] east = new double[]{-0.5, 0.5, 0.5, -0.5};
                            double[] west = new double[]{0.5, -0.5, -0.5, 0.5};
                            double[] south = new double[]{-0.5, -0.5, -0.5, -0.5};
                            double[] north = new double[]{0.5, 0.5, 0.5, 0.5};
                            double[] rotate = new double[]{0.5, -0.5, 0.5, -0.5};
                            double[] rotate2 = new double[]{-0.5, 0.5, -0.5, 0.5};

                            
                        });
                    });
                });
            });
        }
    }
}