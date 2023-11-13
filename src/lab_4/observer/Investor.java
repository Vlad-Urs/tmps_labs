package lab_4.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
