package coursework;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running tournament");
        Tournament t = new Tournament(0b10000);
        Player winner = t.play();
        System.out.println(String.format("The winner is %d.", winner.id));
    }
}
