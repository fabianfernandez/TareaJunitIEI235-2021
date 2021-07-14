import java.util.Scanner;
import java.io.InputStream;
import java.io.PrintStream;

public class TareaJunit{
  private Scanner buffer;
  private PrintStream printStream;
  public Inventario inventario;

  public TareaJunit(InputStream inputStream, PrintStream printStream) {
    this.buffer = new Scanner(inputStream);
    this.printStream = printStream;
    this.inventario = new Inventario(inputStream,printStream);
  }

  public static void main(String[] args) {
    TareaJunit programa = new TareaJunit(System.in, System.out);
    int opcion = 0;
    Inventario inventario = programa.inventario;
    while (true) {
      programa.printStream.print("Selecciona una de las siguientes opciones\n");
      programa.printStream.print("1. agregar inventario\n");
      programa.printStream.print("2. verificar inventario\n");
      programa.printStream.print("3. comprar bebida\n");
      programa.printStream.print("ingresa el numero de tu opcion: ");
      String input = programa.buffer.nextLine();
      try {
        opcion = Integer.parseInt(input);
        switch (opcion) {
          case 1:
            inventario.agregarInventario();
            break;
          case 2:
            inventario.verificarInventario();
            break;
          case 3:
            inventario.comprarBebida();
            break;
          default:
            programa.printStream.println("Opcion no esta disponible");
        }
      } catch(Exception e) {
        programa.printStream.println("Opcion erronea");
      }
    }

  }
}
