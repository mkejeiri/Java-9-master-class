package com.kejeiri.JavaCourse;

public class IntroThread {

    public static void main(String[] args) {
        System.out.println("Main Thread is strating...");

        //build MyThread
        MyChildThread mt1 = new MyChildThread("Child #1");
        MyChildThread mt2 = new MyChildThread("Child #2");
        MyChildThread mt3 = new MyChildThread("Child #3");
        MyChildThread mt4 = new MyChildThread("Child #4");


        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Main thread is interrupted");
                e.printStackTrace();
            }
            System.out.println("Main thread is ending");

        }

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
