public class GestorLaptops {
    private SimpleLaptopFactory factory;

    public GestorLaptops(SimpleLaptopFactory factory) {
        this.factory = factory;
    }

    public Laptop ordenarLaptop(String tipo) {
        // Delega la creación a la fábrica(factory) sin conocer las clases concretas
        Laptop laptop = factory.createLaptop(tipo);

        if (laptop != null) {
            laptop.ejecutarPrueba(); // Ejecuta la prueba funcional
        }
        return laptop;
    }
}