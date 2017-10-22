package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private String tickerCode;
	private double price;
	private List<StockListener> listeners;
	
	public Stock(String tickerCode, double price) {
		this.tickerCode = tickerCode;
		this.price = price;
		listeners = new ArrayList<>();
	}
	
	public void setPrice(double price){
		double oldPrice = this.price;
		if (price <= 0) {
			throw new IllegalArgumentException("Aksjeprisen må være positiv.");
		}
		this.price = price;
		
		for (StockListener listener : listeners) {
			listener.stockPriceChanged(this, oldPrice, this.price);
		}
	}
	
	public String getTicker() {
		return tickerCode;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void addStockListener(StockListener listener) {
		listeners.add(listener);
	}
	
	public void removeStockListener(StockListener listener){
		listeners.remove(listener);
	}
	

}
