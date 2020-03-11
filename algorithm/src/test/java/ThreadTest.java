public class ThreadTest{
	
	public static void main(String[] args){

		MultiThread mt = new MultiThread();
		try{
			Thread thread1 = new Thread(mt,"user1");
			Thread thread2 = new Thread(mt,"user2");
			thread1.start();
			thread2.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static class MultiThread implements Runnable{

		int count = 0;
		
		@Override
		public void run(){
			System.out.println(Thread.currentThread().getName() + " say : hello!");
			count();
		}
		
		public void count(){
			while(count<20){
				synchronized(this){
					System.out.println(Thread.currentThread().getName() + " say : count is " + count);
					try{
						count++;
						Thread.sleep(1000);
//						Thread.wait(100);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
	}
}