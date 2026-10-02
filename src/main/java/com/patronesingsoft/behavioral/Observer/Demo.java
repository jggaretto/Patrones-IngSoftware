package com.patronesingsoft.behavioral.Observer;

/** CLIENTE: el curso distribuye avisos solo a sus alumnos suscriptos. */
public class Demo {
    public static void main(String[] args) {
        Curso curso = new Curso();
        Alumno ana = new Alumno("Ana");
        Alumno luis = new Alumno("Luis");
        curso.suscribir(ana);
        curso.suscribir(luis);
        curso.publicarAviso("TP disponible");
        assert ana.getUltimoAviso().equals("TP disponible");
        assert luis.getUltimoAviso().equals("TP disponible");
        curso.desuscribir(luis);
        curso.publicarAviso("Entrega: martes 06/10");
        assert ana.getUltimoAviso().equals("Entrega: martes 06/10");
        assert luis.getUltimoAviso().equals("TP disponible");

        Curso prueba = new Curso();
        int[] recibidos = {0};
        Observador contador = aviso -> recibidos[0]++;
        prueba.suscribir(contador);
        prueba.suscribir(contador);
        Observador[] unaVez = new Observador[1];
        int[] bajas = {0};
        unaVez[0] = aviso -> { bajas[0]++; prueba.desuscribir(unaVez[0]); };
        prueba.suscribir(unaVez[0]);
        prueba.publicarAviso("Primero");
        prueba.publicarAviso("Segundo");
        assert recibidos[0] == 2 && bajas[0] == 1;
        boolean vacio = false;
        try { prueba.publicarAviso(" "); } catch (IllegalArgumentException e) { vacio = true; }
        assert vacio;
        System.out.println("Observer: entrega, baja y duplicados verificados.");
    }
}
