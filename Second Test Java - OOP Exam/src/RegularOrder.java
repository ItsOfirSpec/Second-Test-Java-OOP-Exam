import java.util.Date;
import java.util.List;

public class RegularOrder extends Order {
    public RegularOrder(String orderId, String orderName, String orderDeliveryAddress, List<Item> orderItems,
                        Customer orderCustomer, PaymentType orderPaymentType, Date orderDate) {
        super(orderId, orderName, orderDeliveryAddress, orderItems, orderCustomer, orderPaymentType, orderDate);
    }

    @Override
    protected double calculateOrderTotalPrice() {
        return getOrderItems().stream().mapToDouble(Item::getItemPrice).sum();
    }
}
