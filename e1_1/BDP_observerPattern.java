package EI_Exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Observer {
    void update(String news);
}

class NewsFeed implements Observer {
    private String name;

    public NewsFeed(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

class NewsPublisher {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String news) {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}

public class BDP_observerPattern {
    public static void main(String[] args) {
        NewsPublisher publisher = new NewsPublisher();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of subscribers: ");
        int numSubscribers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numSubscribers; i++) {
            System.out.print("Enter name of subscriber " + (i + 1) + ": ");
            String name = scanner.nextLine();
            publisher.addObserver(new NewsFeed(name));
        }

        System.out.print("Enter news to broadcast: ");
        String news = scanner.nextLine();

        publisher.notifyObservers(news);
    }
}

