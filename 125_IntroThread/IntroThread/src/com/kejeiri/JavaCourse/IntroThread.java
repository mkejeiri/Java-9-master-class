package com.kejeiri.JavaCourse;

import javafx.scene.layout.Priority;

public class IntroThread {

    public static void main(String[] args) {
        System.out.println("Main Thread is strating...");

        //build MyThread
        /*MyChildThread mt1 = new MyChildThread("Child #1");
        MyChildThread mt2 = new MyChildThread("Child #2");
        MyChildThread mt3 = new MyChildThread("Child #3");
        MyChildThread mt4 = new MyChildThread("Child #4");


        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread is interrupted");
                e.printStackTrace();
            }

            *//******************************************************************
            * isAlive() allows the thread to wait for the child to terminate
             * before it goes to the next one!
            ********************************************************************//*
        }while (mt1.getMyThread().isAlive() || mt2.getMyThread().isAlive() ||
                mt3.getMyThread().isAlive() || mt4.getMyThread().isAlive());
        System.out.println("Main thread is ending");*/

        /**********************************************
        * Join allow us to wait for a thread to finish
        ***********************************************/

        try {
            MyChildThread mt11 = new MyChildThread("Child #1");
            mt11.getMyThread().setPriority(Thread.MIN_PRIORITY);
            //mt11.getMyThread().join();
            //System.out.println("Child #1 is joined");

            MyChildThread mt12 = new MyChildThread("Child #2");
            mt12.getMyThread().setPriority(Thread.NORM_PRIORITY);
            //mt12.getMyThread().join();
            //System.out.println("Child #2 is joined");

            MyChildThread mt13 = new MyChildThread("Child #3");
            mt13.getMyThread().join();
            //mt13.getMyThread().setPriority(Thread.MAX_PRIORITY);
            //System.out.println("Child #3 is joined");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


/*        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread is interrupted");
                e.printStackTrace();
            }
        }
        System.out.println("Main thread is ending");*/

        /********************************************
        * We don't need this anymore since MyChildThread
        * is self starting....
        *********************************************/
        /*Thread parent = new Thread(mt1);
        parent.start();*/

    }

}

/***************************************************
 *  MyChildThread implements Runnable allows us to
 *  pass this class to the Thread contructor which
 *  will call the overridable run() method
 *  when the start() is called.
 ****************************************************/
class MyChildThread implements Runnable {
    private Thread myThread;

    public Thread getMyThread() {
        return myThread;
    }

    private String myChildThread;

    public MyChildThread(String myChildThread) {
        this.myChildThread = myChildThread;
        myThread = new Thread(this, myChildThread);
        myThread.start();
    }

    @Override
    public void run() {
        System.out.println(myChildThread + " strating");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(400);
                System.out.println("in " + myChildThread +  " count is " + i);
            } catch (InterruptedException e) {
                System.out.println(myChildThread + " is interrupted");
                e.printStackTrace();
            }
            System.out.println(myChildThread + " is terminated");
        }
    }
}
