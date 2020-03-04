package com.thread;

/**
 * 描述：     最佳实践：catch了InterruptedExcetion之后的优先选择：在方法签名中抛出异常 那么在run()就会强制try/catch
 */
public class ThreadRightInterRupt implements Runnable {
    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("InterruptedException");
                e.printStackTrace();
            }
        }
    }

    public void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadRightInterRupt());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
