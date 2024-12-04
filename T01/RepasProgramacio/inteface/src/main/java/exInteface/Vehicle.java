package exInteface;

public abstract class Vehicle {
    protected String model;
    protected String marca;
    protected String matricula;
    protected Integer velocidad;

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", marca='" + marca + '\'' +
                ", matricula='" + matricula + '\'' +
                ", velocidad=" + velocidad +
                '}';
    }

    public Vehicle(String model, String marca, String matricula, Integer velocidad) {
        this.model = model;
        this.marca = marca;
        this.matricula = matricula;
        this.velocidad = velocidad;
    }

    abstract void acelerar(int velocidad);

    void mostrarInformacio(){
        System.out.println("Matricula: " + matricula + "marca: " + marca +"model: " + model);
    }

}
