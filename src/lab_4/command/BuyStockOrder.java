package lab_4.command;

import lab_4.observer.Investor;
import lab_4.observer.Stock;

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
