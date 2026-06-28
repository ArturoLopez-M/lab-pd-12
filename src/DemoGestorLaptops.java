void main() {
    IO.println("BIENVENIDOS A LA FABRICA DE LAPTOPS\n");

    // 1. Creamos la fábrica(factory) independiente
    SimpleLaptopFactory factory = new SimpleLaptopFactory();

    // 2. Creamos el gestor inyectándole la fábrica(factory)
    GestorLaptops gestor = new GestorLaptops(factory);

    // 3. Solicitamos y mostramos el estado de los equipos usando toString()
    Laptop laptop1 = gestor.ordenarLaptop("gamer");
    if (laptop1 != null) {
        IO.println(laptop1.toString());
    }

    Laptop laptop2 = gestor.ordenarLaptop("basica");
    if (laptop2 != null) {
        IO.println(laptop2.toString());
    }

    Laptop laptop3 = gestor.ordenarLaptop("profesional");
    if (laptop3 != null) {
        IO.println(laptop3.toString());
    }
}