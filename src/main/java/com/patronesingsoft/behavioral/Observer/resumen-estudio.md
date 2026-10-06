# Observer: resumen para estudiar

## La idea en una frase

**Observer permite que un objeto avise automáticamente a todos los que se suscribieron cuando ocurre un cambio.** El objeto que avisa no necesita conocer las clases concretas de quienes reciben el aviso.

## Un ejemplo sencillo

Pensá en un curso que publica novedades. Ana y Luis se suscriben para recibirlas. Si Luis se da de baja, el próximo aviso llega solo a Ana.

## Los participantes

| Participante | En este ejemplo | Qué hace |
| --- | --- | --- |
| Sujeto | `Sujeto` | Declara cómo suscribirse, darse de baja y notificar. |
| Sujeto concreto | `Curso` | Guarda la lista de observadores y publica los avisos. |
| Observador | `Observador` | Declara el método `actualizar(aviso)`. |
| Observador concreto | `Alumno` | Recibe y guarda el aviso. |
| Cliente | `Demo` | Crea los objetos y los conecta. |

La relación es **uno a muchos**: un curso puede notificar a ninguno, uno o varios observadores. `Curso` conoce la interfaz `Observador`; no necesita saber que Ana o Luis son objetos de tipo `Alumno`.

## Cómo funciona, paso a paso

1. `Demo` crea el curso y los alumnos.
2. Ana y Luis se suscriben al curso.
3. El curso publica **«TP disponible»** y avisa a ambos.
4. Luis se da de baja.
5. El curso publica **«Entrega: martes 06/10»**. Ana lo recibe; Luis conserva el aviso anterior.

```text
Curso publica un aviso
    → Curso recorre los observadores suscriptos
        → cada observador recibe actualizar(aviso)
```

En este código se usa **push**: el curso pasa el aviso directamente a `actualizar(String aviso)`. La notificación es síncrona: cada alumno se actualiza antes de que termine la publicación.

## Qué gana y qué hay que cuidar

**Ventaja:** se pueden agregar o quitar receptores sin cambiar la lógica del curso; también se pueden añadir nuevas clases que implementen `Observador`.

**Costo:** hay que gestionar las suscripciones. En esta implementación, un alumno lento demora la notificación y una excepción de un observador puede interrumpir la ronda. La implementación es de un solo hilo.

## Una respuesta breve para el examen

> Observer es un patrón de comportamiento que define una relación de uno a muchos entre un sujeto y sus observadores. Cuando cambia el sujeto, notifica automáticamente a los observadores suscriptos. En este ejemplo, `Curso` publica los avisos y depende de la interfaz `Observador`; `Alumno` la implementa y recibe cada aviso mediante `actualizar`. Así, las suscripciones cambian sin acoplar el curso a una clase concreta.

## Cómo recordarlo

**El curso publica; los suscriptos reaccionan.** `Sujeto` ofrece la suscripción, `Observador` define la actualización y `Demo` conecta ambos.

## Preguntas para repasar

- ¿Qué objeto publica los avisos? `Curso`, el sujeto concreto.
- ¿Por qué `Curso` depende de `Observador` y no directamente de `Alumno`? Para poder notificar a distintos observadores sin conocer su clase concreta.
- ¿Qué cambia cuando Luis se da de baja? Deja de recibir las próximas notificaciones; su objeto y su aviso guardado no desaparecen.
- ¿Qué método recibe el aviso? `actualizar(String aviso)`.
- ¿La notificación del ejemplo es síncrona o asíncrona? Síncrona.

## Comprobalo en el código

Abrí [`Curso.java`](Curso.java), [`Observador.java`](Observador.java), [`Alumno.java`](Alumno.java) y [`Demo.java`](Demo.java), en ese orden. La [presentación con diagramas y recorrido visual](../../../../../../../presentaciones/observer/README.md) muestra la misma secuencia.
