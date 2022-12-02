# TpLudoAlgo3
Este repositorio se basa en crear el juego Ludo para la materia de Algoritmos y Progrmacion III de la FIUBA.
Integrantes: 
- Luciano Vazquez
- Ignacio Cabaleiro


Juego: 

- Vamos a realizar el juego de mesa "Ludo" en el lenguaje JAVA.
  Adjuntamos este link donde se explica detalladamente el juego, su objetivo y reglas.
  https://www.magnojuegos.com/ludo-online/reglas
- Tablero: https://user-images.githubusercontent.com/104601880/201536504-ed1f8a9b-ba0e-447c-b14d-a2c2ea4963c2.png (mirar para el seguimiento de las posiciones de las listas!!)



Patrones de diseño:

    Utilizamos:
    
  - Strategy: para que al momento de elegir la ficha a mover se diferencia en si la ficha la elige el usuario o si lo hace la máquina. Tambien para el momento el que sale un 6 para diferenciar de la funcionalidad de este dependiendo quien sea el usuario.
  
  - Command: para que cuando el usuario saque un 6 en el dado, pueda elegir si quiere sacar una nueva ficha de su base o mover alguna de las fichas que tenga en el           tablero (en el caso que las tenga).



        Instrucciones/advertencias para ejecutar el juego:
  
  -Lo primero que se pedira es que coloque si cada jugador va a hacer manejado por el usuario o que se maneje "automaticamente". ¡Procurar poner unicamente "normal" o "maquina"! (no encontramos una forma sin usar 4 whiles :( ) 

  -Si pone que todos los jugadores son maquinas el juego se simulara solo.
  
  -El jugador que empezara tirando el dado es dado de forma aleatoria. Lo seguira el color de su derecha en el tablero y asi sucesivamente.
  
  -Cuando salga un 6, se le va a preguntar si quiere sacar una ficha o mover. Debe escribir "sacar ficha" o "mover ficha" segun corresponda.
  
  -Si escribe "mover ficha" sin tener ninguna ficha en el tablero se le pondra una ficha automaticamente en el juego.
  
  -Cuando llega la hora de mover una ficha se le imprimira por pantalla las fichas que tiene con su respectivo número. Luego se le preguntara que ficha quiere mover y  lo que tiene que hacer es simplemente poner el número de la ficha que quiere mover.
  
  -Cuando una ficha llegue a la meta se le eliminara la posiblidad de mover esa ficha.
  
  -Tener en cuenta que existe la posilbilidad de que una ficha coma a otra, si pasa esto la ficha comida saldra del tablero y el jugador que comio va a tener un turno extra.
  
  -Si saca 6 tendra un turno extra.
  
  -Si saca tres 6 seguidos automaticamente se cambiara de turno sin dar chance a que mueva o saque ficha.
  
