# Patrones de Diseño I – Patrón Decorator (Decorador)

## . Análisis del patrón

### a. Problema

Un sistema de avisos de la facultad envía notificaciones por email, pero cada área quiere sumarle cosas distintas: algunas también por SMS, otras por WhatsApp, otras con marca de urgente, y muchas combinaciones de las anteriores. Con herencia, habría que crear una subclase por cada combinación:

```java
class NotificadorEmailSMS extends NotificadorEmail { ... }
class NotificadorEmailWhatsApp extends NotificadorEmail { ... }
class NotificadorEmailSMSWhatsApp extends NotificadorEmail { ... }
class NotificadorEmailSMSUrgente extends NotificadorEmail { ... }
// ... y así sucesivamente
```

Esto trae tres problemas:

1. **Explosión de subclases:** con *n* extras opcionales hay hasta 2^n combinaciones posibles. Cada canal nuevo duplica la cantidad de clases.
2. **Combinaciones fijas en compilación:** la herencia es estática; no se puede cambiar el comportamiento de un objeto mientras el programa corre.
3. **Código duplicado:** la lógica de "enviar por SMS" se repite en cada subclase que lo incluye.

### b. Solución

El patrón **Decorator** reemplaza la herencia por **composición**:

1. Se define una interfaz común (`Notificador`) que cumplen el objeto base y los decoradores.
2. Cada decorador **envuelve** a otro `Notificador`, delega en él y agrega su propio comportamiento antes o después.
3. El cliente arma la combinación que necesita **apilando** decoradores en tiempo de ejecución:

```java
Notificador completo = new DecoradorWhatsApp(new DecoradorSMS(new NotificadorEmail()));
completo.enviar("Se abrio la inscripcion a examenes");
```

Cada responsabilidad vive en **una sola clase** y se combina como se necesite. Para agregar un canal nuevo (por ejemplo Telegram) alcanza con **una clase nueva**; no se toca ninguna de las existentes.

### c. Consecuencias

**Ventajas**

- **Más flexible que la herencia:** las responsabilidades se agregan y combinan en tiempo de ejecución, no en compilación.
- **Evita la explosión de subclases:** n decoradores cubren las 2^n combinaciones.
- **Principio Abierto/Cerrado:** se extiende el comportamiento sin modificar `NotificadorEmail` ni los demás decoradores.
- **Responsabilidad única:** cada decorador hace una sola cosa.
- **Transparente para el cliente:** trabaja contra `Notificador` sin saber cuántas capas hay.

**Desventajas**

- **Muchas clases pequeñas:** el diseño queda más fragmentado y puede costar de seguir.
- **El orden importa:** apilar los mismos decoradores en otro orden puede dar otro resultado (ver Caso 4 de la ejecución).
- **Difícil de depurar:** con varias capas anidadas cuesta ver cuál decorador hizo qué.
- **Configuración inicial verbosa:** armar la cadena de `new` anidados es poco legible; suele resolverse con un Factory o Builder.
- **Identidad:** el objeto decorado no es el mismo que el original, así que una comparación por `==` o por tipo concreto puede fallar.

**Implicancias**

- El decorador debe respetar el contrato de la interfaz: si cambia la interfaz base, hay que revisar todos los decoradores.
- Conviene que los decoradores sean livianos y no dependan del orden en que se apilan, o documentar el orden esperado.
- Es el mismo concepto que usa `java.io`: `new BufferedReader(new InputStreamReader(System.in))` apila decoradores sobre un flujo base.
- Se parece al **Proxy** en la estructura (ambos envuelven un objeto con la misma interfaz) pero la intención es distinta: el Decorator **agrega funcionalidad**, el Proxy **controla el acceso**.

---

## . Implementación

El código está en `src/main/java/com/patronesingsoft/Patrones_Estructurales/Decorator/` y pertenece al paquete `com.patronesingsoft.Patrones_Estructurales.Decorator`. Resumen:

- `Notificador` es la interfaz común y `NotificadorEmail` el objeto base.
- `NotificadorDecorador` es el decorador abstracto que guarda el `Notificador` envuelto y delega.
- `DecoradorSMS`, `DecoradorWhatsApp` y `DecoradorUrgente` son los decoradores concretos.
- `Main` muestra el notificador base, la suma de canales, el apilado de varios decoradores y cómo cambia el resultado según el **orden**.

Fragmento clave (decorador base):

```java
public abstract class NotificadorDecorador implements Notificador {

    protected final Notificador envuelto;

    protected NotificadorDecorador(Notificador envuelto) {
        this.envuelto = envuelto;
    }

    @Override
    public void enviar(String mensaje) {
        envuelto.enviar(mensaje);
    }
}
```

Fragmento clave (decorador concreto):

```java
public class DecoradorSMS extends NotificadorDecorador {

    public DecoradorSMS(Notificador envuelto) {
        super(envuelto);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);                       // primero lo que ya hacía el envuelto
        System.out.println("  [SMS] " + mensaje);    // después su aporte
    }
}
```

Fragmento clave (cliente):

```java
Notificador completo = new DecoradorWhatsApp(new DecoradorSMS(new NotificadorEmail()));
completo.enviar("Se abrio la inscripcion a examenes");
```

Salida de la ejecución:

```
=== Caso 1: notificador base (solo email) ===
  [Email] Se abrio la inscripcion a examenes

=== Caso 2: email + SMS ===
  [Email] Se abrio la inscripcion a examenes
  [SMS] Se abrio la inscripcion a examenes

=== Caso 3: email + SMS + WhatsApp (decoradores apilados) ===
  [Email] Se abrio la inscripcion a examenes
  [SMS] Se abrio la inscripcion a examenes
  [WhatsApp] Se abrio la inscripcion a examenes

=== Caso 4a: el ORDEN importa -> SMS por fuera, Urgente por dentro ===
  [Email] [URGENTE] EXAMEN REPROGRAMADO
  [SMS] Examen reprogramado

=== Caso 4b: el ORDEN importa -> Urgente por fuera, SMS por dentro ===
  [Email] [URGENTE] EXAMEN REPROGRAMADO
  [SMS] [URGENTE] EXAMEN REPROGRAMADO
```

En el **Caso 4a** el SMS recibe el mensaje original porque queda *por fuera* de `DecoradorUrgente`; en el **Caso 4b** el mensaje se transforma primero y todos los canales lo reciben como urgente. Es la muestra concreta de que el orden de los decoradores importa.
