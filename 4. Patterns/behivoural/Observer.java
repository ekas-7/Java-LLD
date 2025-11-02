import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String video);
}

class YouTubeSubscriber implements Subscriber {
    private String name;

    public YouTubeSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String video) {
        System.out.println(name + " is watching the video: " + video);
    }
}

class EmailSubscriber implements Subscriber {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String video) {
        System.out.println(
            "Sending email to " + email + ": New video uploaded: " + video);
    }
}

class PushNotificationSubscriber implements Subscriber {
    private String userDevice;

    public PushNotificationSubscriber(String userDevice) {
        this.userDevice = userDevice;
    }

    @Override
    public void update(String video) {
        System.out.println("Sending push notification to " + userDevice
            + ": New video uploaded: " + video);
    }
}

 interface YouTubeChannel {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscribers();
}

class YouTubeChannelImpl implements YouTubeChannel {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String video;

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(video); 
        }
    }

    public void uploadNewVideo(String video) {
        this.video = video;
        System.out.println("\n--- Channel uploaded a new video: " + video + " ---");
        notifySubscribers();
    }
}

public class Observer{
    public static void main(String[] args) {
        YouTubeChannelImpl channel = new YouTubeChannelImpl();

        YouTubeSubscriber alice = new YouTubeSubscriber("Alice");
        YouTubeSubscriber bob = new YouTubeSubscriber("Bob");
        EmailSubscriber charlieEmail = new EmailSubscriber("charlie@example.com");
        PushNotificationSubscriber davePush = new PushNotificationSubscriber("Dave's Phone");

        channel.addSubscriber(alice);
        channel.addSubscriber(bob);
        channel.addSubscriber(charlieEmail);
        channel.addSubscriber(davePush);

        channel.uploadNewVideo("Java Design Patterns Tutorial");

        System.out.println("\n--- Bob unsubscribes ---");
        channel.removeSubscriber(bob);

        channel.uploadNewVideo("Observer Pattern in Action");
    }
}