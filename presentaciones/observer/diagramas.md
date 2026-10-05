# Observer — diagramas del ejemplo

Código de referencia: rama `Patrones-Completos`, commit `cf8dbfc`, paquete `com.patronesingsoft.behavioral.Observer`. Los diagramas describen ese código; el recorrido de secuencia muestra la parte principal de `Demo`, antes de sus pruebas adicionales.

## Clases y contratos

Realización (`..|>`): una clase implementa una interfaz. Asociación (`-->`): el curso guarda referencias a observadores. Dependencia (`..>`): el cliente crea y usa objetos. No se usa composición: desuscribir no destruye al alumno.

```mermaid
classDiagram
direction TB
class Sujeto {
    <<interface>>
    +suscribir(Observador observador) void
    +desuscribir(Observador observador) void
    +notificar() void
}
class Observador {
    <<interface>>
    +actualizar(String aviso) void
}
class Curso {
    -Set~Observador~ observadores
    -String ultimoAviso
    +suscribir(Observador observador) void
    +desuscribir(Observador observador) void
    +publicarAviso(String aviso) void
    +notificar() void
}
class Alumno {
    -String nombre
    -String ultimoAviso
    +Alumno(String nombre)
    +actualizar(String aviso) void
    +getUltimoAviso() String
}
class Demo {
    +main(String[] args) void$
}
Curso ..|> Sujeto
Alumno ..|> Observador
Curso "1" --> "0..*" Observador : notifica
Demo ..> Curso : crea y publica
Demo ..> Alumno : crea y suscribe
```

## Secuencia completa de la demo principal

Las llamadas se ejecutan en el mismo hilo. Los retornos se omiten para destacar las entregas. `LinkedHashSet` conserva el orden de suscripción: Ana, luego Luis.

```mermaid
sequenceDiagram
autonumber
participant D as Demo
participant C as curso:Curso
participant A as ana:Alumno
participant L as luis:Alumno
Note over D,L: Demo crea el curso y los dos alumnos
D->>C: suscribir(ana)
D->>C: suscribir(luis)
Note over C: observadores = [Ana, Luis]
D->>C: publicarAviso("TP disponible")
activate C
Note over C: Validar y guardar ultimoAviso
C->>C: notificar()
Note over C: Capturar aviso y copiar observadores
C->>A: actualizar("TP disponible")
Note over A: Guardar e imprimir el aviso
C->>L: actualizar("TP disponible")
Note over L: Guardar e imprimir el aviso
deactivate C
D->>C: desuscribir(luis)
Note over C: observadores = [Ana]
D->>C: publicarAviso("Entrega: martes 06/10")
activate C
Note over C: Validar y guardar el nuevo aviso
C->>C: notificar()
C->>A: actualizar("Entrega: martes 06/10")
deactivate C
Note over A: ultimoAviso = "Entrega: martes 06/10"
Note over L: ultimoAviso sigue siendo "TP disponible"
```

## Flujo de una publicación

El aviso y los destinatarios se capturan para la ronda. Las altas y bajas durante una entrega afectan las rondas siguientes. La excepción de un receptor se propaga: el código no la captura para continuar con los demás.

```mermaid
flowchart TD
    A["publicarAviso(aviso)"] --> B{"¿aviso nulo o vacío?"}
    B -->|Sí| E["Lanzar IllegalArgumentException"]
    B -->|No| C["ultimoAviso = aviso"]
    C --> D["notificar(): capturar el aviso"]
    D --> F["Copiar el LinkedHashSet de observadores"]
    F --> G{"¿Queda un observador en la copia?"}
    G -->|Sí| H["observador.actualizar(aviso)"]
    H -->|Termina normalmente| G
    H -->|Lanza una excepción| J["Propagarla e interrumpir la ronda"]
    G -->|No| I["Finalizar la publicación"]
```

## Lectura del estado final

| Objeto | Estado | Último aviso |
| --- | --- | --- |
| `curso` | Suscriptos: `[Ana]` | `Entrega: martes 06/10` |
| `ana` | Suscripta | `Entrega: martes 06/10` |
| `luis` | Desuscripto | `TP disponible` |

La presentación utiliza vistas resumidas de estos diagramas. La diapositiva 7 del HTML permite avanzar por las instantáneas de esta ejecución.
