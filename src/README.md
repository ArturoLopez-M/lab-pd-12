## Arquitectura del Sistema

Este proyecto implementa el patrón de diseño **Simple Factory (Fábrica Simple)**. El propósito principal de esta arquitectura es centralizar la creación de objetos en una única clase, evitando que el resto del sistema (la lógica de negocio) conozca los detalles de cómo se instancian los diferentes tipos de computadoras.

Al delegar la creación a una fábrica, logramos un código altamente desacoplado, fácil de mantener y escalar.

![Diagrama UML](DiagramaUML%20SimpleFactory.jpeg)

### Componentes Clave y sus Relaciones

* **El Dominio (`Laptop` y subclases):** `Laptop` es la clase abstracta base. Concentra los atributos comunes (`marcaYModelo`, `anioFabricacion`, `procesador`, `tamanoPantalla`) y define métodos esenciales como `ejecutarPrueba()` y `toString()`. De esta clase heredan tres subclases concretas: `LaptopBasica`, `LaptopGamer` y `LaptopProfesional`.
  > *Nota estructural:* Para simplificar este proyecto, las tres clases concretas se han agrupado físicamente dentro del mismo archivo `Laptop.java` (sin el modificador `public`), aprovechando el polimorfismo mediante herencia.

* **El Motor de Creación (`SimpleLaptopFactory`):**
  Es el corazón del patrón. Su única responsabilidad es fabricar objetos. A través de su método `createLaptop(tipo)`, evalúa una cadena de texto y utiliza el operador `new` para instanciar la subclase correspondiente, devolviéndola bajo la abstracción de `Laptop`.

* **El Controlador (`GestorLaptops`):**
  Representa la lógica de negocio. Mantiene una relación de **agregación** (rombo blanco) con la fábrica, la cual recibe a través de su constructor (inyección de dependencias). Su método principal, `ordenarLaptop()`, le pide a la fábrica que cree el equipo, interactuando únicamente con la abstracción sin importar qué tipo específico de laptop se generó.

* **El Cliente Principal (`DemoGestorLaptops`):**
  Es el punto de entrada de la aplicación (`main`). Mantiene una dependencia funcional temporal (línea discontinua) con el gestor para arrancar el sistema y demostrar su funcionamiento.


### Flujo de Ejecución del Programa

Para entender cómo interactúan los componentes en tiempo de ejecución, este es el ciclo de vida de una solicitud:

1. **Inicialización:** El método `main` en `DemoGestorLaptops` arranca y crea una instancia de `SimpleLaptopFactory`.
2. **Inyección:** Se crea una instancia de `GestorLaptops`, pasándole la fábrica recién creada a través de su constructor.
3. **Solicitud:** El programa principal le pide al gestor que ordene una laptop pasando un texto (ej. `"gamer"`).
4. **Delegación:** El gestor no usa la palabra `new`. En su lugar, llama al método `factory.createLaptop("gamer")`.
5. **Fabricación:** La fábrica evalúa la petición, instancia un objeto de la clase concreta `LaptopGamer` y se lo devuelve al gestor tipado genéricamente como `Laptop`.
6. **Ejecución y Retorno:** El gestor ejecuta la prueba obligatoria del equipo (`ejecutarPrueba()`) y devuelve el objeto listo al programa principal para que imprima sus detalles.

Gracias a esta arquitectura, si en el futuro necesitamos agregar una nueva **Laptop Empresarial**, solo debemos crear la clase y actualizar la fábrica; el gestor y el programa principal seguirán funcionando sin necesidad de tocar su código.