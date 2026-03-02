## HashMaps functions

| Método | Descripción |
|---|---|
| `put(key, value)` | Añade o actualiza un elemento |
| `get(key)` | Obtiene el valor de una key |
| `remove(key)` | Elimina un elemento |
| `containsKey(key)` | ¿Existe esa key? → `boolean` |
| `containsValue(value)` | ¿Existe ese valor? → `boolean` |
| `size()` | Número de elementos |
| `isEmpty()` | ¿Está vacío? → `boolean` |
| `clear()` | Elimina todos los elementos |
| `keySet()` | Devuelve todas las keys → `Set` |
| `values()` | Devuelve todos los valores → `Collection` |
| `entrySet()` | Devuelve pares key-valor → `Set<Map.Entry>` |
| `getOrDefault(key, valor)` | Devuelve el valor o uno por defecto si no existe la key |
| `putIfAbsent(key, value)` | Solo añade si la key no existe ya |
| `replace(key, value)` | Reemplaza el valor de una key existente |

## ArrayList functions

| Método | Descripción |
|---|---|
| `add(value)` | Añade un elemento al final |
| `add(index, value)` | Añade un elemento en una posición concreta |
| `get(index)` | Obtiene el elemento de una posición |
| `set(index, value)` | Reemplaza el elemento de una posición |
| `remove(index)` | Elimina el elemento de una posición |
| `remove(value)` | Elimina la primera ocurrencia de un valor |
| `size()` | Número de elementos |
| `isEmpty()` | ¿Está vacío? → `boolean` |
| `clear()` | Elimina todos los elementos |
| `contains(value)` | ¿Existe ese valor? → `boolean` |
| `indexOf(value)` | Índice de la primera ocurrencia → `int` |
| `lastIndexOf(value)` | Índice de la última ocurrencia → `int` |
| `subList(from, to)` | Devuelve una sublista entre dos índices |
| `sort(Comparator)` | Ordena la lista |
| `toArray()` | Convierte la lista a un array |
| `addAll(collection)` | Añade todos los elementos de otra colección |
| `removeAll(collection)` | Elimina todos los elementos de otra colección |
| `containsAll(collection)` | ¿Contiene todos los elementos de otra colección? → `boolean` |

# Resumen: Java Avanzado — Objetos, Genéricos y Colecciones

---

## Ejercicio 1 — Club de Videojuegos

Los conceptos clave fueron `equals`, `hashCode` y `compareTo`.

### equals y hashCode

Siempre deben basarse en los mismos campos. En este caso solo el `id`, porque es el identificador único del jugador. Gracias a esto, el `HashMap` detecta duplicados correctamente.

La forma moderna de escribir `equals` usa **pattern matching**:

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    return o instanceof Jugador j && Objects.equals(id, j.id);
}
```

> `instanceof Jugador j` hace dos cosas a la vez: comprueba el tipo **y** declara la variable `j` ya casteada.

### Objects

`Objects` es una clase utilitaria de Java (`java.util.Objects`) que protege contra `NullPointerException`. Sus métodos más usados son:

| Método | Para qué sirve |
|---|---|
| `Objects.equals(a, b)` | Comparar sin riesgo de `NullPointerException` |
| `Objects.hash(a, b, ...)` | Generar un `hashCode` combinando varios campos |
| `Objects.toString(o)` | Convertir a String de forma segura |
| `Objects.requireNonNull(o)` | Lanzar excepción si algo es null |

### compareTo

Define el orden natural del objeto. `Collections.sort()` simplemente llama a este método y mueve objetos según devuelva negativo, cero o positivo. Tú decides qué campo comparar y en qué dirección.

| Resultado | Significado |
|---|---|
| Número negativo | `this` va antes que `otro` |
| Cero | Son iguales |
| Número positivo | `this` va después que `otro` |

**El orden en `Integer.compare(a, b)` importa:**

```java
Integer.compare(this.x, otro.x)  // ascendente  (el menor va primero)
Integer.compare(otro.x, this.x)  // descendente (el mayor va primero)
```

---

## Ejercicio 2 — Gestor de Inventario Genérico

Los conceptos clave fueron interfaces genéricas y clases genéricas con restricciones.

### Interfaz genérica

`Identificable<ID>` usa un **placeholder** `ID` que se concreta al implementarla:

```java
public interface Identificable<ID> {
    ID obtenerId();
}

// Al implementar, fijas el tipo concreto
public class Libro implements Identificable<String> {
    public String obtenerId() { return isbn; }
}
```

El nombre `ID` es arbitrario, podría llamarse `T`, `K` o `X`. Solo es un marcador que representa "el tipo que vendrá después".

### extends en el genérico

```java
public class Almacen<T extends Identificable<String>>
```

`extends` aquí cumple dos propósitos distintos:

- `Libro` y `Pelicula` implementan `Identificable` → para que **ellas** cumplan el contrato
- `Almacen` lo pone en el genérico → para que el **compilador** sepa que `T` tiene el método `obtenerId()` y no dé error

Sin el `extends`, Java no permitiría llamar a `item.obtenerId()` dentro de `Almacen` porque `T` podría ser cualquier cosa.

---

## Ejercicio 3 — Liga de Competiciones

Los conceptos clave fueron combinar todo lo anterior con genéricos limitados (*bounded generics*).

### Liga genérica

```java
public class Liga<T extends Comparable<T>>
```

Garantiza que solo entran objetos ordenables, lo que permite llamar a `Collections.sort()` dentro de la propia clase **sin saber nada del tipo concreto**.

### Orden según la clase

Cada clase define su propio `compareTo` con una lógica diferente:

| Clase | Orden | `compareTo` |
|---|---|---|
| `EquipoFutbol` | Más puntos primero | `Integer.compare(otro.puntos, this.puntos)` |
| `Corredor` | Menos tiempo primero | `Integer.compare(this.tiempo, otro.tiempo)` |

`Collections.sort()` no sabe nada de puntos ni tiempos. Solo llama a `compareTo` y mueve objetos según el número que recibe. **Tú tienes el control total** dentro de ese método.

---

## Hilo conductor

Todo gira alrededor de la misma idea: definir **contratos** (interfaces) que garantizan que los objetos tienen ciertos comportamientos, y aprovechar esos contratos en clases genéricas para escribir código reutilizable.

```
equals/hashCode     →  los objetos se comportan bien en HashMaps
compareTo           →  los objetos saben ordenarse a sí mismos
Comparable<T>       →  garantiza que T tiene compareTo
Identificable<ID>   →  garantiza que T tiene obtenerId()
extends en genérico →  le dice al compilador qué métodos puede usar sobre T
```