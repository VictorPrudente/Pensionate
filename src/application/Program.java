/* a simple program made to exercise "vectors", "for" and "OOP".
* The pensionate has 10 rooms. The student makes his own reservation and the
* program must inform him weather the room is occupied or not, and if its a valid input
* After that, it prints a description of the occupied rooms and their respective occupants.*/

package application;

import entities.Students;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        Students[] rooms = new Students[10];
        Students students;
        System.out.print("How many students will rent a room? ");
        int rents = sc.nextInt();
        int room;
        for (int i = 0; i < rents; i++) {
            sc.nextLine();
            System.out.printf("Rent #%d:%n", i + 1);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            do {
                System.out.print("Room(0-9): ");
                room = sc.nextInt();
                if (room < 0 || room > 9){
                    System.out.println("Invalid room. Please, choose from 0 to 9.");
                } else if (rooms[room] != null) {
                    System.out.printf("Room %d is occupied. Please, choose another one.", room);
                }
            } while (room < 0 || room > 9 || rooms[room] != null);

            students = new Students(name, email, room);
            rooms[room] = students;
        }
            for (Students obj : rooms) {
            if (obj != null) {
                System.out.println(obj);
            }
        }
        sc.close();
    }
}
