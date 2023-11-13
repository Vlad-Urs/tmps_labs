package lab_4.strategy;

import lab_4.command.BuyStockOrder;
import lab_4.command.SellStockOrder;
import lab_4.observer.Investor;
import lab_4.observer.Stock;

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
