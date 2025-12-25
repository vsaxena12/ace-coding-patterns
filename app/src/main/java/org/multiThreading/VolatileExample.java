package org.multiThreading;

class SharedObj {
    private volatile boolean flag = false;

    public void setFlag() {
        System.out.println("Flag is true now...");
        flag = true;
    }

    public void printIfFlagTrue() {
        while (!flag) {
            //Do Nothing
        }
        System.out.println("Flag is true...");
    }
}

public class VolatileExample {
    public static void main(String[] args) {
        SharedObj sharedObj = new SharedObj();

        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedObj.setFlag();
        });
        Thread reader = new Thread(sharedObj::printIfFlagTrue);

        writer.start();
        reader.start();



    }
}
