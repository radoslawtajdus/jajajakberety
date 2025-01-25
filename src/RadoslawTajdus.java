import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Radosław Tajduś 122745 gr.4 praca zaliozeniowa, podstawy programowania, Społeczna Akademia Nauk, Łódź
class RadoslawTajdus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> purchases = new ArrayList<>();
        double totalPrice = 0.0;

        while (true) {
            displayHeader();
            System.out.println("Witaj w aplikacji biletomat!");
            System.out.println("Aplikacji w której kupisz bilety komunikacji miejskiej!");
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
            String[] tickets = null;

            switch (cityChoice) {
                case 1:
                    city = "Łódź";
                    tickets = new String[] {
                            "Ulgowy 20 minut cena 2,20",
                            "Ulgowy 40 minut cena 4,40",
                            "Normalny 20 minut cena 2,80",
                            "Normalny 40 minut cena 5,60"
                    };
                    break;
                case 2:
                    city = "Wrocław";
                    tickets = new String[] {
                            "Ulgowy 20 minut cena 2,00",
                            "Ulgowy 40 minut cena 4,00",
                            "Normalny 20 minut cena 2,50",
                            "Normalny 40 minut cena 5,00"
                    };
                    break;
                case 3:
                    city = "Warszawa";
                    tickets = new String[] {
                            "Ulgowy 20 minut cena 1,50",
                            "Ulgowy 40 minut cena 3,00",
                            "Normalny 20 minut cena 2,00",
                            "Normalny 40 minut cena 4,00"
                    };
                    break;
                case 4:
                    city = "Poznań";
                    tickets = new String[] {
                            "Ulgowy 20 minut cena 1,80",
                            "Ulgowy 40 minut cena 3,60",
                            "Normalny 20 minut cena 2,00",
                            "Normalny 40 minut cena 4,00"
                    };
                    break;
            }

            String ticketInfo = getTicket(scanner, city, tickets);
            double ticketPrice = extractPrice(ticketInfo);

            System.out.println("Podaj, ile sztuk tego biletu chcesz kupić:");
            int quantity = getChoice(scanner, 1, 100);

            purchases.add(formatPurchase(city, ticketInfo, quantity));
            totalPrice += ticketPrice * quantity;

            System.out.println("Czy chcesz dokonać kolejnego zakupu? (tak/nie)");
            String decision = scanner.nextLine().trim().toLowerCase();
            if (decision.equals("nie")) {
                break;
            }
            clearConsole();
        }

        clearConsole();
        displayHeader();
        purchasesSummary(purchases);
        System.out.printf("\nŁączna suma za wszystkie bilety: %.2f zł\n", totalPrice);
        scanner.close();
    }

    private static int getChoice(Scanner scanner, int min, int max) {
        int choice;
        while (true) {
            System.out.print("Twój wybór: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } else {
                scanner.nextLine();
            }
            displayHeader();
            System.out.println("Nieprawidłowy wybór. Spróbuj ponownie (" + min + " - " + max + ").");
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

    private static double extractPrice(String ticketInfo) {
        String[] parts = ticketInfo.split(" ");
        for (String part : parts) {
            if (part.matches("\\d+,\\d{2}")) {
                return Double.parseDouble(part.replace(",", "."));
            }
        }
        return 0.0;
    }

    private static String formatPurchase(String city, String ticketInfo, int quantity) {
        return "Miasto: " + city + ", Bilet: " + ticketInfo + ", Sztuk: " + quantity;
    }

    private static void purchasesSummary(List<String> purchases) {
        System.out.println("Twoje zakupy:");
        for (String purchase : purchases) {
            System.out.println("- " + purchase);
        }
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
