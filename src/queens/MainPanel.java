package queens;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    private final static int MAX = 8;
    private final Table table = new Table(MAX);
    static ArrayList<Queen> queens = new ArrayList<>();

    public MainPanel(){
        JButton btnInit = new JButton("Resolver");
        setLayout(new BorderLayout());
        add(table, BorderLayout.CENTER);
        add(btnInit, BorderLayout.SOUTH);

        btnInit.addActionListener(e -> {
            queens.clear();
//            Se llama a la funcion recursiva
            if(queen(0)) {
//            Se colocan las reinas
                for (Queen queen : queens) {
                    System.out.println("Vuelta [" + queens.indexOf(queen) + "]: " + +queen.row + ", " + queen.column);
                    ImageIcon icon = new ImageIcon("src/queen.png");
                    Image img = table.getScaledImage(icon.getImage(), 80, 80);
                    table.boxes[queen.row][queen.column].setIcon(new ImageIcon(img));
                }
            } else {
//            No tiene solucion
            JOptionPane.showMessageDialog(null, "No existe solución para " + MAX + " reinas");
            }
        });
    }

    public static boolean queen(int column) {
        for(int i = 0; i < MAX; i++) {
            if(validate(i, column)) {
                Queen queen = new Queen(i, column);
                queens.add(queen);

                if(queen(column+1)) return true;

                queens.remove(queen);
            }
        }
        return column >= MAX;
    }

    //    Valida si no se ataca con otra reina
    public static boolean validate(int row, int column) {
        for (Queen queen : queens) if (queen.row == row || diagonal(queen, row, column)) return false;
        return true;
    }

    //    Valida en diagonal
    public static boolean diagonal(Queen queen, int row, int column) {
        return queen.row + queen.column == row + column || queen.row - row == queen.column - column;
    }

}
