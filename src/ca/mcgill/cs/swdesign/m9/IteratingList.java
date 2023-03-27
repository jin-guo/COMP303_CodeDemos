package ca.mcgill.cs.swdesign.m9;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class IteratingList
{
	
	private static List<String> strings = new CopyOnWriteArrayList<>();
//	private static List<String> strings = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException
	{
		for(int i = 0;i<10;i++)
			strings.add(String.valueOf(i));


		Thread tA = new Thread(new Runnable() {

			@Override
			public void run()
			{
			synchronized (strings) {
				Iterator<String> it = strings.iterator();
				while (it.hasNext()) {
					String s = it.next();
					System.out.printf("1st Thread: %s\n", s);
					if(s.equals("5"))
						it.remove();
				}

			}

			}

		});
		
		Thread tB = new Thread(new Runnable() {

			@Override
			public void run()
			{
					for(int i = 10;i<2000;i++)
						strings.add(String.valueOf(i));
					System.out.printf("2nd Thread done\n");
					System.out.printf("String size: %d\n", strings.size());

			}

		});

		tA.start();
		tB.start();

	}
}
		    
