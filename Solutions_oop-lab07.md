# oop-lab07 - Teoria

## Documentazione del Codice

La documentazione di un progetto software è fondamentale al fine di garantire la manutenibilità all'interno di esso e del proprio team di sviluppo.

Si utilizza lo strumento javadoc per generare automaticamente documentazione HTML per Java tramite una specifica sintassi nei commenti:

- Vengono processati tutti i commenti del tipo `/* … */`

- Tali commenti si devono trovare in testa alle dichiarazioni di qualsiasi oggetto da documentare

- Esiste una sintassi specifica per ogni informazione da documentare



## Build Lifecycle

La costruzione della documentazione è parte integrante del processo di costruzione software, che è costituito da diverse fasi (dette task).

Gradle mappa con tali task il processo di costruzione software: l'esecuzione di un task implica anche l'esecuzione di tutti i task precedenti.

Si può eseguire l'intero lifecycle con il comando `./gradlew build`.



## Tag Informativi

Tra i tag usati solitamente nella documentazione si può trovare:

- `@param`: usato per descrivere un parametro di input nei metodi o un type-parameter in classi/metodi generici

- `@return`: usato per descrivere il valore di ritorno

- `@throws`: usato per descrivere l'eccezione di un costruttore/metodo e il motivo del lancio di essa

- `@see`: usato per indicare altre entità la cui documentazione per risultare d'interesse
(ad esempio una funzionalità su collezioni generiche potrebbe fare riferimento a List e Set)

- `@Deprecated`: usato per indicare che tale entità usata è deprecata. Non viene rimossa per motivi di retrocompatibilità e si dovrebbe indicare cosa utilizzare in sostituzione



## Tag Descrittivi

Tra i tag usati solitamente per la formattazione del testo si può trovare:

- `{@link target}`: consente di fare collegamenti ipertestuali ad entità della stessa classe o esterne

- `{@code testo}`: formatta il testo con un font monospaziato

- `{@inheritDoc}`: copia la javadoc di una superclasse in quella correte, si usa nei metodi che fanno override per evitare ripetizioni



Ci sono anche altri tag, il cui utilizzo al momento è sconsigliato: `@since`, `@author`, `@version`



## Commenti

Alcune linee guida per commentare:

- Inserire sempre un commento descrittivo generale per interfacce/classi

- Inserire un commento per ogni costruttore, metodo e campo con livello d'accesso `public` e `protected`

- Non è necessario commentare metodi private e di cui si fa l'override (in questo caso usare `{@inheritDoc}`)



Si può utilizzare la javadoc appoggiandola su Gradle per generare documentazione: il plugin java di Gradle aggiunge il task javadoc che documenta tutto il sorgente in `src/main/java`, generando il risultato in build.
Se la javadoc è incompleta, il task fallisce.



# oop-lab07 - Esercizi

Comandi per clonare correttamente la repo in locale

`git clone https://github.com/unibo-oop/lab07.git`

`cd lab07`

`git remove remote origin`

creo la repo su github

`git remote add origin https://github.com/Tr3cNik/oop-lab07.git`

`git push -u origin exercises`



## Esercizio 71

Guarda i commit



## Esercizio 72

`identity()` è un metodo e non una costante public static perché usando il generico è possibile non specificare il tipo di dato di input e output del metodo, cosa che con la costante `public static` invece si doveva fare.

Guarda l'implementazione, ho fatto tutto incredibilmente


## Esercizio 73

Realizzato un test per `StrictBankAccount`, vedi l'implementazione

