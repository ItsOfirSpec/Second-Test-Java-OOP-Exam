public class SomeGift implements Gift {
    @Override
    public void openGift(String CustomerName) {
        System.out.println("Congratulations! " + CustomerName + ", you got a new gift! Enjoy!");
    }
}
