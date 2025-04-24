package org.example.vendingMachin.entities;

import org.example.vendingMachin.enums.Coin;
import org.example.vendingMachin.enums.Note;

public class IdleState implements VendingMachineState {
    private final VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(String productName) {
        if (machine.getInventory().isAvailable(productName)) {
            machine.setSelectedProduct(productName);
            machine.setState(machine.getReadyState());
            System.out.println("Product selected: " + productName);
        } else {
            System.out.println("Product not available");
        }


    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Select product first");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Select product first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Select product first");
    }

    @Override
    public void returnChange() {
        System.out.println("Nothing to return");
    }
}
