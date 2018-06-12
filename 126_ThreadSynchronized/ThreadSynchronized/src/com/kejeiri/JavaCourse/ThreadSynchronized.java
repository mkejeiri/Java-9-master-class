package com.kejeiri.JavaCourse;

public class ThreadSynchronized {

    public static void main(String[] args) {
        First first = new First();
        Second one = new Second("Welcome", first);
        Second two = new Second("new", first);
        Second three = new Second("programmer", first);
    }
}
class First{
    //synchronized will lock this method in case of concurrency access
    synchronized void display(String msg){
        System.out.print("[" + msg);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("]");
    }
}

class Second extends Thread{
    String msg;
    First fobj;

    public Second(String msg, First fobj) {
        this.msg = msg;
        this.fobj = fobj;
        start();
    }

    @Override
    public void run() {
        fobj.display(msg);
    }
}

