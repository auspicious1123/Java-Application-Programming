
/**
 * @author-Rui Wang rw1
 */
public class FinalData {
    private String item;
    private double price;
    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }
    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    public FinalData(String item, double price) {
       this.item = item;
       this.price = price;
    }

    public String toString() {
        if (this.item.length() < 16) {
            for (int i = this.item.length(); i < 16; i++) {
                this.item = this.item + " ";
            }
        }
        return String
                .format("%s\tat $%,6.2f", this.item, price);
        
    }
}
