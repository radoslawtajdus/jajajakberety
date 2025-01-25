using System;
// Radosław Tajduś 122745 gr.4 praca zaliozeniowa - sprzedaż biletów, podstawy programowania, Społeczna Akademia Nauk, Łódź
class Radoslawtajdus
{
    static void Main()
    {
        // Wyświetla ekran powitalny i czeka na naciśnięcie klawisza Enter
        Console.WriteLine("Radosław Tajduś 122745");
        Console.WriteLine("Witaj w aplikacji biletomat!");
        Console.WriteLine("Naciśnij ENTER aby przejść dalej.");
        WaitForEnter();

        // Czyści ekran i wyświetla listę miast do wyboru.
        Console.Clear();
        Console.WriteLine("Wybierz miasto dla którego chcesz kupić bilet:");
        Console.WriteLine("1. Łódź");
        Console.WriteLine("2. Wrocław");
        Console.WriteLine("3. Warszawa");
        Console.WriteLine("4. Poznań");

        // Odczytuje wybór użytkownika dotyczący miasta.
        int cityChoice = GetChoice(1, 4);

        string city = "";
        string ticketInfo = "";

        // Przypisuje odpowiednie miasto i listę biletów w zależności od wyboru użytkownika.
        switch (cityChoice)
        {
            case 1:
                city = "Łódź";
                ticketInfo = GetTicket("Łódź", new string[] {
                    "Ulgowy 20 minut cena 2,20",
                    "Ulgowy 40 minut cena 4,40",
                    "Normalny 20 minut cena 2,80",
                    "Normalny 40 minut cena 5,60"
                });
                break;

            case 2:
                city = "Wrocław";
                ticketInfo = GetTicket("Wrocław", new string[] {
                    "Ulgowy 20 minut cena 2,00",
                    "Ulgowy 40 minut cena 4,00",
                    "Normalny 20 minut cena 2,50",
                    "Normalny 40 minut cena 5,00"
                });
                break;

            case 3:
                city = "Warszawa";
                ticketInfo = GetTicket("Warszawa", new string[] {
                    "Ulgowy 20 minut cena 1,50",
                    "Ulgowy 40 minut cena 3,00",
                    "Normalny 20 minut cena 2,00",
                    "Normalny 40 minut cena 4,00"
                });
                break;

            case 4:
                city = "Poznań";
                ticketInfo = GetTicket("Poznań", new string[] {
                    "Ulgowy 20 minut cena 1,80",
                    "Ulgowy 40 minut cena 3,60",
                    "Normalny 20 minut cena 2,00",
                    "Normalny 40 minut cena 4,00"
                });
                break;
        }

        // Wyświetla podsumowanie zakupu: wybrane miasto i bilet.
        Console.Clear();
        Console.WriteLine("Dokonałeś zakupu!");
        Console.WriteLine("Miasto: " + city);
        Console.WriteLine("Bilet: " + ticketInfo);
        Console.WriteLine("Dziękujemy za skorzystanie z aplikacji biletomat!");
    }

    // Funkcja do odczytywania wyboru użytkownika w danym zakresie.
    static int GetChoice(int min, int max)
    {
        int choice;
        while (true)
        {
            Console.Write("Twój wybór: ");
            string input = Console.ReadLine();
            if (int.TryParse(input, out choice) && choice >= min && choice <= max)
            {
                return choice;
            }
            // Wyświetla komunikat o błędzie, jeśli użytkownik wprowadził nieprawidłową wartość.
            Console.WriteLine("Nieprawidłowy wybór. Spróbuj ponownie (1, 2, 3, lub 4).");
        }
    }

    // Funkcja do oczekiwania na naciśnięcie klawisza Enter.
    static void WaitForEnter()
    {
        while (true)
        {
            if (Console.ReadKey(true).Key == ConsoleKey.Enter)
            {
                break;
            }
            // Wyświetla komunikat, jeśli użytkownik nacisnął inny klawisz niż Enter.
            Console.WriteLine("Naciśnij Enter, aby kontynuować.");
        }
    }

    // Funkcja do wyświetlania listy biletów i odczytywania wyboru użytkownika.
    static string GetTicket(string city, string[] tickets)
    {
        // Czyści ekran i wyświetla listę biletów dla wybranego miasta.
        Console.Clear();
        Console.WriteLine($"Miasto: {city}");
        Console.WriteLine("Wybierz jaki chcesz kupić bilet:");
        for (int i = 0; i < tickets.Length; i++)
        {
            Console.WriteLine($"{i + 1}. {tickets[i]}");
        }

        // Odczytuje wybór użytkownika dotyczący biletu.
        int ticketChoice = GetChoice(1, tickets.Length);
        return tickets[ticketChoice - 1];
    }
}
