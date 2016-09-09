package se.tacton.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
Problem: Phone List
Given a list of phone numbers, determine if it is consistent in the sense that no number is the prefix of another. Let’s say the phone catalogue listed these numbers:
	•	Emergency 911
	•	Alice 97 625 999
	•	Bob 91 12 54 26
In this case, it’s not possible to call Bob, because the central would direct your call to the emergency line as soon as you had dialed the first three digits of Bob’s phone number. So this list would not be consistent.
Input
The first line of input gives a single integer, 1≤t≤40 , the number of test cases. Each test case starts with n, the number of phone numbers, on a separate line, 1≤n≤10000. Then follows n lines with one unique phone number on each line. A phone number is a sequence of at most ten digits. Note that leading zeros in phone numbers are significant, e.g., “0911” is a different phone number than “911”.
Output
For each test case, output “YES” if the list is consistent, or “NO” otherwise.

Sample Input 1
---------------
2
3
911
97625999
91125426
5
113
12340
123440
12345
98346
Sample Output 1
---------------
NO
YES
*
* */

/*
* 1.   Sort alphanumerically
* 2.   Traverse 1st to last and check whether i-th number is prefix of (i + 1)-th number.
* 2.1. If no, print NO and exit
* 2.2. Otherwise, continue and at the end of loop print YES
*
* */

public class PhoneList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            int numberCount = scanner.nextInt();

            scanner.nextLine();

            List<String> numbers = new ArrayList<>();
            for (int j = 0; j < numberCount; j++) {
                numbers.add(scanner.nextLine());
            }

            if (isConsistentPhoneList(numbers)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isConsistentPhoneList(List<String> numbers) {
        Collections.sort(numbers);

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i).startsWith(numbers.get(i - 1))) {
                return false;
            }
        }
        return true;
    }
}
