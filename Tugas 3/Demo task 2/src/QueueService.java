import java.util.LinkedList;
import java.util.Queue;

public class QueueService {
    private Queue<String> queue = new LinkedList<>();

    public void addPassenger(String name) {
        queue.offer(name);
        System.out.println("Passenger added to queue.");
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Current Queue:");
        int i = 1;
        for (String p : queue) {
            System.out.println(i++ + ". " + p);
        }
    }

    public String servePassenger() {
        if (queue.isEmpty()) {
            System.out.println("No passengers in queue.");
            return null;
        }
        String served = queue.poll();
        System.out.println("Serving passenger: " + served);
        return served;
    }

    public void requeue(String name) {
        queue.offer(name);
    }
}