//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to ofir's orders maker\n");

        Item item1 = new Item("1", "Table", 289.99);
        Item item2 = new Item("2", "Recliner Chair", 329.49);
        Item item3 = new Item("3", "Floor Lamp", 92.75);
        Item item4 = new Item("4", "Bookshelf", 215.30);
        Item item5 = new Item("5", "Sectional Sofa", 1349.95);
        Item item6 = new Item("6", "Dining Set", 879.00);
        Item item7 = new Item("7", "Nightstand", 99.99);
        Item item8 = new Item("8", "Office Desk", 450.50);
        Item item9 = new Item("9", "TV Stand", 275.20);
        Item item10 = new Item("10", "Wardrobe Closet", 599.00);

        Customer customerOfir = new Customer("849594930", "Ofir","Az","ofir@example.com","some adress 3/5",CustomerType.VIP, 50.0);
        Customer customerDemo = new Customer("741574811", "Demo","bob","Demo@example.com","New York, NY 7021, USA",CustomerType.REGULAR,0.0);

        RegularOrder order1 = new RegularOrder("ORD1","Order1", customerOfir.getCustomerDeliveryAddress(), Arrays.asList(item1, item2, item3),customerOfir, PaymentType.CREDIT_CARD, new Date());
        RegularOrder order2 = new RegularOrder("ORD2","Order2", customerDemo.getCustomerDeliveryAddress(), Arrays.asList(item4, item5),customerDemo, PaymentType.CASH, new Date());
        VIPOrder order3 = new VIPOrder("ORD3","Order3", customerOfir.getCustomerDeliveryAddress(), Arrays.asList(item6, item7, item8, item9, item10),customerOfir, PaymentType.CASH, new Date());
        System.out.println("\n....Order Summary Test....\n");
        printOrderSummary(order1);
        printOrderSummary(order2);
        printOrderSummary(order3);
        System.out.println("\n....Gift Test....\n");
        customerOfir.giveGift(new SomeGift());
        customerOfir.openGift();

    }

    private static void printOrderSummary(Order order) {
        boolean orderIsVip = order instanceof VIPOrder;
        String orderType = orderIsVip ? "VIP" : "Regular";

        System.out.println("\nOrder ID: " + order.getOrderId());
        System.out.println("Order Type: " + orderType);
        System.out.println("Customer: " + order.getOrderCustomer().getCustomerFirstName());
        System.out.println("Items:");
        for (Item item : order.getOrderItems()) {
            System.out.println(" - " + item.getItemName() + " ($" + item.getItemPrice() + ")");
        }
        System.out.println("Total: $" + order.calculateOrderTotalPrice());
        if(orderIsVip) {
            System.out.println("Discount: $" + order.getOrderCustomer().getCustomerDiscount());
        }
        System.out.println("--------------------");
    }
}
