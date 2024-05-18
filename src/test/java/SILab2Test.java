import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private List<Item> createItemsList() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", "0123456", 350, 0.10f));
        items.add(new Item("Item2", "654321", 10, 0));
        items.add(new Item(null, "111111", 300, 0.3f));
        items.add(new Item("Item3", "", 90, 0.1f));
        return items;
    }

    @Test
    void everyBranchTest() {
        RuntimeException ex;

        //Test 1 - allItems is null
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 0));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        //Test 2 - invalid character in barcode
        List<Item> items1 = createItemsList();
        items1.add(new Item("Item4", "1234a6", 400, 0.4f));
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items1, 0));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        //Test 3 - empty list
        List<Item> items2 = new ArrayList<>();
        assertTrue(SILab2.checkCart(items2, 0));

        //Test 4 - item has null barcode
        List<Item> items3 = createItemsList();
        items3.add(new Item("Item4", null, 400, 0.4f));
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items3, 0));
        assertTrue(ex.getMessage().contains("No barcode!"));

        //Test 5 - sum > payment
        List<Item> items4 = createItemsList();
        assertFalse(SILab2.checkCart(items4, 100));

        //Test 6 - Backup test to check sum<=payment for non-empty list
        List<Item> items5 = createItemsList();
        assertTrue(SILab2.checkCart(items5, 1000));

    }

    @Test
    void multipleConditionTest() {
        //(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')

        //Test 1 - TTT
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("Item1", "0123456", 350, 0.10f));
        //sum = 350 - 350*0.10 = 315
        //Initially payment < sum , so it should return false, but we are checking for TTT
        assertTrue(SILab2.checkCart(items1, 315));

        //Test 2 - TTF
        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("Item1", "123456", 350, 0.10f));
        //sum = 350
        //Initially payment < sum , and we are checking for TTF, so it should return false
        assertFalse(SILab2.checkCart(items2, 300));

        //Test 3 - TFX
        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("Item1", "123456", 350, 0f));
        items3.add(new Item("Item2", "0654321", 350, 0f));
        //sum = 350 + 350 = 700 , if the if statement is true, the sum would be less than 700, the sum-=30 would never be executed
        //Initially payment < sum , and we are checking for TFX, so it should return false
        assertFalse(SILab2.checkCart(items3, 699));

        //Test 4 - FXX
        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("Item1", "123456", 100, 0.1f));
        items4.add(new Item("Item2", "0654321", 100, 0.1f));
        items4.add(new Item("Item3", "0654321", 100, 0f));
        items4.add(new Item("Item4", "123456", 100, 0f));
        //sum = 90 + 90 + 100 + 100 = 380, if the if statement is true, the sum would be less than 380, the sum-=30 would never be executed
        //Initially payment < sum , and we are checking for FXX, so it should return false
        assertFalse(SILab2.checkCart(items4, 379));

    }

}