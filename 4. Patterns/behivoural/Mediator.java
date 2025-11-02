import java.util.ArrayList;
import java.util.List;

interface AuctionMediator {
    void registerBidder(Bidder bidder);
    void placeBid(Bidder bidder, int amount);
}

class Bidder {
    private String name;
    private AuctionMediator mediator;

    public Bidder(String name, AuctionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void placeBid(int amount) {
        mediator.placeBid(this, amount);
    }

    public void receiveBid(Bidder bidder, int amount) {
        System.out.println(name + " is notified: " + bidder.getName() +
                           " placed a bid of " + amount);
    }
}

class AuctionHouse implements AuctionMediator {
    protected List<Bidder> bidders = new ArrayList<>();

    @Override
    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    @Override
    public void placeBid(Bidder bidder, int amount) {
        System.out.println(bidder.getName() + " placed a bid of " + amount);
        for (Bidder b : bidders) {
            if (b != bidder) {
                b.receiveBid(bidder, amount);
            }
        }
    }
}

class ExtendedAuctionHouse extends AuctionHouse {
    private long biddingEndTime;

    public ExtendedAuctionHouse(long biddingEndTime) {
        this.biddingEndTime = biddingEndTime;
    }

    @Override
    public void placeBid(Bidder bidder, int amount) {
        if (System.currentTimeMillis() > biddingEndTime) {
            System.out.println("Bidding time is over. No more bids accepted.");
            return;
        }
        System.out.println("LOG: " + bidder.getName() + " is bidding " + amount);
        super.placeBid(bidder, amount);
    }
}

public class Mediator {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Running Extended Auction Demo ---");
        long biddingEndTime = System.currentTimeMillis() + 5000;
        AuctionMediator auctionHouse = new ExtendedAuctionHouse(biddingEndTime);

        Bidder bidder1 = new Bidder("Alice", auctionHouse);
        Bidder bidder2 = new Bidder("Bob", auctionHouse);
        Bidder bidder3 = new Bidder("Charlie", auctionHouse);

        auctionHouse.registerBidder(bidder1);
        auctionHouse.registerBidder(bidder2);
        auctionHouse.registerBidder(bidder3);

        bidder1.placeBid(100);
        Thread.sleep(2000);
        bidder2.placeBid(150);
        Thread.sleep(4000);
        bidder3.placeBid(200);

        System.out.println("-------------------------------------");
    }
}