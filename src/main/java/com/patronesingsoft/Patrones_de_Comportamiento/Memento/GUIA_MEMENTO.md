# Patrón Memento — Guía e Informe

## 1. Problema que resuelve

Cuando un objeto cambia de estado y necesitamos **volver a un estado anterior** (como un *deshacer / undo*),
el problema es:

- No queremos exponer los detalles internos del objeto solo para guardar su estado.
- No queremos acoplar la lógica de "historial" dentro del objeto de negocio.
- Si guardamos el estado con getters/setters públicos, rompemos el encapsulamiento.

Ejemplo típico: un editor de texto, un juego (savepoint), un formulario con "deshacer".

## 2. Solución que propone Memento

Memento divide la responsabilidad en 3 roles:

| Rol | Clase en este ejemplo | Responsabilidad |
|-----|----------------------|-----------------|
| **Originator** | `TextEditor` | Tiene el estado real (`texto`). Sabe crear una "foto" de sí mismo y restaurarse desde una foto. |
| **Memento** | `TextMemento` | Objeto inmutable que guarda una copia del estado. No tiene lógica, solo conserva datos. |
| **Caretaker** | `Historial` | Cuida la pila de fotos. Las guarda y las entrega cuando se pide deshacer, pero **nunca las mira ni las modifica**. |
| **Client** | `MainMemento` | Usa al Originator y al Caretaker para demostrar el flujo guardar → modificar → restaurar. |

La clave: el Caretaker guarda Mementos sin conocer su contenido interno. Así se preserva el encapsulamiento.

## 3. Guía del flujo de este código de ejemplo

Archivo por archivo:

### `TextMemento.java` — la "foto"

Guarda un `String text` final (inmutable) con su getter. No sabe quién lo usa.

### `TextEditor.java` — el objeto con estado

- `escribir(String t)` concatena texto al estado actual.
- `guardarEstado()` toma una foto actual: `new TextMemento(texto)`.
- `restaurar(TextMemento m)` vuelve al estado de la foto: `this.texto = m.getText()`.
- `mostrar()` imprime el estado actual.

### `Historial.java` — la pila de fotos

- `guardar(TextMemento m)` hace `estados.add(m)`.
- `deshacer()` saca y devuelve el último: `estados.remove(estados.size() - 1)`, o `null` si está vacío.

No interpreta el texto guardado: solo apila y desapila.

### `MainMemento.java` — la demo paso a paso

1. `escribir(" Cambio 1 ")` → estado = `" Cambio 1 "`.
2. `guardar(guardarEstado())` → Historial = `[" Cambio 1 "]`. Muestra `Texto:  Cambio 1 `.
3. `escribir(" Cambio 2 ")` → estado = `" Cambio 1  Cambio 2 "`.
4. `guardar(guardarEstado())` → Historial = `[" Cambio 1 ", " Cambio 1  Cambio 2 "]`. Muestra `Texto:  Cambio 1  Cambio 2 `.
5. `escribir(" Cambio 3 ")` → estado = `" Cambio 1  Cambio 2  Cambio 3 "` (**sin guardar**, es el cambio riesgoso). Muestra `Texto:  Cambio 1  Cambio 2  Cambio 3 `.
6. Imprime `Deshacer ultimo cambio`, luego `restaurar(deshacer())` → saca `" Cambio 1  Cambio 2 "` y lo restaura. Muestra `Texto:  Cambio 1  Cambio 2 `.
7. Imprime `Deshacer otro cambio`, luego `restaurar(deshacer())` → saca `" Cambio 1 "` y lo restaura. Muestra `Texto:  Cambio 1 `.

Salida esperada:

```text
Texto:  Cambio 1
Texto:  Cambio 1  Cambio 2
Texto:  Cambio 1  Cambio 2  Cambio 3
Deshacer ultimo cambio
Texto:  Cambio 1  Cambio 2
Deshacer otro cambio
Texto:  Cambio 1
```

### Cómo ejecutarlo

```powershell
mvn -q compile -DskipTests
java -cp target/classes com.patronesingsoft.Patrones_de_Comportamiento.Memento.MainMemento
```

## 5. Resumidamente

> "Memento es como sacar fotos del objeto. El editor posa para la foto, el historial guarda el álbum sin mirar las fotos, y cuando algo sale mal, el editor vuelve a una foto anterior."

Regla de uso: **guardar antes de un cambio riesgoso**, igual que un savepoint en un juego.
