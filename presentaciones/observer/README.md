# Observer — material para presentar

Muestra basada en `Patrones-Completos` (`cf8dbfc`). Incluye **10 diapositivas**, UML de clases, secuencias de entrega y baja, código relevante, salida real y consecuencias del patrón.

Para repasar el tema antes de exponer, consultá el [resumen de estudio de Observer](../../src/main/java/com/patronesingsoft/behavioral/Observer/resumen-estudio.md).

## Abrir

- [Presentación HTML](presentacion.html): abrir con un navegador. Funciona sin conexión y sin instalar dependencias.
- [PowerPoint editable](observer.pptx): texto, diagramas y flechas son objetos editables. Contiene notas para el expositor y enlaces al código utilizado.
- [Diagramas Mermaid](diagramas.md): clases, secuencia completa y flujo de publicación. GitHub renderiza los bloques del archivo.
- [Vista previa del UML](vista-previa.png).

En el HTML, usar **← / →** para cambiar de diapositiva. En la **diapositiva 7**, usar **Paso siguiente** o **Espacio** para recorrer la ejecución; **R** reinicia el recorrido. El selector permite saltar a cualquier diapositiva. Los botones permiten mostrar notas y activar pantalla completa. Al imprimir, se incluyen las diez diapositivas con el estado final del recorrido.

El recorrido HTML muestra instantáneas del código Java; no ejecuta Java en el navegador. El PowerPoint muestra el estado final y las dos secuencias como diagramas estáticos.

## Orden de exposición sugerido (6–8 minutos)

| Diapositiva | Tema |
| --- | --- |
| 1 | Observer y el ejemplo del curso |
| 2 | Problema y solución |
| 3 | Participantes y relaciones UML |
| 4 | Publicar, validar y disparar la entrega |
| 5 | Secuencia del primer aviso |
| 6 | Baja de Luis y segunda publicación |
| 7 | Estado y consola paso a paso |
| 8 | Copia de destinatarios y aviso de la ronda |
| 9 | Salida real y comprobaciones |
| 10 | Cuándo usarlo y qué cuidar |

## Comprobar el ejemplo

Desde la raíz del repositorio, en PowerShell:

```powershell
$fuentesObserver = Get-ChildItem -Filter '*.java' 'src/main/java/com/patronesingsoft/behavioral/Observer'
javac --release 17 -encoding UTF-8 -Xlint:all -d target/observer $fuentesObserver.FullName
java -ea -cp target/observer com.patronesingsoft.behavioral.Observer.Demo
```

Salida:

```text
Ana recibio: TP disponible
Luis recibio: TP disponible
Ana recibio: Entrega: martes 06/10
Observer: entrega, baja y duplicados verificados.
```

El HTML comprueba al abrir que existen diez diapositivas, que el estado final coincide con la demo y que la navegación respeta sus límites. Para repetir esta comprobación desde la consola del navegador: `observerSelfCheck()`.

## Código de referencia

[Observer en el repositorio](../../src/main/java/com/patronesingsoft/behavioral/Observer/README.md). Los enlaces en las notas del PowerPoint apuntan al commit usado, para conservar la referencia si luego cambia la rama.
