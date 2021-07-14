public class ConfiguracionInicial{
  public  int maxUnidadesCafe;
  public  int maxUnidadesChocolate;
  public  int maxUnidadesLeche;
  public  int maxUnidadesAzucar;
  private Receta receta1;
  private Receta receta2;
  private Receta receta3;

  public ConfiguracionInicial(){
    this.maxUnidadesCafe = 10;
    this.maxUnidadesChocolate = 10;
    this.maxUnidadesLeche = 80;
    this.maxUnidadesAzucar = 40;
    receta1 = new Receta("Cafe con leche",500,2,0,4,2);
    receta2 = new Receta("Capuccino",1000,1,1,3,2);
    receta3 = new Receta("Expreso",500,3,0,0,3);
  }

  public Receta obtenerReceta1(){
    return this.receta1;
  }

  public Receta obtenerReceta2(){
    return this.receta2;
  }

  public Receta obtenerReceta3(){
    return this.receta3;
  }
}
