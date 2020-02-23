package org.firstinspires.ftc.teamcode.teamcode.general;

/**
 * Created by wjackson on 2/20/2018.
 */

public interface Call {
    Call empty = new Call() {
        @Override
        public void run() {}
    };

    void run();
}
