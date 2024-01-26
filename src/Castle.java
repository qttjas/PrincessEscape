import java.util.Scanner;

public class Castle {
    private int roomVisits = 0;
    private Scanner scanner = new Scanner(System.in);

    public static void handleDragonDrop(String droppedItem) {
    }

    private int getUserChoice(String options) {
        System.out.println(options);
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void start() {
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: Hello, you're the " + ConsoleUtility.PURPLE + "princess" + ConsoleUtility.CYAN + " of the castle \uD83C\uDFF0!!", 1);
        ConsoleUtility.clearScreen();
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: Not anymore though because you have to " + ConsoleUtility.BLUE + "escape" + ConsoleUtility.CYAN + " the place \uD83D\uDE08...", 1);
        ConsoleUtility.clearScreen();
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: Don't worry because the end will be " + ConsoleUtility.YELLOW + "worth" + ConsoleUtility.CYAN + " it.", 3);
        ConsoleUtility.clearScreen();
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: You start with 50 health, and your end goal is to reach the " + ConsoleUtility.RED + "exit" + ConsoleUtility.CYAN + ".", 2);
        ConsoleUtility.clearScreen();
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: Sounds simple? Well, we shall see.", 3);
        ConsoleUtility.clearScreen();
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: We forgot to mention that you're really " + ConsoleUtility.GREEN + "weak" + ConsoleUtility.CYAN + " because you would always rely on prince charming to save you \uD83D\uDE02!!", 1);
        ConsoleUtility.clearScreen();
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: Are you ready, " + ConsoleUtility.PURPLE + "princess" + ConsoleUtility.CYAN + "?", 1);
        ConsoleUtility.clearScreen();
        printWithDelay(ConsoleUtility.PURPLE + "\uD83D\uDC78: I'm ready.", 1);
        startEscape();
    }


    private void startEscape() {
        if (roomVisits < 5) {
            printWithDelay(ConsoleUtility.PURPLE + "\uD83D\uDC78: Should we go left, middle, or right?", 1);

            int roomDirection = getUserChoice("1. Left\n2. Middle\n3. Right");

            handleRoom(roomDirection - 1);

            roomVisits++;

        } else {
            printWithDelay(ConsoleUtility.PURPLE + "\uD83D\uDC78: Should we go left, middle, right, or the exit?", 1);
            int roomExitDirection = getUserChoice("1. Left\n2. Middle\n3. Right\n4. Exit");

            if (roomExitDirection == 4) {
                handleExit();
            } else {
                handleRoom(roomExitDirection - 1);
            }
        }
    }

    private void handleRoom(int roomNumber) {
        if (roomNumber == 0) {
            roomVisits++;
            handleDragonRoom();
        } else if (roomNumber == 1) {
            roomVisits++;
            handleGuardRoom();
        } else if (roomNumber == 2) {
            roomVisits++;
            handleEmptyRoom();
        }

        if (roomVisits < 5) {
            startEscape();
        } else {
            printWithDelay(ConsoleUtility.PURPLE + "\uD83D\uDC78: Should we go left, middle, right, or the exit?", 1);
            int roomDirection = getUserChoice("1. Left\n2. Middle\n3. Right\n4. Exit");

            if (roomDirection == 4) {
                handleExit();
            } else {
                startEscape();
            }

            roomVisits = 0;
        }
    }


    private void handleDragonRoom() {
        Dragon[] dragons = new Dragon[1];
        dragons[0] = new Dragon("Dragon");

        printWithDelay(ConsoleUtility.PURPLE + "\uD83D\uDC78: DRAGON! THERE'S ONE OF THEM!! HELP HELP!", 1);
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: Um, how do you expect help when it's only you and your mindset.", 1);
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: DESTROY IT YOURSELF!", 1);
        printWithDelay(ConsoleUtility.PURPLE + "\uD83D\uDC78: IF I MUST", 1);

        boolean princessSurvived = Dragon.princessFightDragons(new Princess(), dragons);

        if (princessSurvived) {
            startEscape();
        } else {
            printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: The princess was defeated by the dragons.", 1);
        }
    }

    private void handleGuardRoom() {
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: Guards are approaching! You must avoid being seen.", 1);
        printWithDelay(ConsoleUtility.PURPLE + "\uD83D\uDC78: No way, the guards…", 1);
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: If they see you, it’s over!", 1);
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: The guard is about to look over to your direction! Do you..", 1);

        int choice = getUserChoice("1. Don’t move\n2. Hide underneath a table\n3. Laugh");

        if (choice == 2) {
            printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: You chose to hide underneath a table.", 1);
            askGuardQuestion();
        } else {
            printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: The guards caught you.", 1);
        }
    }

    private void askGuardQuestion() {
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: “GUARDS! I think I can sense someone through my third eye” is what you heard. You quickly…", 1);

        int choice = getUserChoice("1. SCREAM\n2. Pray that you’re not caught\n3. Blend in the background");

        if (choice == 1) {
            printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: Your scream alerted the guards.", 1);
        } else if (choice == 2) {
            printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: You prayed and managed to avoid being caught this time.", 1);
            startEscape();
        } else {
            printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: The guards spotted you blending in (You thought it was this one).", 1);
        }
    }

    private void handleEmptyRoom() {
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: You enter an empty room. Nothing seems to be here.", 1);
        printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: What would you like to do?", 1);

        int choice = getUserChoice("1. Explore the room further\n2. Rest for a while\n3. Leave the room");

        if (choice == 1) {
            printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: You explore the room but find nothing of significance.", 1);
            startEscape();
        } else if (choice == 2) {
            printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: You decide to rest for a while.", 1);
            startEscape();
        } else {
            printWithDelay(ConsoleUtility.CYAN + "\uD83D\uDC64: You leave the room and continue your journey.", 1);
            startEscape();
        }
    }

    private void printWithDelay(String message, int seconds) {
        System.out.println(message);
        try {
            Thread.sleep(2000);  // 2000 milliseconds, or 2 seconds
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    private void handleExit() {
        printWithDelay(ConsoleUtility.PURPLE + "\uD83D\uDC78: Is that the sun? I haven’t seen sunlight in 5 years!", 2);
        printWithDelay(ConsoleUtility.PURPLE + "\uD83D\uDC78: I NEED TO TOUCH GRASS RIGHT NOW.", 2);
        printWithDelay(ConsoleUtility.PURPLE + "\uD83D\uDC78: I’M FREE. I’M FREE!!", 2);
        System.exit(0);
    }
}
