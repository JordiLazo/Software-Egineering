package Question_3_RMI_and_Proxy.proxy;

public class ProxyPatterDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");
        image.display();
        System.out.println("\n");

        image.display();
    }
}
