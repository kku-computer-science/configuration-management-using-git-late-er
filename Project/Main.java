//663380226-7
//ฟังก์ชั่น Bubble Sort
package Project;
import java.util.Arrays;
import java.util.Scanner;

public class Main {//663380226-7
package Project;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = null;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter the inputs (Seperate by Spacebar): ");
                String input = sc.nextLine();

                //ถ้าไม่ใส่ Input จะขึ้น Error นี้
                if (input.trim().isEmpty()) {
                    System.out.println("Error... Type the numbers down, go try again.\n");
                    continue;
                }

                // แปลง String ให้เป็น int Array และแยกค่า Input ด้วย Spacebar (Blank)
                String[] strArr = input.trim().split("\\s+");
                arr = new int[strArr.length];

                for (int i = 0; i < strArr.length; i++) {
                    arr[i] = Integer.parseInt(strArr[i]);
                }

                validInput = true; 

            } catch (NumberFormatException e) {
                System.out.println("Error... Invalid inputs, try again.");
            }
        }

        int choice = 0;
        boolean validChoice = false;

        while (!validChoice) {
            try {
                System.out.println("\nWhich sort algorithm would you like to use?:");
                System.out.println("1. Quick Sort");
                System.out.println("2. Bubble Sort");
                System.out.print("Enter your choice (1 or 2): ");
                
                String choiceInput = sc.nextLine();
                
                //ถ้่าไม่ได้ใส่ Input จะขึ้น Error นี้
                if (choiceInput.trim().isEmpty()) {
                    System.out.println("Error: Input cannot be empty. Please try again.\n");
                    continue;
                }
                
                choice = Integer.parseInt(choiceInput);

                if (choice == 1 || choice == 2) {
                    validChoice = true;
                } else {
                    System.out.println("Error... Please choose only 1 or 2.\n");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error... Please choose only 1 or 2.\\n");
            }
        }

        System.out.println("\nBefore Sorted: " + Arrays.toString(arr));

        //จับเวลาเริ่ม (หน่วย nanosecond)
        long startTime = System.nanoTime();
        
        //รัน Algorithm ตามที่เลือก
        if (choice == 1) {
            quicksort.sort(arr, 0, arr.length - 1);
            System.out.println("Using Quick Sort");
        } else {
            bubblesort.sort(arr);
            System.out.println("Using Bubble Sort");
        }
        
        long endTime = System.nanoTime();

        //แสดงผลลัพธ์
        System.out.println("After Sorted: " + Arrays.toString(arr));
        System.out.println("Time Taken: " + (endTime - startTime) / 1000000.0 + " ms");

        sc.close();
    }
}