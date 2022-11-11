# TpLudoAlgo3
Este repositorio se basa en crear el juego Ludo para la materia de Algoritmos y Progrmacion III de la FIUBA.
Integrantes: 
- Luciano Vazquez
- Ignacio Cabaleiro


Juego: 

- Vamos a realizar el juego de mesa "Ludo" en el lenguaje JAVA.
  Adjuntamos este link donde se explica detalladamente el juego, su objetivo y reglas.
  https://www.magnojuegos.com/ludo-online/reglas
- Tablero: https://www.marketing-branding.com/wp-content/uploads/2021/03/Ludo-online-pro-google-jugar-aqui.jpg



Patrones de diseño:

    Teniamos pensado utilizar:
    
  - Strategy: para que al momento de elegir la ficha a mover se diferencia en si la ficha la elige el usuario o si lo hace la máquina.
  
  - Command: para que cuando el usuario saque un 6 en el dado, pueda elegir si quiere sacar una nueva ficha de su base o mover alguna de las fichas que tenga en el           tablero (en el caso que las tenga).


<Instrucciones/advertencias para ejecutar el juego>:

  -Cuando salga un 6, se le va a preguntar si quiere sacar una ficha o mover. Debe escribir "sacar ficha" o "mover ficha" segun corresponda.
  
  -Si escribe "mover ficha" sin tener ninguna ficha en el tablero se le pondra una ficha automaticamente en el juego.
  -Cuando llega la hora de mover una ficha se le imprimira por pantalla las fichas que tiene con su respectivo número. Luego se le preguntara que ficha quiere mover y  lo que tiene que hacer es simplemente poner el número de la ficha que quiere mover.
  
  -Cuando una ficha llegue a la meta se le eliminara la posiblidad de mover esa ficha.
  
  -Tener en cuenta que existe la posilbilidad de que una ficha coma a otra, si pasa esto la ficha comida saldra del tablero y el jugador que comio va a tener un turno extra.
  
  -Si saca tres 6 seguidos automaticamente se cambiara de turno sin dar chance a que mueva o saque ficha.
  
  -Por ahora si se desea cambiar el tipo de jugador (osea "normal" o "maquina") se tiene que cambiar en inicializarJuego() en Ludo.java donde se crean los jugadores. Posteriormente se le preguntara al usuario que tipo de jugador desea ser. 
  
  -Con respecto a el tipo de jugador IA lo que pudimos hacer es que elija aleatoriamente que ficha mover pero nosotros tenemos que decidir cuando saque un 6 si quiere mover o sacar ficha.


Instrucciones para ejecutar las pruebas: 

-TEST 1,2,3,4: siguiendo las instrucciones previamente dichas, se tendra que ingresar por terminal el unico número de ficha disponible (1)

-TEST 5: siguiendo las instrucciones previamente dichas, se debera ingresar cualquiera de las fichas que esten disponibles en cada turno, con el objetivo de que todas lleguen a la meta.

  
