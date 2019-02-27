/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsemaphore_ingarozza;

import static java.lang.Thread.currentThread;
import java.util.concurrent.Semaphore;

/**
 *
 * @author giodabg
 */
public class DatiCondivisi {

    private Semaphore mutexNum;
    private int num;

    public DatiCondivisi() {
        num = 0;
        mutexNum = new Semaphore(1);
    }

    public synchronized void waitNum() throws InterruptedException {
        System.out.println(currentThread().getName() + ": Locks remaining before wait >> " + mutexNum.availablePermits());        
        mutexNum.acquire();
        System.out.println(currentThread().getName() + " continue");
    }

    public synchronized void signalNum() {
        mutexNum.release();
        System.out.println(currentThread().getName() + ": Locks remaining after signal >> " + mutexNum.availablePermits());
    }

    int availablePermits() {
        return mutexNum.availablePermits();
    }
    
    public synchronized void incNum() {
        for (int i = 0; i < 100; i++)
            if (num < Integer.MAX_VALUE)
                num++;
        System.out.println("valore = "+num);
    }
    
    public synchronized int getNum() {
        return num;
    }
}
