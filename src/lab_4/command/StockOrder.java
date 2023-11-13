package lab_4.command;

import lab_4.observer.Investor;
import lab_4.observer.Stock;

public interface StockOrder {
    void execute(Investor investor);
}