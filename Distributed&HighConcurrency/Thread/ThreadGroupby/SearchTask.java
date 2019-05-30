import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.SliderUI;

import com.sun.jdi.InternalException;
import com.sun.net.httpserver.Authenticator.Result;

public class SearchTask implements Runnable{
    private Result result;
    public SearchTask(Result result){
        this.result=result;
    }
    @Override
    public void run(){
        String name=Thread.currentThread().getName();
        System.out.printf("Thread %s: Start\n",name);
        try{
            doTask();
            result.setName(name);
        }catch(InternalException e){
            System.out.printf("Thread %s: Interrupted\n", name);
            return;
        }
        System.out.printf("Thread %s: End\n", name);
    }
    private void doTask() throws InternalException{
        Random random = new Random((new Date()).getName());
        int value=(int)(random.nextDouble()*100);
        System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(),value);
        TimeUnit.SECONDS.sleep(value);
    }
    public class Main{
        public static void main(String[] args){
            ThreadGroup threadGroup = new ThreadGroup("Searcher");
            Result result = new Result();
            SearchTask searchTask = new SearchTask(result);

            for(int i=0;i<5;i++){
                Thread thread = new Thread(threadGroup,searchTask);
                thread.start();
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.printf("Number of Threads:%d\n", threadGroup.activeCount());
            System.out.printf("Information about the Thread Group\n",);
            threadGroup.list();

            Thread[] threads=new Thread[threadGroup.activeCount()];
            threadGroup.enumerate(threads);

            for(int i=0;i<threadGroup.activeCount();i++){
                System.out.printf("Thread %s:%s\n", threads[i].getName(),threads[i].getState());
            }
            waitFinsh(threadGroup);
            threadGroup.interrupt();
            
            private static void waitFinsh(ThreadGroup threadGroup){
                while(threadGroup.activeCount()>9){
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }catch(InternalException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}