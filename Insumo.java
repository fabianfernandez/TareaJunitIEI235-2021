public class Insumo{
  private int stock;

  public Insumo(){
    this.stock = 0;
  }
  public int obtenerStock(){
    return this.stock;
  }
  public void agregarStock(int cantidad){
    this.stock+=cantidad;
  }
  public void gastarStock(int cantidad){
    this.stock-=cantidad;
  }
}
