package ca.mcgill.cs.swdesign.m9;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class IteratingList
{
	
	private static List<String> strings = new CopyOnWriteArrayList<>(); //  Compare the usage with synchronizedList
//	private static List<String> strings = Collections.synchronizedList(new ArrayList<>());

	public static void main(String[] args) throws InterruptedException
	{
		for(int i = 0;i<10;i++)
			strings.add(String.valueOf(i));


		Thread tA = new Thread(new Runnable() {

			@Override
			public void run()
			{
				Iterator<String> it = strings.iterator();
				while (it.hasNext()) {
					String s = it.next();
					System.out.printf("1st Thread: %s\n", s);
				}
				System.out.printf("String size to 1st Thread: %d\n", strings.size());

			}

		});
		
		Thread tB = new Thread(new Runnable() {

			@Override
			public void run()
			{
					for (int i = 10; i < 2000; i++) {
						strings.add(String.valueOf(i));
						System.out.printf(".");
					}
					System.out.printf("2nd Thread done\n");
					System.out.printf("String size to 2nd thread: %d\n", strings.size());
			}

		});

		tA.start();
		tB.start();
		System.out.printf("String size to Main: %d\n", strings.size());
	}
}
		    
