package org.firstinspires.ftc.teamcode.teamcode.manual;

import android.os.Build;



import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="OurBot", group="Manual")
public class OurBot extends OpMode {

    private static final float TEST_MOTOR_POW = 1;
    /* Declare OpMode members. */
    HardwareBot robot; // use the class created to define a Pushbot's hardware
    // could also use HardwarePushbotMatrix class.

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot = new HardwareBot(hardwareMap);
        try {
            robot.mecanum();
            robot.vaughn();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                robot.vaughn.ifPresent(vaughn -> {
                    vaughn.setPosition(1);
                });
            }
            robot.block();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                robot.block.ifPresent(block -> {
                    block.setPosition(0);
                });
            }
            robot.arm();
            robot.armA();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                robot.armA.ifPresent(armA -> {
                    armA.setPosition(0);
                });
            }
        } catch (NullPointerException e) {
            telemetry.addData("NPE", e.toString());
        }


        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop(){
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {};

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */


    public void loop() {
        ManualUtil.drive(robot, gamepad1);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            robot.block.ifPresent(block -> {
                if (gamepad1.dpad_down) {
                    block.setPosition(1.0);
                } else if (gamepad1.dpad_up) {
                    block.setPosition(0.0);
                }
            });
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            robot.vaughn.ifPresent(vaughn -> {
                if (gamepad1.left_bumper) {
                vaughn.setPosition(.8);
                } else if (gamepad1.right_bumper) {
                vaughn.setPosition(0);
            }
            });
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            robot.arm.ifPresent(arm -> {
                arm.setPower((gamepad1.right_trigger - gamepad1.left_trigger)*4/5);
            });
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            robot.winch.ifPresent(winch -> {
                winch.setPower((gamepad2.left_trigger - gamepad2.right_trigger ) / 10);
            });
        }

        robot.allTelemetry(telemetry);
        telemetry.update();
        robot.allTelemetry(telemetry);
        telemetry.update();

    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        for (DcMotor motor : robot.motors) {
            motor.setPower(0);
        }
    }
}


