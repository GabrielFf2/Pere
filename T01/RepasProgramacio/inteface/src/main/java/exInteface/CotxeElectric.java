package exInteface;

public class CotxeElectric extends Cotxe implements Electric{

    public CotxeElectric (String model , String marca , String matricula ,Integer velocidad){
        super(model , marca , matricula , velocidad);
    }

    @Override
    public String toString() {
        return "CotxeElectric{" +
                "model='" + model + '\'' +
                ", marca='" + marca + '\'' +
                ", matricula='" + matricula + '\'' +
                ", velocidad=" + velocidad +
                '}';
    }

    @Override
    public void carregarBateria() {
        System.out.println("Carregando Bateria");
    }
    @Override
    public void acelerar(int velocidad) {
        System.out.println("Coche acelerando a :" + (this.velocidad+ velocidad));
    }
}
