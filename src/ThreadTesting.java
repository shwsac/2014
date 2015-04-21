
public class ThreadTesting implements Runnable {
	public static int count =0;
	
	public static void main(String[] args){
		ThreadTesting r = new ThreadTesting();
		Thread t1 = new Thread(r,"Monish");
		t1.start();
		System.out.println(t1.isAlive());
		Thread t2 = new Thread(r);
		t2.start();
		Thread t3 = new Thread(r);
		t3.start();
		System.out.println(t1.isAlive());
	}

	@Override
	public  void  run() {
		System.out.println(Thread.currentThread().isAlive()+ " "+ count++ + "  "+ Thread.currentThread().getName());
		
	}

}
