package com.java.abaproblem;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * java中解决ABA问题
 * 线程1准备用CAS将变量的值由A替换为B，在此之前，线程2将变量的值由A替换为C，
 * 又由C替换为A，然后线程1执行CAS时发现变量的值仍然为A，所以CAS成功。
 * 但实际上这时的现场已经和最初不同了
 * @author wangqian
 *
 */
public class ABA {
        private static AtomicInteger atomicInt = new AtomicInteger(100);
        private static AtomicStampedReference atomicStampedRef = new AtomicStampedReference(100, 0);

        public static void main(String[] args) throws InterruptedException {
                Thread intT1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                                atomicInt.compareAndSet(100, 101);
                                atomicInt.compareAndSet(101, 100);
                        }
                });

                Thread intT2 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                                try {
                                        TimeUnit.SECONDS.sleep(1);
                                } catch (InterruptedException e) {
                                }
                                boolean c3 = atomicInt.compareAndSet(100, 101);
                                System.out.println(c3); // true
                        }
                });

                intT1.start();
                intT2.start();
                intT1.join();
                intT2.join();

                Thread refT1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                                try {
                                        TimeUnit.SECONDS.sleep(1);
                                } catch (InterruptedException e) {
                                }
                                atomicStampedRef.compareAndSet(100, 101, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
                                atomicStampedRef.compareAndSet(101, 100, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
                        }
                });

                Thread refT2 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                                int stamp = atomicStampedRef.getStamp();
                                try {
                                        TimeUnit.SECONDS.sleep(2);
                                } catch (InterruptedException e) {
                                }
                                boolean c3 = atomicStampedRef.compareAndSet(100, 101, stamp, stamp + 1);
                                System.out.println(c3); // false
                        }
                });

                refT1.start();
                refT2.start();
        }
}