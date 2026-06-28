public class SimpleLaptopFactory {

    // El método evalúa el tipo y encapsula el operador 'new'
    public Laptop createLaptop(String tipo) {
        if (tipo.equalsIgnoreCase("basica")) {
            return new LaptopBasica("Dell Latitude", 2020, "intel core i7", 14);

        } else if (tipo.equalsIgnoreCase("gamer")) {
            return new LaptopGamer("Macbook air", 2017, "Silicon M1", 13);

        } else if (tipo.equalsIgnoreCase("profesional")) {
            return new LaptopProfesional("Macbook Pro", 2022, "Apple Silicon M2", 16);
        }
        return null;
    }
}