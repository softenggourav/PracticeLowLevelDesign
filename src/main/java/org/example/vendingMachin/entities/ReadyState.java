package org.example.vendingMachin.entities;

import org.example.vendingMachin.enums.Coin;
import org.example.vendingMachin.enums.Note;

public class ReadyState implements VendingMachineState {
    private final VendingMachine machine;

    public ReadyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(String productName) {
        System.out.println("Product already selected");
    }

    @Override
    public void insertCoin(Coin coin) {
        machine.addPayment(coin.getValue());

    }

    @Override
    public void insertNote(Note note) {
        machine.addPayment(note.getValue());

    }

    @Override
    public void dispenseProduct() {
        Product p = machine.getInventory().getProduct(machine.getSelectedProduct());
        if (machine.getPayment() >= p.getPrice()) {
            machine.setState(machine.getDispenseState());
            machine.dispenseProduct();
        } else {
            System.out.println("Insufficient payment, Price: " + p.getPrice());
        }

    }

    @Override
    public void returnChange() {
        machine.setState(machine.getReturnChangeState());
        machine.returnChange();
    }
}
