# Práctica Programada 3 – Listas Doblemente Circulares

## Estudiante
**Nombre:** Jesús Ignacio Álvarez Briceño  
**Carné:** FI22028012  
**IDE utilizado:** Visual Studio Code  

---

## Descripción general
Esta práctica tiene como propósito familiarizarse con las estructuras de datos tipo **lista** en el lenguaje Java, específicamente implementando una **lista circular doblemente enlazada**.  
El programa utiliza nodos con valores numéricos entre 0 y 9, generados aleatoriamente, para aplicar los métodos fundamentales de inserción y eliminación en ambas direcciones de la lista.

---

## Objetivo
Implementar los métodos `addFirst`, `addLast`, `removeFirst` y `removeLast` de la clase **ListDoublyCircular**, respetando las propiedades de una lista circular doblemente enlazada y garantizando la correcta actualización de las referencias `head` y `tail`.

---

## Estructura del repositorio
```
PP3/
 ├── ListInterface.java
 ├── ListDoublyCircular.java
 ├── NodeDoubly.java
 ├── .gitignore
 └── README.md
```

---

## Fuentes de apoyo consultadas
Durante el desarrollo se revisaron los siguientes recursos:

- [Documentación oficial de Oracle Java SE 21](https://docs.oracle.com/en/java/javase/21/)
- [GeeksforGeeks – Doubly Circular Linked List](https://www.geeksforgeeks.org/doubly-circular-linked-list/)
- [W3Schools – Java LinkedList Tutorial](https://www.w3schools.com/java/java_linkedlist.asp)
- Consultas realizadas mediante ChatGPT (OpenAI, modelo GPT-5)

---

## Prompts y respuestas de IA utilizadas

**Prompt 1:**  
> “¿Podrías ayudarme a implementar los métodos addFirst, addLast, removeFirst y removeLast en una lista circular doblemente enlazada en Java, asegurando la correcta actualización de punteros?”

**Respuesta resumida:**  
La IA explicó cómo mantener la circularidad de los nodos mediante los punteros `prev` y `next`, cuidando los casos especiales (lista vacía y lista con un solo nodo).  
Se proporcionó el código completo para los cuatro métodos, garantizando que las referencias `head` y `tail` siempre apunten a los nodos correctos y que los punteros internos mantengan la estructura circular.

**Prompt 2:**  
> “Explícame la diferencia entre usar una lista creada manualmente y las estructuras nativas de Java como List o LinkedList.”

**Respuesta resumida:**  
La IA indicó que las listas creadas manualmente son útiles para el aprendizaje, el control del comportamiento interno y la comprensión de punteros, mientras que las listas nativas son más eficientes, seguras y optimizadas para producción.

---

## Respuestas personales

### 1. Estructura para una Cola (Queue)
Utilizaría una **lista circular doblemente enlazada**, ya que permite insertar elementos por un extremo (`addLast`) y eliminarlos por el otro (`removeFirst`) sin necesidad de recorrer la lista.  
Esta estructura garantiza que las operaciones de encolado y desencolado sean eficientes (O(1)) y mantiene la conexión continua entre el primer y el último nodo.

### 2. Estructura para una Pila (Stack)
Para una pila, emplearía una **lista simplemente enlazada**, ya que solo se requieren operaciones en un extremo (tipo LIFO: Last In, First Out).  
Con una lista simple, la inserción y eliminación se realizan al inicio (`push` y `pop`) sin necesidad de mantener referencias dobles, optimizando memoria y simplicidad.

### 3. Ventajas de usar una lista creada manualmente
- Permite comprender el funcionamiento interno de las estructuras dinámicas.  
- Brinda control total sobre cómo se enlazan y actualizan los nodos.  
- Es ideal para fines académicos y de aprendizaje de algoritmos.

### 4. Desventajas frente a las listas estándar de Java
- Mayor riesgo de errores de implementación (referencias nulas o ciclos mal cerrados).  
- No están optimizadas ni probadas para grandes volúmenes de datos.  
- Requieren más tiempo de desarrollo y mantenimiento.  

---

## Conclusión
La práctica permitió comprender cómo se comportan las listas doblemente circulares en Java, reforzando el manejo de punteros, referencias y lógica de inserción y eliminación.  
Además, ayudó a contrastar la implementación manual de estructuras con las opciones predefinidas del lenguaje, fomentando el aprendizaje profundo sobre la gestión dinámica de datos.

---

**Fecha de elaboración:** Noviembre, 2025  
**Versión de Java:** OpenJDK 21 (LTS)  
**Autor:** Jesús Ignacio Álvarez Briceño
