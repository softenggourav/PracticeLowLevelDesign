package org.example.vendingMachin.entities;

import org.example.vendingMachin.enums.Coin;
import org.example.vendingMachin.enums.Note;

public class DispenseState implements VendingMachineState {
    private final VendingMachine machine;

    public DispenseState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(String productName) {
        System.out.println("Dispensing in progress");
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
        Product p = machine.getInventory().getProduct(machine.getSelectedProduct());
        p.reduceQuantity();
        System.out.println("Dispensed Product: " + p.getName());
        machine.setState(machine.getReturnChangeState());
        machine.returnChange();

    }

    @Override
    public void returnChange() {
        System.out.println("Dispense first");
    }
}
