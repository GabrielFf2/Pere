package exInteface;

public class Lilium extends Cotxe implements Volador{

    public Lilium (String model , String marca , String matricula ,Integer velocidad){
        super(model , marca , matricula , velocidad);
    }

    @Override
    public String toString() {
        return "Lilium{" +
                "model='" + model + '\'' +
                ", marca='" + marca + '\'' +
                ", matricula='" + matricula + '\'' +
                ", velocidad=" + velocidad +
                '}';
    }

    @Override
    public void volar() {
        System.out.println("Lilium vola");
    }
    @Override
    void acelerar(int velocidad) {
        System.out.println("Lilium acelerant a :" + this.velocidad + velocidad);
    }
}
