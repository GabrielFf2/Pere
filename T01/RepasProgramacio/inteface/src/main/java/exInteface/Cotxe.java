package exInteface;

public class Cotxe extends Vehicle{
    public Cotxe(String model, String marca, String matricula, Integer velocidad){
        super(model , marca , matricula , velocidad);
    }

    @Override
    public String toString() {
        return "Cotxe{" +
                "numPortes=" + numPortes +
                ", model='" + model + '\'' +
                ", marca='" + marca + '\'' +
                ", matricula='" + matricula + '\'' +
                ", velocidad=" + velocidad +
                '}';
    }

    private int numPortes;
    void acelerar(int velocidade){
        System.out.println("Coche acelerando a :" + velocidad+velocidade);
    }
}
