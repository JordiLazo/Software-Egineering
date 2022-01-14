package Question_3_RMI_and_Proxy.proxy;

public class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadfromDisk(fileName);
    }

    private void loadfromDisk(String fileName) {
        System.out.println("Loading from disk "+ fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying from proxy "+ fileName);
    }
}
