package exInteface;

public class Main {
    public static void main(String[] args) {
        CotxeElectric tesla = new CotxeElectric("model 3" , "Tesla" , "4444-aaa" , 100);
        System.out.println(tesla);
        tesla.acelerar(40);
        tesla.carregarBateria();




        /*Volador lilium = new Lilium("lil","Samasung","jajajaja" , 150);
        lilium.volar();
        System.out.println(lilium);*/
    }
}
