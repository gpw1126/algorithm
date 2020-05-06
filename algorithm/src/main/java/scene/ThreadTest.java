package scene;

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

	public static void test() {

		while (true) {
			new Thread() { //设置名字1：通过构造方法 new Thread(String name)
				@Override
				public void run() {
					this.setName("t1"); //设置名字二：调用setName()
					System.out.println(this.getName() + ",extends Thread");
				}
			}.start();

			//这里注意，没有直接执行new Runnable()的run()，而是将new Runnable()填入到Thread中，使用start()启动。
			//Runnable包含run()，仅仅作为线程执行体，实际的对象仍然是Thread实例对象，Tread为真正创建线程的对象。
			new Thread(new Runnable() {
				@Override
				public void run() { //设置名字3：如果实现Runnable接口，先获取当前线程对象Thread.currentThread()
					Thread.currentThread().setName("t2");
					System.out.println(Thread.currentThread().getName() + ",implements Runnable");
				}
			}).start();
		}

	}
}