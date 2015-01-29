package collections.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewMain {

  private static  final Logger LOGGER = Logger.getLogger(NewMain.class.getName());
	public static void main(String[] args) {
    LOGGER.setLevel(Level.ALL);
//    LOGGER.equals()

		final BlockingQueue bq = new SynchronousQueue();
		new Thread(new Runnable() { 

			@Override
			public void run() {

        for (int i = 0; i < 10; i++) {
          try {
            Thread.sleep(100);
            bq.put(i);
            LOGGER.log(Level.INFO, "number {} has been put {}", new Object[] {i, System.currentTimeMillis()});
          } catch (InterruptedException ex) {
            LOGGER.warning(ex.getMessage());
					}

				}

			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("prepaaruing to get " + System.currentTimeMillis());
					try {
            Object take = bq.take();
            LOGGER.log(Level.INFO, "number {} has been put {}", new Object[]{take, System.currentTimeMillis()});
					} catch (InterruptedException ex) {
            LOGGER.warning(ex.getMessage());
					}
				}
			}
		}).start();

	}

}
