import java.util.Scanner;
import java.io.InputStream;
import java.io.PrintStream;

public class Inventario{
  public Insumo cafe;
  public  Insumo chocolate;
  public  Insumo leche;
  public  Insumo azucar;
  public  ConfiguracionInicial config;
  private Scanner buffer;
  private PrintStream printStream;

  public Inventario(InputStream inputStream, PrintStream printStream){
    this.cafe = new Insumo();
    this.chocolate = new Insumo();
    this.leche = new Insumo();
    this.azucar = new Insumo();
    this.config = new ConfiguracionInicial();
    this.buffer = new Scanner(inputStream);
    this.printStream = printStream;
  }


  public void agregarInventario(){
    String input;
    while (true) {
      printStream.print("Ingresa las unidades de cafe para agregar al stock: ");
      input = buffer.nextLine();
      try {
        int cantidad = Integer.parseInt(input);
        if (cantidad<0||config.maxUnidadesCafe < cantidad + cafe.obtenerStock()) {
          continue;
        }
        this.cafe.agregarStock(cantidad);
        break;
      }catch (Exception e) {
        continue;
      }
    }

    while (true) {
      printStream.print("Ingresa las unidades de chocolate para agregar al stock: ");
      input = buffer.nextLine();
      try {
        int cantidad = Integer.parseInt(input);
        if (cantidad<0 ||config.maxUnidadesChocolate < cantidad + chocolate.obtenerStock()) {
          continue;
        }
        this.chocolate.agregarStock(cantidad);
        break;
      }catch (Exception e) {
        continue;
      }
    }
    while (true) {
      printStream.print("Ingresa las unidades de leche para agregar al stock: ");
      input = buffer.nextLine();
      try {
        int cantidad = Integer.parseInt(input);
        if (cantidad<0 ||config.maxUnidadesLeche < cantidad + leche.obtenerStock()) {
          continue;
        }
        this.leche.agregarStock(cantidad);
        break;
      }catch (Exception e) {
        continue;
      }
    }
    while (true) {
      printStream.print("Ingresa las unidades de azucar para agregar al stock: ");
      input = buffer.nextLine();
      try {
        int cantidad = Integer.parseInt(input);
        if (cantidad<0 ||config.maxUnidadesAzucar < cantidad + azucar.obtenerStock()) {
          continue;
        }
        this.azucar.agregarStock(cantidad);
        break;
      }catch (Exception e) {
        continue;
      }
    }
    return;
  }
  public void verificarInventario(){
    printStream.print("Cantidad de unidades de cafe en stock: "+ String.valueOf(this.cafe.obtenerStock())+"\n");
    printStream.print("Cantidad de unidades de chocolate en stock: "+ String.valueOf(this.chocolate.obtenerStock())+"\n");
    printStream.print("Cantidad de unidades de leche en stock: "+ String.valueOf(this.leche.obtenerStock())+"\n");
    printStream.print("Cantidad de unidades de azucar en stock: "+ String.valueOf(this.azucar.obtenerStock())+"\n");
    //printStream.println("test");
    return;
  }
  public void comprarBebida(){
    int opcion = 0;
    int dineroIngresado = 0;
    Receta receta1 = this.config.obtenerReceta1();
    Receta receta2 = this.config.obtenerReceta2();
    Receta receta3 = this.config.obtenerReceta3();
    String input;
    printStream.print("Lista de Bebidas:\n");
    printStream.print("1. "+ receta1.obtenerNombre()+", Precio: " + String.valueOf(receta1.obtenerPrecio())+"\n");
    printStream.print("2. "+ receta2.obtenerNombre()+", Precio: " + String.valueOf(receta2.obtenerPrecio())+"\n");
    printStream.print("3. "+ receta3.obtenerNombre()+", Precio: " + String.valueOf(receta3.obtenerPrecio())+"\n");
    printStream.print("Ingresa el numero de la bebida: ");
    input = buffer.nextLine();
    try {
      opcion = Integer.parseInt(input);
    } catch(Exception e) {
      printStream.print("opcion invalida\n");
      return;
    }
    printStream.print("Ingresa el dinero: ");
    input = buffer.nextLine();
    try {
      dineroIngresado = Integer.parseInt(input);
    } catch(Exception e) {
      printStream.print("formato invalido\n");
      return;
    }
    switch (opcion) {
      case 1:
        if (esSuficienteDinero(receta1,dineroIngresado)) {
            if (hayInsumosSuficiente(receta1)) {
              prepararBebida(receta1);
              printStream.print("Su bebida "+receta1.obtenerNombre()+" esta listo\n");
              printStream.print("Su cambio es el siguiente: "+String.valueOf(dineroIngresado-receta1.obtenerPrecio())+"\n");
            }else {
              printStream.print("No hay suficientes insumos para hacer esta bebida\n");
              printStream.print("Su cambio es el siguiente: "+String.valueOf(dineroIngresado)+"\n");
            }
        }else {
            printStream.print("Dinero ingresado insuficiente\n");
            printStream.print("Su cambio es el siguiente: "+String.valueOf(dineroIngresado)+"\n");
        }
        break;
      case 2:
        if (esSuficienteDinero(receta2,dineroIngresado)) {
            if (hayInsumosSuficiente(receta2)) {
              prepararBebida(receta2);
              printStream.print("Su bebida "+receta2.obtenerNombre()+" esta listo\n");
              printStream.print("Su cambio es el siguiente: "+String.valueOf(dineroIngresado-receta2.obtenerPrecio())+"\n");
            }else {
              printStream.print("No hay suficientes insumos para hacer esta bebida\n");
              printStream.print("Su cambio es el siguiente: "+String.valueOf(dineroIngresado)+"\n");
            }
        }else {
            printStream.print("Dinero ingresado insuficiente\n");
            printStream.print("Su cambio es el siguiente: "+String.valueOf(dineroIngresado)+"\n");
        }
        break;
      case 3:
        if (esSuficienteDinero(receta3,dineroIngresado)) {
            if (hayInsumosSuficiente(receta3)) {
              prepararBebida(receta3);
              printStream.print("Su bebida "+receta3.obtenerNombre()+" esta listo\n");
              printStream.print("Su cambio es el siguiente: "+String.valueOf(dineroIngresado-receta3.obtenerPrecio())+"\n");
            }else {
              printStream.print("No hay suficientes insumos para hacer esta bebida\n");
              printStream.print("Su cambio es el siguiente: "+String.valueOf(dineroIngresado)+"\n");
            }
        }else {
            printStream.print("Dinero ingresado insuficiente\n");
            printStream.print("Su cambio es el siguiente: "+String.valueOf(dineroIngresado)+"\n");
        }
        break;
      default:
        printStream.print("Opcion ingresada invalida\n");
        printStream.print("Su cambio es el siguiente: "+String.valueOf(dineroIngresado)+"\n");
        break;
    }
    return;
  }

  public boolean esSuficienteDinero(Receta receta,int dineroIngresado){
    if (receta.obtenerPrecio()<=dineroIngresado) {
      return true;
    }else {
      return false;
    }
  }

  public boolean hayInsumosSuficiente(Receta receta){
    boolean flag = (receta.obtenerCafeNecesario()<=this.cafe.obtenerStock() && receta.obtenerChocolateNecesario()<=this.chocolate.obtenerStock() && receta.obtenerLecheNecesaria() <= this.leche.obtenerStock() && receta.obtenerAzucarNecesaria()<=this.azucar.obtenerStock());
    return flag;
  }

  public void prepararBebida(Receta receta){
    cafe.gastarStock(receta.obtenerCafeNecesario());
    chocolate.gastarStock(receta.obtenerChocolateNecesario());
    leche.gastarStock(receta.obtenerLecheNecesaria());
    azucar.gastarStock(receta.obtenerAzucarNecesaria());
  }

}
