package partE.thread;

/*	Thread : 동일 프로세스 안에서 특정 기능을 수행하는 독립적인 단위
 *	목적 : 멀티 태스킹(동시성) 과 응답속도 향상 목적
 *	
 *	● 자바에서 쓰레드를 만드는 형식은 여러가지가 있다.
 *		1. Thread 클래스를 상속받는 클래스를 정의
 *		2. 정의한 클래스에서 run() 메소드 재정의 ▶ 쓰레드가 할 일 작성
 *		3. 쓰레드 객체 생성 후 실행은 start() 메소드
 *
 *
 *	● 메인 쓰레드는 가장 먼저 종료된다.
 *	● 쓰레드 실행 start()는 동시성을 갖는다.
 *	● 재정의 run() 실행은 순차적으로 실행된다.
*/

public class Main01 {
	public static void main(String[] args) {
		
		System.out.println("쓰레드 객체를 생성합니다.");
		Thread th1 = new AddThread();
		Thread th2 = new SubtractThread();
		
		th1.setName("▶ 덧셈 쓰레드");
		th2.setName("▷ 뺄셈 쓰레드");
		
		th1.start();
		th2.start();
		
//		th1.run();
//		th2.run();
		
		System.out.println("⚠ 메인 쓰레드 실행 끝⚠");
	}
}//main class end

class AddThread extends Thread{	//덧셈하는 쓰레드
	
	@Override
	public void run() {	//덧셈을 11번 반복하기
		int sum = 0;
		for (int i = 0; i <= 10; i++) {
			System.out.print("쓰레드 이름 : "+this.getName());
			System.out.println("\tsum = "+(sum+i));
			//쓰레드 실행을 늦추기 위해서 0.5초 쓰레드를 중지해본다.
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
		System.out.println("\n쓰레드 ID : "+this.getId()+"\t⚠ 쓰레드 실행 끝⚠");
	}
	
}//AddThread end

class SubtractThread extends Thread {	//뺄셈하는 쓰레드
	
	@Override
	public void run() {	//뺄셈을 11번 반복하기
		int sum = 100;
		for (int i = 0; i <= 10; i++) {
			System.out.print("쓰레드 이름 : "+this.getName());
			System.out.println("\tsum = "+(sum-i));
			//쓰레드 실행을 늦추기 위해서 0.5초 쓰레드를 중지해본다.
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
		System.out.println("\n쓰레드 ID : "+this.getId()+"\t⚠ 쓰레드 실행 끝⚠");
	}
	
}//SubtractThread end