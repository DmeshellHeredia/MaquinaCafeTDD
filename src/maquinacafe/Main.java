package maquinacafe;

import java.util.Scanner;

/** Demostracion por consola. Ejecutar con java -jar dist/MaquinaCafeTDD.jar */
public class Main {
    public static void main(String[] args) {
        // Especificacion funcional de la guia: 3, 5 y 7 onzas.
        Vaso pequenos = new Vaso(10, 3);
        Vaso medianos = new Vaso(10, 5);
        Vaso grandes = new Vaso(10, 7);
        Cafetera cafetera = new Cafetera(100);
        Azucarero azucarero = new Azucarero(40);

        MaquinaDeCafe maquina = new MaquinaDeCafe();
        maquina.setVasosPequeno(pequenos);
        maquina.setVasosMediano(medianos);
        maquina.setVasosGrande(grandes);
        maquina.setCafetera(cafetera);
        maquina.setAzucarero(azucarero);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== MAQUINA DE CAFE ===");
                System.out.printf("Disponibles: P=%d M=%d G=%d | Cafe=%d oz | Azucar=%d cucharadas%n",
                        pequenos.getCantidadVasos(), medianos.getCantidadVasos(),
                        grandes.getCantidadVasos(), cafetera.getCantidadCafe(),
                        azucarero.getCantidadAzucar());
                System.out.println("1. Pequeno (3 oz)  2. Mediano (5 oz)  3. Grande (7 oz)  0. Salir");
                Integer opcion = leerEntero(scanner, "Selecciona el tamano: ");
                if (opcion == null || opcion == 0) {
                    System.out.println("Hasta luego.");
                    return;
                }
                String tipo = switch (opcion) {
                    case 1 -> "pequeno";
                    case 2 -> "mediano";
                    case 3 -> "grande";
                    default -> null;
                };
                if (tipo == null) {
                    System.out.println("Opcion invalida.");
                    continue;
                }
                Integer vasos = leerEntero(scanner, "Cantidad de vasos: ");
                if (vasos == null) {
                    return;
                }
                Integer azucar = leerEntero(scanner, "Cucharadas de azucar en total (0 = sin azucar): ");
                if (azucar == null) {
                    return;
                }
                System.out.println(maquina.getVasoDeCafe(maquina.getTipoDeVaso(tipo), vasos, azucar));
            }
        }
    }

    private static Integer leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (!scanner.hasNextLine()) {
                return null;
            }
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.valueOf(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero entero valido.");
            }
        }
    }
}
