import java.util.*;

public class Customer {
    private final String customerId;
    private final String customerFirstName;
    private final String customerLastName;
    private final String customerEmail;
    private final String customerDeliveryAddress;
    private final CustomerType customerType;
    private final Double customerDiscount;
    private final List<Item> favoriteItems = new ArrayList<>();
    private Gift customerGift;

    public Customer(String customerId, String customerFirstName, String customerLastName, String customerEmail,
                    String customerDeliveryAddress, CustomerType customerType, Double customerDiscount) {
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.customerDeliveryAddress = customerDeliveryAddress;
        this.customerType = customerType;
        this.customerDiscount = customerDiscount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerDeliveryAddress() {
        return customerDeliveryAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public Double getCustomerDiscount() {
        return customerDiscount;
    }

    public List<Item> getFavoriteItems() {
        return Collections.unmodifiableList(favoriteItems);
    }

    public void addFavoriteItem(Item item) {
        if (!containsItemByName(item.getItemName())) {
            favoriteItems.add(item);
        }
    }

    public void removeFavoriteItem(Item item) {
        favoriteItems.removeIf(i -> i.getItemName().equals(item.getItemName()));
    }

    private boolean containsItemByName(String name) {
        for (Item i : favoriteItems) {
            if (i.getItemName().equals(name)) return true;
        }
        return false;
    }

    public void giveGift(Gift customerGift) {
        this.customerGift = customerGift;
    }

    public void openGift() {
        if (customerGift != null) {
            customerGift.openGift(getCustomerFirstName());
        } else {
            System.out.println("No gift available.");
        }
    }
}
