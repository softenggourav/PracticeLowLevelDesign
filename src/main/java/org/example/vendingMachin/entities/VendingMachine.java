package org.example.vendingMachin.entities;

import org.example.vendingMachin.enums.Coin;
import org.example.vendingMachin.enums.Note;

public class VendingMachine {
    private final Inventory inventory;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;

    private VendingMachineState currentState;
    private int payment;
    private String selectedProduct;

    public VendingMachine() {
        this.inventory = new Inventory();
        this.idleState = new IdleState(this);
        this.readyState = new ReadyState(this);
        this.dispenseState = new DispenseState(this);
        this.returnChangeState = new ReturnChangeState(this);
        this.currentState = idleState;
    }

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getReadyState() {
        return readyState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public VendingMachineState getReturnChangeState() {
        return returnChangeState;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public int getPayment() {
        return payment;
    }

    public void addPayment(int amount) {
        payment += amount;
        System.out.println("Inserted rupee: " + amount + " Total rupee: " + payment);
    }

    public String getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(String name) {
        this.selectedProduct = name;
    }

    public void reset() {
        payment = 0;
        selectedProduct = null;
    }

    public void selectProduct(String productName) {
        currentState.selectProduct(productName);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }

}
