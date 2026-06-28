public abstract class Laptop {
    private String marcaYModelo;
    private int anioFabricacion;
    private String procesador;
    private int tamanoPantalla;

    public Laptop(String marcaYModelo, int anioFabricacion, String procesador, int tamanoPantalla) {
        this.marcaYModelo = marcaYModelo;
        this.anioFabricacion = anioFabricacion;
        this.procesador = procesador;
        this.tamanoPantalla = tamanoPantalla;
    }

    public String getMarcaYModelo() {
        return marcaYModelo;
    }

    // Método abstracto obligatorio
    public abstract void ejecutarPrueba();

    // Transforma el estado completo del objeto a texto
    @Override
    public String toString() {
        return "Marca y Modelo: " + marcaYModelo + "\n" +
                "Año de Fabricacion: " + anioFabricacion + "\n" +
                "Procesador: " + procesador + "\n" +
                "Tamaño de la Pantalla: " + tamanoPantalla + "\n";
    }
}

// CLASES CONCRETAS

class LaptopBasica extends Laptop {
    public LaptopBasica(String marcaYModelo, int anioFabricacion, String procesador, int tamanoPantalla) {
        super(marcaYModelo, anioFabricacion, procesador, tamanoPantalla);
    }

    @Override
    public void ejecutarPrueba() {
        System.out.println("Corriendo programas en una Laptop Basica");
        System.out.println("Laptop Basica");
    }
}

class LaptopGamer extends Laptop {
    public LaptopGamer(String marcaYModelo, int anioFabricacion, String procesador, int tamanoPantalla) {
        super(marcaYModelo, anioFabricacion, procesador, tamanoPantalla);
    }

    @Override
    public void ejecutarPrueba() {
        System.out.println("Corriendo programas en una Laptop para Gamer");
        System.out.println("Laptop para Gamer");
    }
}

class LaptopProfesional extends Laptop {
    public LaptopProfesional(String marcaYModelo, int anioFabricacion, String procesador, int tamanoPantalla) {
        super(marcaYModelo, anioFabricacion, procesador, tamanoPantalla);
    }

    @Override
    public void ejecutarPrueba() {
        System.out.println("Corriendo programas en una Laptop Profesional");
        System.out.println("Laptop para Profesional");
    }
}