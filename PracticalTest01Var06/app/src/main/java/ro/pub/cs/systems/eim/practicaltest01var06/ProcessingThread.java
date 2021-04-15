package ro.pub.cs.systems.eim.practicaltest01var06;

import java.util.Date;
import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.util.Log;



public class ProcessingThread extends Thread {

    private Context context = null;
    private boolean isRunning = true;

    private Random random = new Random();

    private double scor;

    public ProcessingThread(Context context, double scor ) {
        this.context = context;
        this.scor = scor;
    }

    @Override
    public void run() {
        while (isRunning) {
            sendMessage();
            sleep();
        }
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.putExtra("MESSAGE",
                new Date(System.currentTimeMillis()) + "VICTORY");
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}