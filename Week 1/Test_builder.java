
package Builder_example;

public class Test_builder {
    public static void main(String[] args) {
        Computer gamingCp = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setOS("Windows 11")
                .build();

        Computer officeCp = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setOS("Windows 10")
                .build();

        Computer budgetCp = new Computer.Builder()
                .setCPU("AMD Ryzen 3")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .setOS("Linux")
                .build();

        // Print the configurations
        System.out.println("Gaming Computer: " + gamingCp);
        System.out.println("Office Computer: " + officeCp);
        System.out.println("Budget Computer: " + budgetCp);
    }
}

