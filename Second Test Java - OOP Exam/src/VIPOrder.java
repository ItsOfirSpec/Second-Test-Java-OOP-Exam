import java.util.Date;
import java.util.List;

public class VIPOrder extends Order {
    public VIPOrder(String orderId, String orderName, String orderDeliveryAddress, List<Item> orderItems,
                    Customer orderCustomer, PaymentType orderPaymentType, Date orderDate) {
        super(orderId, orderName, orderDeliveryAddress, orderItems, orderCustomer, orderPaymentType, orderDate);
        if (orderCustomer.getCustomerType() != CustomerType.VIP) {
            throw new IllegalArgumentException("Only VIP customers can place VIP orders.");
        }
    }

    @Override
    protected double calculateOrderTotalPrice() {
        double totalSum = getOrderItems().stream().mapToDouble(Item::getItemPrice).sum();
        Double discount = getOrderCustomer().getCustomerDiscount();
        return discount != null ? totalSum - discount : totalSum;
    }
}