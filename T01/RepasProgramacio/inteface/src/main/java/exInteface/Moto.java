package exInteface;

public class Moto extends  Vehicle{

    private int cilindrada;

    public Moto (String model , String marca , String matricula ,Integer velocidad){
        super(model , marca , matricula , velocidad);
    }

    @Override
    public String toString() {
        return "Moto{" +
                "cilindrada=" + cilindrada +
                ", model='" + model + '\'' +
                ", marca='" + marca + '\'' +
                ", matricula='" + matricula + '\'' +
                ", velocidad=" + velocidad +
                '}';
    }

    public void acelerar(int velocidade){
        System.out.println("Moto acelerando a :" + this.velocidad+velocidade);
    }
}
