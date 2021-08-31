package threads;

public class threads extends Thread{
    private String stringParam;

    public threads(String stringParam) {
        this.stringParam = stringParam;
    }

    public static void main(String[] args) {
        threads t1 = new threads("Jordi");
        t1.start();
        threads t2 = new threads("Lazo");
        t2.setDaemon(true);
        t2.start();
        sleepASecond();
        t1.setStrParam("exit");
    }

    private void setStrParam(String param) {
        this.stringParam = param;
    }

    @Override
    public void run(){
        while (!"exit".equals(stringParam)){
            System.out.println((isDaemon() ? "daemon ":"user" + " thread ") + this.getName() + "[ID=" + this.getId()+"] passed parameter: " + stringParam);
            sleepASecond();
        }
        System.out.println((isDaemon() ? "daemon ":"user" + " thread ") + this.getName() + "[ID=" + this.getId()+"] passed parameter: " + stringParam);
    }


    private static void sleepASecond(){

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
