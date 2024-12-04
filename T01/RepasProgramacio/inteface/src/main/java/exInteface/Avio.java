package exInteface;

public class Avio extends Vehicle implements Volador{
    public Avio(String model, String marca, String matricula, Integer velocidad) {
        super(model, marca, matricula, velocidad);
    }



    void acelerar(int velocidad) {
        System.out.println("Acelerant a :" + this.velocidad + velocidad);

    }

    @Override
    public String toString() {
        return "Avio{" +
                "model='" + model + '\'' +
                ", marca='" + marca + '\'' +
                ", matricula='" + matricula + '\'' +
                ", velocidad=" + velocidad +
                '}';
    }

    @Override
    public void volar() {
        System.out.println("Avio vola");
    }
}
