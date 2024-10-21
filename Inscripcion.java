import java.util.Scanner;

public class Inscripcion {
    public static void main(String[] args) {
        int points = 0; // Punts totals acumulats per l'alumne
        int alumn = 0; // Número de registre de l'alumne
        Scanner scanner = new Scanner(System.in);

        // Bucle per sol·licitar el número fins que sigui vàlid
        boolean inputValid = false; // Variable per controlar la validesa de l'input

        while (!inputValid) {
            System.out.println("Quin és el nombre d'inscripció de l'alumne?");
            if (scanner.hasNextInt()) { // Comprovar si l'entrada és un enter
                alumn = scanner.nextInt(); // Llegir el número de registre de l'entrada de l'usuari
                
                // Verificar si el número està dins del rang permès (1 - 499)
                if (alumn < 1 || alumn > 499) {
                    System.out.println("Nombre de registre invàlid. Ha d'estar entre l'1 i el 499.");
                } else {
                    inputValid = true; // L'input és vàlid
                }
            } else {
                System.out.println("Entrada invàlida. Si us plau, introdueix un número enter.");
                scanner.next(); // Netejar l'entrada incorrecta
            }
        }

        // Missatge de confirmació de registre vàlid
        System.out.println("Número de registre vàlid: " + alumn);

        // Netejar el buffer del scanner per evitar problemes amb nextLine()
        scanner.nextLine(); 

        // Preguntar informació addicional per calcular els punts
        System.out.println("Té l'alumne almenys un germà al centre? y/n");
        String brotherString = scanner.nextLine(); // Llegir resposta sobre germans
        System.out.println("Viu a la mateixa població on s'ubica el centre? y/n");
        String locationString = scanner.nextLine(); // Llegir resposta sobre la població de residència
        System.out.println("Algun dels pares fa feina a la mateixa població on s'ubica el centre? y/n");
        String workString = scanner.nextLine(); // Llegir resposta sobre el lloc de treball dels pares
        System.out.println("Té l'alumne cap discapacitat superior al 33% o malaltia crònica? y/n");
        String disableString = scanner.nextLine(); // Llegir resposta sobre discapacitat o malaltia
        System.out.println("Forma part l'alumne d'una família nombrosa o monoparental? y/n");
        String familyString = scanner.nextLine(); // Llegir resposta sobre família nombrosa o monoparental

        // Calcular els punts basant-se en les respostes de l'usuari
        if (brotherString.equals("y")) {
            points += 40; // 40 punts per tenir almenys un germà al centre
        }
        if (locationString.equals("y")) {
            points += 30; // 30 punts per viure a la mateixa població on es troba el centre
        }
        if (workString.equals("y")) {
            points += 20; // 20 punts si algun dels pares treballa a la població del centre
        }
        if (disableString.equals("y")) {
            points += 10; // 10 punts si l'alumne té una discapacitat o malaltia crònica
        }
        if (familyString.equals("y")) {
            points += 15; // 15 punts per ser part d'una família nombrosa o monoparental
        }

        // Mostrar el resultat final amb els punts totals de l'alumne
        System.out.println("L'alumne " + alumn + " té " + points + " punts.");

        // Tancar el scanner
        scanner.close();
    }
}