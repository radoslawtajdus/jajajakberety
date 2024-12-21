import java.util.Scanner;


class RadoslawTajdus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayHeader();
        System.out.println("Witaj w aplikacji biletomat!");
        System.out.println("Naciśnij ENTER aby przejść dalej.");
        waitForEnter(scanner);

        clearConsole();
        displayHeader();
        System.out.println("Wybierz miasto dla którego chcesz kupić bilet:");
        System.out.println("1. Łódź");
        System.out.println("2. Wrocław");
        System.out.println("3. Warszawa");
        System.out.println("4. Poznań");

        int cityChoice = getChoice(scanner, 1, 4);

        String city = "";
        String ticketInfo = "";

        switch (cityChoice) {
            case 1:
                city = "Łódź";
                ticketInfo = getTicket(scanner, "Łódź", new String[] {
                        "Ulgowy 20 minut cena 2,20",
                        "Ulgowy 40 minut cena 4,40",
                        "Normalny 20 minut cena 2,80",
                        "Normalny 40 minut cena 5,60"
                });
                break;

            case 2:
                city = "Wrocław";
                ticketInfo = getTicket(scanner, "Wrocław", new String[] {
                        "Ulgowy 20 minut cena 2,00",
                        "Ulgowy 40 minut cena 4,00",
                        "Normalny 20 minut cena 2,50",
                        "Normalny 40 minut cena 5,00"
                });
                break;

            case 3:
                city = "Warszawa";
                ticketInfo = getTicket(scanner, "Warszawa", new String[] {
                        "Ulgowy 20 minut cena 1,50",
                        "Ulgowy 40 minut cena 3,00",
                        "Normalny 20 minut cena 2,00",
                        "Normalny 40 minut cena 4,00"
                });
                break;

            case 4:
                city = "Poznań";
                ticketInfo = getTicket(scanner, "Poznań", new String[] {
                        "Ulgowy 20 minut cena 1,80",
                        "Ulgowy 40 minut cena 3,60",
                        "Normalny 20 minut cena 2,00",
                        "Normalny 40 minut cena 4,00"
                });
                break;
        }

        clearConsole();
        displayHeader();
        System.out.println("Dokonałeś zakupu!");
        System.out.println("Miasto: " + city);
        System.out.println("Bilet: " + ticketInfo);
        System.out.println("Dziękujemy za skorzystanie z aplikacji biletomat!");

        scanner.close();
    }

    private static int getChoice(Scanner scanner, int min, int max) {
        int choice;
        while (true) {
            System.out.print("Twój wybór: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Konsumuj nową linię
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } else {
                scanner.nextLine();
            }
            displayHeader();
            System.out.println("Nieprawidłowy wybór. Spróbuj ponownie (1, 2, 3, lub 4).");
        }
    }

    private static void waitForEnter(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            displayHeader();
            System.out.println("Naciśnij Enter, aby kontynuować.");
        }
    }

    private static String getTicket(Scanner scanner, String city, String[] tickets) {
        clearConsole();
        displayHeader();
        System.out.println("Miasto: " + city);
        System.out.println("Wybierz jaki chcesz kupić bilet:");

        for (int i = 0; i < tickets.length; i++) {
            System.out.println((i + 1) + ". " + tickets[i]);
        }

        int ticketChoice = getChoice(scanner, 1, tickets.length);
        return tickets[ticketChoice - 1];
    }

    private static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static void displayHeader() {
        System.out.println("Radosław Tajduś 122745");
    }
}
