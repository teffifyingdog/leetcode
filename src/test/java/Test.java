import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Byte, Integer> map = new HashMap<>();
        map.put((byte) 'a',1);
        System.out.println(map.get((byte) 'a'));
        System.out.println(map.get((byte) 'b'));
    }
}
