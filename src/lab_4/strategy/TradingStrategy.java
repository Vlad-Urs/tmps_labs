package lab_4.strategy;

import lab_4.observer.Investor;
import lab_4.observer.Stock;

public interface TradingStrategy {
    void trade(Investor investor, Stock stock);
}
