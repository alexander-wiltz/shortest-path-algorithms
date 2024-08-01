# Shortest Path Implemenations
### Kürzeste Wege auf allgemeinen Graphen

##### Studienarbeit - Alexander Wiltz
JAVA-Implementierungen von Kürzeste-Wege-Algorithmen

### Dijkstra
Die Idee des Algorithmus ist es, immer der Kante zu folgen, die die kürzeste Entfernung
vom Startknoten zu sein scheint. Andere Kanten werden erst dann betrachtet, wenn
alle kürzeren Entfernungen berücksichtigt wurden. Diese Art und Weise stellt sicher,
dass bei Erreichen eines Knotens kein kürzerer Pfad zu ihm existiert. Eine berechnete
Distanz zwischen einem Startknoten und einem besuchten Knoten wird gespeichert. Die
kumulierten Distanzen zu noch nicht betrachteten Knoten können sich im Laufe des
Algorithmus verändern, nämlich verringern. Dieses Schema wird so lange fortgesetzt,
bis die Distanz zum Zielknoten berechnet wurde oder die Distanzen aller Knoten zum
Startknoten bekannt sind. Die Knoten für die noch nicht die kürzeste Distanz gefunden.

##### Vorbereitung
1. Tabelle erstellen mit allen Knoten und den Attributen: Vorgänger und Gesamtdistanz
2. Gesamtdistanz des Startknotens auf 0 setzen und für alle anderen auf unendlich

##### Abarbeitung
   Solange die Tabelle noch Knoten enthält, werden alle Elemente mit jeweils der kleinsten
   Gesamtdistanz genommen und folgendes gemacht:
1. Speichere, das Knoten betrachtet wurde
2. Prüfung: Ist das betrachtete Element der Zielknoten? Wenn ja, Backtrace über Vor-
   gänger bis zum Start
3. Betrachte Nachbarknoten die noch in Tabelle sind:
   1. Kalkuliere Gesamtdistanz aus Summe der Gesamtdistanz des betrachteten Kno-
         tens und Distanz zum Nachbarelement
   2. Prüfe: Errechnete Gesamtdistanz kleiner als aktuelle Gesamtdistanz, dann über-
         schreibe

### A-Stern
Der A*-Algorithmus untersucht die Knoten zuerst, die wahrscheinlich schnell zum Ziel
führen. Um den vielversprechendsten Knoten zu berechnen, wird allen Knoten 𝑥 jeweils
ein Wert 𝑓(𝑥) zugeordnet, der eine Abschätzung angibt, wie weit der Pfad vom Start zum
Ziel unter Verwendung des betrachteten Knotens im optimalen Fall ist. Der Knoten mit
den geringsten Kosten wird als nächster untersucht.

##### 𝑓 (𝑥) = 𝑔(𝑥) + ℎ(𝑥)

Für einen Knoten 𝑥 bezeichnet 𝑔(𝑥) die bisherigen Kosten vom Startknoten aus, um 𝑥
erreichen zu können. ℎ(𝑥) bezeichnet die geschätzten Kosten (Heuristik) von 𝑥 bis zum
Zielknoten. Die verwendete Heuristik darf die Kosten nie überschreiten. Für eine Wegsuche 
ist die euklidische Distanz eine geeignete Annahme: Die tatsächliche Strecke ist nie
kürzer als die Luftlinie.
Der A*-Algorithmus ist vollständig, falls eine Lösung existiert, wird sie gefunden. Der
Algorithmus ist optimal, es wird immer die optimale Lösung gefunden und wenn mehrere
existieren, wird eine gefunden. Weiterhin ist der A*-Algorithmus optimal effizient, das
heißt es gibt keinen anderen Algorithmus, der die Lösung unter Verwendung der gleichen
Heuristik schneller findet.

##### Vorbereitung
1. Tabelle erstellen mit allen Knoten, den entsprechenden Vorgängerknoten, die Ge-
   samtkosten vom Start, den minimalen Restkosten zum Ziel und der Summe aller
   Kosten
2. Gesamtkosten des Startknotens auf 0 setzen und für alle anderen auf unendlich
3. Mittels Heuristik die minimalen Restkosten zum Ziel für alle Knoten bestimmen

##### Abarbeitung
Solange die Tabelle noch Knoten enthält, werden alle Elemente mit jeweils der kleinsten
   Kostensumme genommen und folgendes gemacht:
1. Prüfung: Ist das betrachtete Element der Zielknoten? Wenn ja, Backtrace über Vor-
   gänger bis zum Start
2. Betrachte Nachbarknoten des entnommenen Elements die noch in Tabelle sind:
   1. Ermittel die Gesamtkosten vom Start als Summe der Gesamtkosten vom Start
      zum entnommenen Knoten addiert mit den Kosten vom entnommenen Knoten
      zum betrachteten Nachbarknoten
   2. Prüfe: Errechnete Gesamtdistanz kleiner als aktuelle Gesamtdistanz, dann
      1. Berechne für den Nachbarknoten die Summe aus den berechneten Gesamt-
      kosten vom Start und den Restkosten zum Ziel
      2. Setze als Vorgänger des Nachbarknotens den entnommenen Knoten
      3. Setze für den Nachbarknoten die neu berechneten Gesamtkosten und die
      Kostensumme

### Bellmann-Ford
Der Bellman-Ford-Algorithmus ähnelt dem Algorithmus von Dijkstra. Der Unterschied ist,
dass im Gegensatz zum Dijkstra-Algorithmus keine Knoten priorisiert werden, sondern
dass der Iteration aller Kanten gefolgt wird und die Gesamtkosten vom Startknoten zum
Zielknoten aktualisiert werden, sofern diese eine Verbesserung gegenüber des Aktualzustands 
bedeuten. Aufgrund der Untersuchung aller vorhandenen Knoten ist die Anzahl
der Iteration maximal 𝑛 − 1.

##### Vorbereitung
1. Tabelle erstellen mit allen Knoten, den entsprechenden Vorgängerknoten und den
   Gesamtkosten vom Start
2. Gesamtkosten des Startknotens auf 0 setzen und für alle anderen auf unendlich

##### Abarbeitung 
Führe folgende Anweisungen 𝑛 − 1 mal durch, dabei ist n die Anzahl der Knoten
1. Für jede Kante des Graphen:
   1. Summe berechnen aus Gesamtkosten zum Startknoten und Kantengewicht
   2. Wenn die Summe niedriger als aktuelle Gesamtkosten des Kanten-Endknotens,
   setze Vorgänger des Endknotens auf Startknoten und die Gesamtkosten des
   Endknotens auf die zuvor berechnete Summe 
2. Wenn in einer Iteration keine Änderungen vorgenommen wurden, Abarbeitung
   beenden

   Wenn der Algorithmus nicht beendet wurde, prüfe auf negative Zyklen
   1. Für jede Kante des Graphen:
      1. Summe berechnen aus Gesamtkosten zum Startknoten und Kantengewicht
      2. Wenn die Summe niedriger als aktuelle Gesamtkosten des Kanten-Endknotens,
      beende den Algorithmus wegen eines entdeckten negativen Zyklus

### Floyd-Warshall
Der Floyd-Warshall-Algorithmus basiert auf dem Prinzip der dynamischen Programmierung, das heißt das zum algorithmischen Lösen eines Optimierungsproblems eine Auftei-
lung in Teilprobleme stattfindet und Zwischenresultate systematisch gespeichert werden.

##### Vorbereitung
1. Kostenmatrix der Größe 𝑛 × 𝑛 (n ist die Anzahl der Knoten) erstellen.
2. Für jedes Knotenpaar (𝑖, 𝑗) die Kosten des direkten Pfades von 𝑖 nach 𝑗 vorbelegen,
   sofern existent, sonst unendlich.
3. Für die Diagonalen Nullen eintragen.

##### Vorbereitung Nachfolgermatrix
1. Nachfolgermatrix der Größe 𝑛 × 𝑛 erstellen.
2. Für jedes Knotenpaar (𝑖, 𝑗) den Wert 𝑗 eintragen.

##### Abarbeitung
   Führe folgende Iteration 𝑛 mal aus; 𝑘 sei dabei der Schleifenzähler und stehe für den
   Zwischenknoten:
1. Für jedes Knotenpaar (𝑖, 𝑗):
   1. Summe der Kosten des Weges 𝑖 → 𝑘 berechnen und die Kosten des Weges
   𝑘 → 𝑗 berechnen.
   2. Ist die Summe kleiner als die Kosten des Weges 𝑖 → 𝑗, dann:
      1. trage die niedrigeren Kosten in Zeile i, Spalte j der Kostenmatrix ein
      2. kopiere in der Nachfolgermatrix den Wert aus Feld (𝑖, 𝑘) ins Feld (𝑖, 𝑗).
      Prüfe, ob auf der Diagonalen der Kostenmatrix eine negative Zahl vorkommt. Wenn ja,
      beende den Algorithmus mit Fehlerausgabe.