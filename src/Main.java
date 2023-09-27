import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        Alumne[] alumnos = new Alumne[20];
        int notas;

        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i] = new Alumne();
            alumnos[i].setNom("Alumno" + i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(20); // Puedes ajustar el número de hilos según tus necesidades

        Future<Integer>[] resultados = new Future[alumnos.length];

        for (int i = 0; i < alumnos.length; i++) {
            final int index = i;
            resultados[i] = executorService.submit(() -> alumnos[index].examinar());
        }

        for (int i = 0; i < alumnos.length; i++) {
            try {
                notas = resultados[i].get();
                System.out.println(alumnos[i].getNom() + " " + notas);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}