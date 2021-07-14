public class Receta{
  private String nombreReceta;
  private int precio;
  private int unidadesCafeNecesario;
  private int unidadesChocolateNecesario;
  private int unidadesLecheNecesaria;
  private int unidadesAzucarNecesaria;

  public Receta(String nombreReceta, int precio, int unidadesCafeNecesario, int unidadesChocolateNecesario, int unidadesLecheNecesaria, int unidadesAzucarNecesaria){
    this.nombreReceta = nombreReceta;
    this.precio = precio;
    this.unidadesCafeNecesario = unidadesCafeNecesario;
    this.unidadesChocolateNecesario = unidadesChocolateNecesario;
    this.unidadesLecheNecesaria = unidadesLecheNecesaria;
    this.unidadesAzucarNecesaria = unidadesAzucarNecesaria;
  }

  public String obtenerNombre(){
    return this.nombreReceta;
  }
  public int obtenerPrecio(){
    return this.precio;
  }
  public int obtenerCafeNecesario(){
    return this.unidadesCafeNecesario;
  }

  public int obtenerChocolateNecesario(){
    return this.unidadesChocolateNecesario;
  }

  public int obtenerLecheNecesaria(){
    return this.unidadesLecheNecesaria;
  }

  public int obtenerAzucarNecesaria(){
    return this.unidadesAzucarNecesaria;
  }
}
