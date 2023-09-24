package Container;

public class TestContainer {
    public static void main(String[] args) {
        Port A = new Port("A", 19.017656, 72.856178);
        Port B = new Port("B", 40.7127, -74.0059);
        Container dry1 =  new DryStorage("1", 15);
        Container re1 =  new Refrigerated("2", 20);
        System.out.println(re1);
        System.out.println(dry1);
    }
}
