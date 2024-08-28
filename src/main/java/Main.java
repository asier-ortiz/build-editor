import view.Principal;

public class Main {
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.setContentPane(principal.getPrincipalWindow());
        principal.pack();
        principal.setVisible(true);
    }
}