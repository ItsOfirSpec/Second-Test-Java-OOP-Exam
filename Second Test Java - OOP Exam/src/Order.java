import java.util.Date;
import java.util.List;
import java.util.*;

public abstract class Order {
    private final String orderId;
    private final String orderName;
    private final String orderDeliveryAddress;
    private final List<Item> orderItems;
    private final Customer orderCustomer;
    private final PaymentType orderPaymentType;
    private final Date orderDate;
    private final double orderTotalPrice;

    public Order(String orderId, String orderName, String orderDeliveryAddress, List<Item> orderItems,
                 Customer orderCustomer, PaymentType orderPaymentType, Date orderDate) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderDeliveryAddress = orderDeliveryAddress;
        this.orderItems = new ArrayList<>(orderItems);
        this.orderCustomer = orderCustomer;
        this.orderPaymentType = orderPaymentType;
        this.orderDate = orderDate;

        this.orderTotalPrice = calculateOrderTotalPrice();

        for (Item item : orderItems) {
            orderCustomer.addFavoriteItem(item);
        }
    }

    protected abstract double calculateOrderTotalPrice();

    public String getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getOrderDeliveryAddress() {
        return orderDeliveryAddress;
    }

    public List<Item> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }

    public Customer getOrderCustomer() {
        return orderCustomer;
    }

    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public PaymentType getOrderPaymentType() {
        return orderPaymentType;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}
