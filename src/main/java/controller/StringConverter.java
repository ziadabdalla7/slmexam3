package controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/string")
public class StringConverter {
    private String lastModString;
    private int lastModStringLength;

    @PostMapping
    public String modifyString(@RequestBody String input){
        StringBuilder modifiedString = new StringBuilder();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (i % 2 == 0) {
                modifiedString.append(Character.toLowerCase(c));
            } else {
                modifiedString.append(Character.toUpperCase(c));
            }
        }
        lastModString = modifiedString.toString();
        lastModStringLength = lastModString.length();
        return lastModString;
    }

    @GetMapping
    public int getLastModStringLength() {
        return lastModStringLength;
    }

}