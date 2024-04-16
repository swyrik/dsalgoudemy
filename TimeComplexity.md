### Time Complexity

Omega: BestCase
Theta: Worst Case
Omicron: Avg Case

Big O is always worst case

O(n)

when measuring time complexity
1) Drop non dominants (n^2 + n) = O(n^2)
2) Drop Constants (2n) = O(n)


```Java
class Solution {
    public static void printItems(int a, int b) {
        for (int i = 0; i < a; i++) {
            System.out.println(i);
        }

        for (int j = 0; j < b; j++) {
            System.out.println(j);
        }
    }

    public static void multiIems(int a, int b) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.println(j);
            }
        }
    }
}
```

the time complexity of printItems in Solution class is O(a+b)

the time complexity of multiItems in Solution class is O(a*b)