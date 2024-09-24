# Exercise 6

## a Methoden

### i

> In welchem Fall ist das Überladen von Methoden in Java überhaupt relevant?

```
Antwort: Wenn man mehrere Methoden mit ähnlicher Funktion aber unterschiedlichen Parametern braucht.
```

### ii

> Wie unterscheidet sich das Überladen von dem Überschreiben von Methoden?

```
Antwort: Beim Überladen hat man mehrmals die Methode mit dem gleichen Namen und unterschiedlichen Parametern in der gleichen Klasse, beim Überschreiben wird die Mehtode aus der Superklasse überschrieben. Nach dem LSP sollte die Spezifikation der Super-Methode jedoc weiterhin in der überschreibenden Methode erfüllt werden.
```

### iii

> Wovon hängt die Sichtbarkeit einer Methode ab?

```
Antwort: Von ihrem Modifier.
```

### iv

> Wie können Subklassen in Java die Sichtbarkeit von Methoden ihrer Basisklassen verändern und welche Einschränkungen
> gelten dabei?

```
Antwort: Die Sichtbarkeit kann erweitert, aber nicht verringert werden.
```

## b Abstrake Klassen und Interfaces

### i

> Ist eine Klasse abstrakt, genau dann, wenn sie mindestens eine abstrakte Methode hat? Begründen Sie Ihre Antwort!

```
Antwort: Nein, abstrakte Klassen brauchen nicht zwingend eine abstrakte Methode.
```

### ii

> Nennen Sie einen Vorteil, den Interfaces gegenüber abstrakte Klassen haben.

```
Antwort: Mehrfachvererbung
```

## c Arrays, Listen, Streams

### i

> Nennen Sie ein Alleinstellungsmerkmal, dass die folgenden Konzepte jeweils gegenüber den anderen beiden Konzepten
> haben: Arrays, Listen, Streams.

```
Antwort:
- Arrays: eigener Syntax, kann mit primitiven Datentypen umgehen
- Listen: dynamische Größe, hinzufügen+Entfernen von Elementen
- Streams: können eine "unendliche Größe" haben (z.B. new Random().ints())
```

### ii

> Entscheiden Sie für jede der folgenden Zeilen, ob der Java-Compiler eine Fehlermeldung werfen würde, oder nicht. (
> Gehen Sie davon aus, dass der Code Teil eines Methodenkörpers ist):
> ```
> Number[] n = new Integer[42];
> List<Number> lstNum = new LinkedList<Double>();
> ```

```
Antwort:
- Zeile 1: kein Fehler
- Zeile 2: Fehler, da Double != Number. Würde hier List<? extends Number> stehen, wäre es kein Fehler.
```

## d IntPredicate

### i

> Wie unterscheidet sich das Interface IntPredicate von Interfaces im Generellen?

```
Antwort: Es ist ein functional Interface. Nicht jedes Interface ist eines.
```

### ii

> Wozu kann IntPredicate genutzt werden?

```
Antwort: Lambda-Ausdrücke
```

### iii

> Nennen Sie mögliche Ein- und Ausgabetypen von IntPredicate.

```
Antwort: 
- Eingabe: int
- Ausgabe: boolean
```
