package testthreads;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Exécuté par le thread : " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    } 

}
