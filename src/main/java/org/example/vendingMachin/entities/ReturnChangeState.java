package org.example.vendingMachin.entities;

import org.example.vendingMachin.enums.Coin;
import org.example.vendingMachin.enums.Note;

public class ReturnChangeState implements VendingMachineState {
    private final VendingMachine machine;

    public ReturnChangeState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(String productName) {
        System.out.println("Transaction in progress");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please wait");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please wait");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Already dispensed");
    }

    @Override
    public void returnChange() {
        Product p = machine.getInventory().getProduct(machine.getSelectedProduct());
        int change = machine.getPayment() - p.getPrice();
        if (change > 0) {
            System.out.println("Return change: " + change);
        }
        machine.reset();
        machine.setState(machine.getIdleState());
    }
}
