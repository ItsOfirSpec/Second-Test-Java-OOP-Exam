import java.util.Objects;

public class Item {
    private final String itemId;
    private final String itemName;
    private final double itemPrice;

    public Item(String itemId, String itemName, double itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public double getItemPrice() { return itemPrice; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Item)) return false;
        Item other = (Item) obj;
        return Objects.equals(itemName, other.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName);
    }
}
