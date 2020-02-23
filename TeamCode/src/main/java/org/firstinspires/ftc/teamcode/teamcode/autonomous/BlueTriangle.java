package org.firstinspires.ftc.teamcode.teamcode.autonomous;

import android.os.Build;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.teamcode.general.GeneralUtil;
import org.firstinspires.ftc.teamcode.teamcode.manual.HardwareBot;

import java.util.function.Consumer;

// Declare that the OpMode is Autonomous and is named AutoBot
@Autonomous(name="BlueTriangle", group="Auto")
public class BlueTriangle extends Auto {

    static final long RTime = 1700;
    static final long ETime = 1120;
    static final long FTime = 1100;

    @Override
    public void prep() throws InterruptedException {
        robot = new HardwareBot(hardwareMap);

        robot.mecanum();
        robot.block();
        robot.arm();
        robot.vaughn();
        robot.armA();
    }

    @Override
    public void run() throws InterruptedException {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            robot.fl.ifPresent(new Consumer<DcMotor>() {
                @Override
                public void accept(DcMotor fl) {
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
                                    double[] south = new double[]{-1, -1, -1, -1};
                                    double[] north = new double[]{-0.5, -0.5, -0.5, -0.5};
                                    double[] rotate = new double[]{0.5, -0.5, 0.5, -0.5};
                                    double[] rotate2 = new double[]{-1, 1, -1, 1};
                                    robot.armA.ifPresent(new Consumer<Servo>() {
                                        @Override
                                        public void accept(Servo armA) {
                                            armA.setPosition(1);
                                        }
                                    });

                                    //actual process

                                    AutoUtil.setMotors(east, motors);
                                    BlueTriangle.this.sleep(3250);
                                    AutoUtil.stopMotors(motors);
                                    BlueTriangle.this.sleep(100);
                                    AutoUtil.setMotors(north, motors);
                                    BlueTriangle.this.sleep(250);
                                    AutoUtil.stopMotors(motors);
                                    BlueTriangle.this.sleep(100);
                                    robot.armA.ifPresent((armA-> armA.setPosition(0)));
                                    BlueTriangle.this.sleep(750);
                                    AutoUtil.setMotors(west, motors);
                                    BlueTriangle.this.sleep(300);
                                    AutoUtil.stopMotors(motors);
                                    BlueTriangle.this.sleep(100);
                                    robot.armA.ifPresent(armA-> armA.setPosition(0));
                                    AutoUtil.setMotors(west, motors);
                                    BlueTriangle.this.sleep(2700);
                                    AutoUtil.stopMotors(motors);
                                    BlueTriangle.this.sleep(100);
                                    AutoUtil.setMotors(rotate, motors);
                                    robot.armA.ifPresent(armA-> armA.setPosition(0));
                                    BlueTriangle.this.sleep(3500);
                                    AutoUtil.stopMotors(motors);
                                    BlueTriangle.this.sleep(100);
                                    AutoUtil.setMotors(east, motors);
                                    BlueTriangle.this.sleep(300);
                                    AutoUtil.stopMotors(motors);
                                    BlueTriangle.this.sleep(100);
                                    robot.armA.ifPresent(armA -> armA.setPosition(1));
                                    BlueTriangle.this.sleep(1000);
                                });
                            });
                        });
                    }
                }
            );
        }
    }
}
