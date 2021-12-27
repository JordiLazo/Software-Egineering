package readerswriters.favorreader;

public class FavorReadersApp {

    public static void main(String[] args) {
        ReadWrite sharedResource = new FavorReaders();

        Thread[] readers = new Thread[4];
        for (int i = 0; i < readers.length ; i++) {
            ReaderClass reader = new ReaderClass(sharedResource);
            readers[i] = new Thread(reader,"Reader " + i);
            readers[i].start();
        }

        Thread[] writers = new Thread[2];
        for (int i = 0; i < writers.length ; i++) {
            Writer writer = new Writer(sharedResource);
            writers[i] = new Thread(writer,"Writer " + i);
            writers[i].start();
        }
    }
}
