# Behavioural Design Patterns


## Author: Ursu Vlad, FAF-212

----

## Objectives:
1. Study and understand the Behavioral Design Patterns.

2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.

3. Create a new Project or add some additional functionalities using behavioral design patterns.


## Laboratory notes

* A simple project resembling a stock exchange app was made in Java.
* 3 behavioural design patterns were implemented: Observer, Command and Strategy.

## Implementation:

### Observer:
Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

In this project: 
The Stock class will be the subject that is observed.
The Investor class will be the observer that receives updates when the stock price changes.

```java
public interface Observer {
    void updatePortfolio(Stock stock);
}
```

```java
public class Investor implements Observer {
    private String name;
    private List<Stock> portfolio = new ArrayList<>();;

    public Investor(String name) {
        this.name = name;
    }

    public void addStock(Stock stock){
        portfolio.add(stock);
    }

    public void removeStock(Stock stock){
        try {
            portfolio.remove(stock);
        }
        catch (Exception e){
            System.out.println("There is no such stock in the portfolio.");
        }
    }

    public void updatePortfolio(Stock stock){
        System.out.println("Investor " + this.name + " has received an update for stock " + stock.getSymbol());
        for (Stock portfolioStock : this.portfolio){
            if (Objects.equals(stock.getSymbol(), portfolioStock.getSymbol())){
                portfolioStock.updatePrice(stock.getPrice());

            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stock> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(List<Stock> portfolio) {
        this.portfolio = portfolio;
    }

    public void presentPortfolio(){
        System.out.println("    " + name + "'s Stocks:");
        for (Stock portfolioStock : this.portfolio){
            System.out.println("        " + portfolioStock.getSymbol() + " - " + portfolioStock.getPrice() + "$");
        }
    }
}
```

```java
public class Stock {
    private List<Observer> observers = new ArrayList<>();
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public void updatePrice(double price) {
        this.price = price;
    }



    public double getPrice() {
        return price;
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.updatePortfolio(this);
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
```


### Command:
Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation lets you pass requests as a method arguments, delay or queue a request’s execution.

The StockOrder interface will represent a command to buy or sell stock.
Two concrete classes, BuyStockOrder and SellStockOrder, will implement specific buy and sell commands.

```java
public interface StockOrder {
    void execute(Investor investor);
}
```

```java
public class BuyStockOrder implements StockOrder {
    private Stock stock;

    public BuyStockOrder(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute(Investor investor) {
        System.out.println("Buying stock: " + stock.getSymbol() + " for " + stock.getPrice());
        investor.addStock(stock);
    }
}
```

```java
public class SellStockOrder implements StockOrder {
    private Stock stock;

    public SellStockOrder(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute(Investor investor) {
        System.out.println("Selling stock: " + stock.getSymbol() + " for " + stock.getPrice());
        investor.removeStock(stock);
    }
}
```

### Strategy:
Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

The TradingStrategy interface will define a strategy for trading stocks.
Two concrete classes, AggressiveTradingStrategy and ConservativeTradingStrategy, will implement different trading strategies.

```java
public interface TradingStrategy {
    void trade(Investor investor, Stock stock);
}
```

```java
public class AggressiveTradingStrategy implements TradingStrategy {
    @Override
    public void trade(Investor investor, Stock stock) {
        System.out.println(investor.getName() + " is executing aggressive trading strategy!");

        BuyStockOrder buyStock = new BuyStockOrder(stock);

        for (int i = 0; i < 10; i += 1){
            buyStock.execute(investor);
        }
    }
}
```

```java
public class ConservativeTradingStrategy implements TradingStrategy {
    @Override
    public void trade(Investor investor, Stock stock) {
        System.out.println(investor.getName() + " is executing conservative trading strategy!");

        BuyStockOrder buyStock = new BuyStockOrder(stock);
        buyStock.execute(investor);

        // sell the highest stock
        double highestPrice = Integer.MIN_VALUE;
        String stockName = "";

        for (Stock portfolioStock : investor.getPortfolio()){
            if (portfolioStock.getPrice() > highestPrice && stock != portfolioStock) {
                highestPrice = portfolioStock.getPrice();
                stockName = portfolioStock.getSymbol();
            }
        }

        SellStockOrder sellStock = new SellStockOrder(new Stock(stockName, highestPrice));
        sellStock.execute(investor);
    }

}
```

---

## Results:

A simple program that declares 2 types of stocks and 2 investors was created:

```java
public class Main{
    public static void main(String[] args) {
        // Observer Pattern
        Stock googleStock = new Stock("GOOGL", 132.00);
        Stock appleStock = new Stock("AAPL", 186.00);
        Investor investor1 = new Investor("John Ghatsby");
        Investor investor2 = new Investor("Jordan Belfort");

        googleStock.addObserver(investor1);
        googleStock.addObserver(investor2);

        // Strategy Pattern
        TradingStrategy aggressiveStrategy = new AggressiveTradingStrategy();
        TradingStrategy conservativeStrategy = new ConservativeTradingStrategy();

        // Execute strategies and commands
        aggressiveStrategy.trade(investor1, googleStock);
        conservativeStrategy.trade(investor1, appleStock);

        aggressiveStrategy.trade(investor2,appleStock);
        conservativeStrategy.trade(investor2,googleStock);

        investor1.presentPortfolio();
        investor2.presentPortfolio();

        // Update stock price to notify observers
        googleStock.setPrice(155.00);

        investor1.presentPortfolio();
        investor2.presentPortfolio();
    }
}
```

Output:
```
John Ghatsby is executing aggressive trading strategy!
Buying stock: GOOGL for 132.0
Buying stock: GOOGL for 132.0
Buying stock: GOOGL for 132.0
Buying stock: GOOGL for 132.0
Buying stock: GOOGL for 132.0
Buying stock: GOOGL for 132.0
Buying stock: GOOGL for 132.0
Buying stock: GOOGL for 132.0
Buying stock: GOOGL for 132.0
Buying stock: GOOGL for 132.0
John Ghatsby is executing conservative trading strategy!
Buying stock: AAPL for 186.0
Selling stock: GOOGL for 132.0
Jordan Belfort is executing aggressive trading strategy!
Buying stock: AAPL for 186.0
Buying stock: AAPL for 186.0
Buying stock: AAPL for 186.0
Buying stock: AAPL for 186.0
Buying stock: AAPL for 186.0
Buying stock: AAPL for 186.0
Buying stock: AAPL for 186.0
Buying stock: AAPL for 186.0
Buying stock: AAPL for 186.0
Buying stock: AAPL for 186.0
Jordan Belfort is executing conservative trading strategy!
Buying stock: GOOGL for 132.0
Selling stock: AAPL for 186.0
    John Ghatsby's Stocks:
        GOOGL - 132.0$
        GOOGL - 132.0$
        GOOGL - 132.0$
        GOOGL - 132.0$
        GOOGL - 132.0$
        GOOGL - 132.0$
        GOOGL - 132.0$
        GOOGL - 132.0$
        GOOGL - 132.0$
        GOOGL - 132.0$
        AAPL - 186.0$
    Jordan Belfort's Stocks:
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        GOOGL - 132.0$
Investor John Ghatsby has received an update for stock GOOGL
Investor Jordan Belfort has received an update for stock GOOGL
    John Ghatsby's Stocks:
        GOOGL - 155.0$
        GOOGL - 155.0$
        GOOGL - 155.0$
        GOOGL - 155.0$
        GOOGL - 155.0$
        GOOGL - 155.0$
        GOOGL - 155.0$
        GOOGL - 155.0$
        GOOGL - 155.0$
        GOOGL - 155.0$
        AAPL - 186.0$
    Jordan Belfort's Stocks:
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        AAPL - 186.0$
        GOOGL - 155.0$

Process finished with exit code 0
```

---

## Conclusions:

n this small Java project, we implemented a basic stock market simulation that incorporated three behavioral design patterns: Observer, Strategy, and Command. The Observer pattern allowed investors to receive updates when the stock price changed, demonstrating a one-to-many dependency between objects. The Strategy pattern provided flexibility by defining different trading strategies that could be dynamically chosen at runtime. Lastly, the Command pattern encapsulated buy and sell orders as objects, allowing clients to parameterize and execute requests.