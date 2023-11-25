package com.techelevator;

public class Mod1Assessment {

  private PC gateway;

    public static void main(String[] args) {
        //make an instance of PC
//       PC dell = returnDellPC();
//        dell.getCpu();
        PC hp = new PC("DAM", "16GB", "EONRAD");
//        System.out.println(dell);
//        System.out.println(hp);

        System.out.println("printing gateway:");
   //    System.out.println(gateway);

        PCStore pcStore = new PCStore();
        pcStore.methodUsingDumbStaticVariable();
        System.out.println("printing gateway after static changes:");
    //    System.out.println(gateway);
    }


    public void returnDellPC(){
        gateway = new PC("NITEL", "8GB", "FORCEG");
        gateway.setGraphicsCard("Bob the builder");

    }

    public void anotherNonStaticMethod(){
        gateway.setMemory("100MB");
    }




}
