# 10th Jan 2026
## Score of a String
In Java, when you do arithmetic with char (like 's' - 'a'), 
both chars are implicitly promoted to int (Unicode code units), and the result is an int.
```
    int diff = 's' - 'a';   // 115 - 97 = 18
    System.out.println(diff); // 18
```

When you would need a cast:
```
    char next = (char) ('a' + 1); // without the cast, result is int
```

```
    if(s.charAt(i-1) > 0x7F/127 || s.charAt(i) > 0x7F/127) {
        return -1;
    }
    
    If the value of the character is greater than 127, then it is not an English alphabet between A-Z and a-z
    
    static boolean isAsciiLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
```