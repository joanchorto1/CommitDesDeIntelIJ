import java.util.Scanner;

public class Main {
    static boolean surt = true;
    public static Aliments[] aliments = new Aliments[100];
    static Scanner ent = new Scanner(System.in);
    public static void main(String[] args) {




        while (surt) {
            System.out.println("------------------------------------");
            System.out.println("#             MENÚ                 #");
            System.out.println("------------------------------------");
            System.out.println("1 - Fer una donació");
            System.out.println("2 - Modificar un aliment");
            System.out.println("3 - Mostrar l'inventari del banc de aliments");
            System.out.println("4 - Surt");
            System.out.println("------------------------------------");

            switch (ent.nextLine()) {
                case "1":
                    ferDonacio();
                    break;
                case "2":
                    modificarAliment();
                    break;
                case "3":
                    mostrarInventari();
                    break;
                case "4":
                    crearAliment();
                    break;
                case "5":
                    ferComandaAsociacio();
                    break;
                case "6":
                    sortir();
                    break;
            }
        }
    }

    /**
     * Fa una comanda a un vanc de aliments
     */
    private static void ferComandaAsociacio() {

        Comanda com= new Comanda();
        System.out.println("Quin producte necessites?");
        com.nom=ent.nextLine();
        System.out.println("Quant en vols?");
        com.quantitat= Integer.parseInt(ent.nextLine());
        System.out.println("A quina associació s'ha de enviar?");
        com.ass= Integer.parseInt(ent.nextLine());

        int indexProducte=0;
        for (int i = 0; i < aliments.length; i++) {
            if (aliments[i].getNom().equals(com.nom)){
                indexProducte=i;
            }
        }

        if (aliments[indexProducte].getQuantitat()>com.quantitat){

            System.out.println("La seva comanda de "+ com.quantitat+"kg de"+com.nom+" sera entregada a l'associacio nº "+com.ass);


        }else System.out.println("No es pot realitzar la comanda");


    }

    /**
     * crea una casella al vector aliments[]
     */
    private static void crearAliment() {
        int i = 0;
        for (; i < aliments.length && aliments[i] != null; i++) ;

        System.out.println("Quin aliment vols introduir?");
        aliments[i].setNom(ent.nextLine());
        aliments[i].setQuantitat(0);


    }

    /**
     * canvia el nom del aliment de la casella del vector escollida
     */
    private static void modificarAliment() {
        mostrarInventari();
        System.out.println("Quin element vols modificar?");
        int i= Integer.parseInt(ent.nextLine());
        System.out.println("Quin nom li vols ficar?");
        aliments[i].setNom(ent.nextLine());
    }


    /**
     * fa un sout de totes les caselles del vector
     */
    private static void mostrarInventari() {
        for (int i = 0; i < aliments.length && aliments[i] != null; i++) {
            System.out.println(i + " - " + aliments[i]);
        }
    }

    /**
     * canvia el tipus de la variable booleana, per a que es tanque el while
     */
    private static void sortir() {
        System.out.println("Adeú");
        surt = false;
    }


    /**
     * modifica el atribut quantitat del aliment de la casella seleccionada.
     */
    private static void ferDonacio() {
        mostrarInventari();
        System.out.println("Selecciona quin aliment vols donar");
        int index = Integer.parseInt(ent.nextLine());
        System.out.println("Quina quantitat vols donar?");
        int quant = Integer.parseInt(ent.nextLine());
        aliments[index].setQuantitat(aliments[index].getQuantitat()+quant);
    }
}
