package lab_4;

import lab_4.command.BuyStockOrder;
import lab_4.command.SellStockOrder;
import lab_4.command.StockOrder;
import lab_4.observer.Investor;
import lab_4.observer.Stock;
import lab_4.strategy.AggressiveTradingStrategy;
import lab_4.strategy.ConservativeTradingStrategy;
import lab_4.strategy.TradingStrategy;

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