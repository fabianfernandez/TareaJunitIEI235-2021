import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class UnitTest{

  private Log log;

  @BeforeClass
  public static void setupBeforeClass(){
    try {
      Log log = new Log("./log.txt");
      log.resetLog();
    } catch(Exception e) {

    }
  }

  @Before
  public void abrirLog(){
    try {
      this.log = new Log("./log.txt");
    } catch(Exception e) {

    }
  }
  @Test
  public void verificarInventarioTest(){
    String input = "";
    try {
      log.addLine("verificarInventarioTest Entrada: \"\"");
    } catch(Exception e) {

    }
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(byteArrayOutputStream);
    Inventario inventario = new Inventario(inputStream,ps);
    inventario.verificarInventario();
    System.out.println("");
    String outputText = byteArrayOutputStream.toString();
    String outputEsperado = "Cantidad de unidades de cafe en stock: 0\n"
    + "Cantidad de unidades de chocolate en stock: 0\n"
    + "Cantidad de unidades de leche en stock: 0\n"
    + "Cantidad de unidades de azucar en stock: 0\n";
    try {
      log.addLine("verificarInventarioTest Salida:\n"+outputText);
    } catch(Exception e) {

    }
    assertEquals(outputText, outputEsperado);

  }
  @Test
  public void agregarInventarioTest1(){
    String input = "10\n10\n80\n40\n";
    try {
      log.addLine("agregarInventarioTest1 Entrada: \"10\\n10\\n80\\n40\\n\"");
    } catch(Exception e) {

    }
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(byteArrayOutputStream);
    Inventario inventario = new Inventario(inputStream,ps);
    inventario.agregarInventario();
    System.out.println("");
    String outputText = byteArrayOutputStream.toString();
    String outputEsperado = "Ingresa las unidades de cafe para agregar al stock: "
    + "Ingresa las unidades de chocolate para agregar al stock: "
    + "Ingresa las unidades de leche para agregar al stock: "
    + "Ingresa las unidades de azucar para agregar al stock: ";
    try {
      log.addLine("agregarInventarioTest1 Salida:\n"+outputText);
    } catch(Exception e) {

    }
    assertEquals(inventario.cafe.obtenerStock(),10);
    assertEquals(inventario.chocolate.obtenerStock(),10);
    assertEquals(inventario.leche.obtenerStock(),80);
    assertEquals(inventario.azucar.obtenerStock(),40);
    assertEquals(outputText, outputEsperado);
  }

  @Test
  public void agregarInventarioTest2(){
    String input = "10\n-10\n10\n80\n40\n";
    try {
      log.addLine("agregarInventarioTest2 Entrada: \"10\\n-10\\n10\\n80\\n40\\n\"");
    } catch(Exception e) {

    }
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(byteArrayOutputStream);
    Inventario inventario = new Inventario(inputStream,ps);
    inventario.agregarInventario();
    System.out.println("");
    String outputText = byteArrayOutputStream.toString();
    String outputEsperado = "Ingresa las unidades de cafe para agregar al stock: "
    + "Ingresa las unidades de chocolate para agregar al stock: "
    + "Ingresa las unidades de chocolate para agregar al stock: "
    + "Ingresa las unidades de leche para agregar al stock: "
    + "Ingresa las unidades de azucar para agregar al stock: ";
    try {
      log.addLine("agregarInventarioTest2 Salida:\n"+outputText);
    } catch(Exception e) {

    }
    assertEquals(inventario.cafe.obtenerStock(),10);
    assertEquals(inventario.chocolate.obtenerStock(),10);
    assertEquals(inventario.leche.obtenerStock(),80);
    assertEquals(inventario.azucar.obtenerStock(),40);
    assertEquals(outputText, outputEsperado);
  }

  @Test
  public void agregarInventarioTest3(){
    String input = "10\ntext\n10\n80\n40\n";
    try {
      log.addLine("agregarInventarioTest3 Entrada: \"10\\ntext\\n10\\n80\\n40\\n\"");
    } catch(Exception e) {

    }
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(byteArrayOutputStream);
    Inventario inventario = new Inventario(inputStream,ps);
    inventario.agregarInventario();
    System.out.println("");
    String outputText = byteArrayOutputStream.toString();
    String outputEsperado = "Ingresa las unidades de cafe para agregar al stock: "
    + "Ingresa las unidades de chocolate para agregar al stock: "
    + "Ingresa las unidades de chocolate para agregar al stock: "
    + "Ingresa las unidades de leche para agregar al stock: "
    + "Ingresa las unidades de azucar para agregar al stock: ";
    try {
      log.addLine("agregarInventarioTest3 Salida:\n"+outputText);
    } catch(Exception e) {

    }
    assertEquals(inventario.cafe.obtenerStock(),10);
    assertEquals(inventario.chocolate.obtenerStock(),10);
    assertEquals(inventario.leche.obtenerStock(),80);
    assertEquals(inventario.azucar.obtenerStock(),40);
    assertEquals(outputText, outputEsperado);
  }

  @Test
  public void comprarBebidaTest1(){
    String input = "1\n700\n";
    try {
      log.addLine("comprarBebidaTest1 Entrada: \"1\\n700\\n\"");
    } catch(Exception e) {

    }
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(byteArrayOutputStream);
    Inventario inventario = new Inventario(inputStream,ps);
    inventario.cafe.agregarStock(10);
    inventario.chocolate.agregarStock(10);
    inventario.leche.agregarStock(10);
    inventario.azucar.agregarStock(10);
    inventario.comprarBebida();
    Receta receta1=inventario.config.obtenerReceta1();
    Receta receta2=inventario.config.obtenerReceta2();
    Receta receta3=inventario.config.obtenerReceta3();
    System.out.println("");
    String outputText = byteArrayOutputStream.toString();
    String outputEsperado = "Lista de Bebidas:\n"
    + "1. "+ receta1.obtenerNombre()+", Precio: " + String.valueOf(receta1.obtenerPrecio())+"\n"
    + "2. "+ receta2.obtenerNombre()+", Precio: " + String.valueOf(receta2.obtenerPrecio())+"\n"
    + "3. "+ receta3.obtenerNombre()+", Precio: " + String.valueOf(receta3.obtenerPrecio())+"\n"
    + "Ingresa el numero de la bebida: "
    + "Ingresa el dinero: "
    + "Su bebida "+receta1.obtenerNombre()+" esta listo\n"
    + "Su cambio es el siguiente: 200\n";
    try {
      log.addLine("comprarBebidaTest1 Salida:\n"+outputText);
    } catch(Exception e) {

    }
    assertEquals(outputText, outputEsperado);
  }

  @Test
  public void comprarBebidaTest2(){
    String input = "1\n500\n";
    try {
      log.addLine("comprarBebidaTest2 Entrada: \"1\\n500\\n\"");
    } catch(Exception e) {

    }
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(byteArrayOutputStream);
    Inventario inventario = new Inventario(inputStream,ps);
    inventario.comprarBebida();
    Receta receta1=inventario.config.obtenerReceta1();
    Receta receta2=inventario.config.obtenerReceta2();
    Receta receta3=inventario.config.obtenerReceta3();
    System.out.println("");
    String outputText = byteArrayOutputStream.toString();
    String outputEsperado = "Lista de Bebidas:\n"
    + "1. "+ receta1.obtenerNombre()+", Precio: " + String.valueOf(receta1.obtenerPrecio())+"\n"
    + "2. "+ receta2.obtenerNombre()+", Precio: " + String.valueOf(receta2.obtenerPrecio())+"\n"
    + "3. "+ receta3.obtenerNombre()+", Precio: " + String.valueOf(receta3.obtenerPrecio())+"\n"
    + "Ingresa el numero de la bebida: "
    + "Ingresa el dinero: "
    + "No hay suficientes insumos para hacer esta bebida\n"
    + "Su cambio es el siguiente: 500\n";
    try {
      log.addLine("comprarBebidaTest2 Salida:\n"+outputText);
    } catch(Exception e) {

    }
    assertEquals(outputText, outputEsperado);
  }

  @Test
  public void comprarBebidaTest3(){
    String input = "1\n400\n";
    try {
      log.addLine("comprarBebidaTest3 Entrada: \"1\\n400\\n\"");
    } catch(Exception e) {

    }
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(byteArrayOutputStream);
    Inventario inventario = new Inventario(inputStream,ps);
    inventario.comprarBebida();
    Receta receta1=inventario.config.obtenerReceta1();
    Receta receta2=inventario.config.obtenerReceta2();
    Receta receta3=inventario.config.obtenerReceta3();
    System.out.println("");
    String outputText = byteArrayOutputStream.toString();
    String outputEsperado = "Lista de Bebidas:\n"
    + "1. "+ receta1.obtenerNombre()+", Precio: " + String.valueOf(receta1.obtenerPrecio())+"\n"
    + "2. "+ receta2.obtenerNombre()+", Precio: " + String.valueOf(receta2.obtenerPrecio())+"\n"
    + "3. "+ receta3.obtenerNombre()+", Precio: " + String.valueOf(receta3.obtenerPrecio())+"\n"
    + "Ingresa el numero de la bebida: "
    + "Ingresa el dinero: "
    + "Dinero ingresado insuficiente\n"
    + "Su cambio es el siguiente: 400\n";
    try {
      log.addLine("comprarBebidaTest3 Salida:\n"+outputText);
    } catch(Exception e) {

    }
    assertEquals(outputText, outputEsperado);
  }

  @Test
  public void comprobarDineroSuficienteTest1(){
    try {
      log.addLine("comprobarDineroSuficienteTest1() Receta Seleccionada: 1, Dinero ingresado: 500");
    } catch(Exception e) {

    }
    Inventario inventario = new Inventario(System.in,System.out);
    Receta receta1 = inventario.config.obtenerReceta1();
    int dineroIngresado = 500;
    boolean flag = inventario.esSuficienteDinero(receta1,dineroIngresado);
    try {
      log.addLine("comprobarDineroSuficienteTest1() Salida: "+flag);
    } catch(Exception e) {

    }
    assertTrue(flag);
  }

  @Test
  public void comprobarDineroSuficienteTest2(){
    try {
      log.addLine("comprobarDineroSuficienteTest2() Receta Seleccionada: 1, Dinero ingresado: 400");
    } catch(Exception e) {

    }
    Inventario inventario = new Inventario(System.in,System.out);
    Receta receta1 = inventario.config.obtenerReceta1();
    int dineroIngresado = 400;
    boolean flag = inventario.esSuficienteDinero(receta1,dineroIngresado);
    try {
      log.addLine("comprobarDineroSuficienteTest2() Salida: "+flag);
    } catch(Exception e) {

    }
    assertFalse(flag);
  }

  @Test
  public void comprobarInsumosSuficienteTest1(){
    try {
      log.addLine("comprobarInsumosSuficienteTest1() Receta Solicitada: 1, Insumos En Maquina->cafe:10,chocolate:10,leche:10,azucar:10");
    } catch(Exception e) {

    }
    Inventario inventario = new Inventario(System.in,System.out);
    inventario.cafe.agregarStock(10);
    inventario.chocolate.agregarStock(10);
    inventario.leche.agregarStock(10);
    inventario.azucar.agregarStock(10);
    Receta receta1 = inventario.config.obtenerReceta1();
    boolean flag = inventario.hayInsumosSuficiente(receta1);
    try {
      log.addLine("comprobarInsumosSuficienteTest1() Salida: "+flag);
    } catch(Exception e) {

    }
    assertTrue(flag);
  }

  @Test
  public void comprobarInsumosSuficienteTest2(){
    try {
      log.addLine("comprobarInsumosSuficienteTest2() Receta Solicitada: 1, Insumos En Maquina->cafe:0,chocolate:0,leche:0,azucar:0");
    } catch(Exception e) {

    }
    Inventario inventario = new Inventario(System.in,System.out);
    Receta receta1 = inventario.config.obtenerReceta1();
    boolean flag = inventario.hayInsumosSuficiente(receta1);
    try {
      log.addLine("comprobarInsumosSuficienteTest2() Salida: "+flag);
    } catch(Exception e) {

    }
    assertFalse(flag);
  }

}
