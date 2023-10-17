package com.techelevator;

public class PC {
    private String cpu;
    private String memory;
    private String graphicsCard;

    public String getCpu() {
        return cpu;
    }

    public String getMemory() {
        return memory;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    //build constructor:
    public PC(String cpu, String memory, String graphicsCard){
        this.cpu = cpu;
        this.memory = memory;
        this.graphicsCard = graphicsCard;
    }

    public double getPrice(){
        double price = 800.00;
        if(cpu.equals("NITEL")){
            price += 300.00;
        }else {
            price += 250.00;
        }

        if(memory.equals("8GB")){
            price += 400.00;
        } else if(memory.equals("16GB")){
            price += 700.00;
        } else {
            price += 1000.00;
        }

        if(graphicsCard.equals("FORCEG")){
            price += 500.00;
        } else {
            price += 350.00;
        }
        return price;
    }

    @Override
    public String toString() {

        return "-------------------- CPU: " + cpu + " | " +"Memory: " + memory + " | Graphics: " + graphicsCard + " Total Price: "+ getPrice() +" ---------------";
    }
}
