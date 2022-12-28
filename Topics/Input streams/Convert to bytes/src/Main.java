import java.io.InputStream;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;

        byte[] bytes = inputStream.readAllBytes();

        IntStream.range(0, bytes.length).map(i -> bytes[i]).forEach(System.out::print);
    }
}