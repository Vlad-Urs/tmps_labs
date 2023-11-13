package lab_4.command;

import lab_4.observer.Investor;
import lab_4.observer.Stock;

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