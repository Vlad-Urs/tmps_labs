package lab_4.strategy;

import lab_4.command.BuyStockOrder;
import lab_4.observer.Investor;
import lab_4.observer.Stock;

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
