package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public class StockIndex implements StockListener{
	
	private String name;
	private double index;
	private List<Stock> stocks;
	
	public StockIndex(String name, Stock...stocks) {
		this.name = name;
		this.stocks = new ArrayList<>();
		if (stocks.length == 0) {
			index = 0;
		}
		else {
			index = 0;
			for (int i = 0; i < stocks.length; i++) {
				this.stocks.add(stocks[i]);
				stocks[i].addStockListener(this);
				index += stocks[i].getPrice();
			}
		}
		
	}
	
	public void addStock(Stock stock) {
		if (!stocks.contains(stock)) {
			stocks.add(stock);
			stock.addStockListener(this);
			index += stock.getPrice();
		}
		
	}
	
	public void removeStock(Stock stock) {
		if (stocks.contains(stock)) {
			stocks.remove(stock);
			stock.removeStockListener(this);
			index -= stock.getPrice();
		}
	}
	
	public double getIndex() {
		return index;
	}

	@Override
	public void stockPriceChanged(Stock stock, double oldPrice, double newPrice) {
			this.index += newPrice - oldPrice;
	}
	

}
