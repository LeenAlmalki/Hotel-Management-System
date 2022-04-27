import javax.swing.JFrame;

public class RoomService extends JFrame{
	public RoomService() {
		getContentPane().setLayout(null);
	}
	
	private String foodItem;
    private int price;
    private int quantity;
    private double total;

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }
    
    public double calculateTotal()
    {
       return getPrice() * quantity;
    }
}