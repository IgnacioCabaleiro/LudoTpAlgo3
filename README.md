# TpLudoAlgo3
Este repositorio se basa en crear el juego Ludo para la materia de Algoritmos y Progrmacion III de la FIUBA. Este proyecto fue creado en Windows en el IDE Eclipse y se trata de un Maven Project. 

Integrantes: 

- Luciano Vazquez
- Ignacio Cabaleiro


`Juego: `

- Vamos a realizar el juego de mesa "Ludo" en el lenguaje JAVA.
  Adjuntamos este link donde se explica detalladamente el juego, su objetivo y reglas.
  https://www.magnojuegos.com/ludo-online/reglas
- Tablero: https://user-images.githubusercontent.com/104601880/201536504-ed1f8a9b-ba0e-447c-b14d-a2c2ea4963c2.png (mirar para el seguimiento de las posiciones de las listas!!)



`Patrones de diseño:`

Utilizamos:
    
  - Strategy: para que al momento de elegir la ficha a mover se diferencia en si la ficha la elige el usuario o si lo hace la máquina. Tambien para el momento el que sale un 6 para diferenciar de la funcionalidad de este dependiendo quien sea el usuario.
  
  - Command: para que cuando el usuario saque un 6 en el dado, pueda elegir si quiere sacar una nueva ficha de su base o mover alguna de las fichas que tenga en el           tablero (en el caso que las tenga).



   `Instrucciones:`
   
  .1er paso: Presione "Si" o "No" si quiere una alerta que le mostrara cada turno de quien es el turno y cuanto saco en el dado.
  
  .2do paso: Seleccionar "maquina" si quiere que las fichas de dicho color sean manejados por la maquina* o "normal" si quiere manejarlos por su propia cuenta.
  
  .3er paso: Presione el botón y le saltara un cartel diciendo que número saco y tambien parpaderean las fichas del jugador el cual sea el turno.
  
  .4to paso: Una vez que clickee en "Aceptar", su pieza estara lista para mover en el caso que sea posible. Toca que ficha queres mover y se movera. En el caso que no se mueva es porque no se la puede mover. Repetir hasta que un color lleve sus 4 fichas a la ultima casilla.
  
  *que sean "manejados por la maquina" quiere decir que se elije aleatoriamente que ficha se a mover.
  
  
  `Avertencias:`
  
  -Cuando el botón este habilitado es porque debe tocarlo, en caso contrario es que una acción debe llevarse a cabo (sacar o mover ficha). 
  
  -Una vez terminado el juego se le mostrara por pantalla una tabla de posiciones en base a la cantidad de fichas que llegaron a la meta. 
  
  -Al 3er 6 se le cambiara de turno (por reglas del juego).
  
  -El color de las fichas que parpadeen, es el color del jugador que deberia mover y/o se le avisara por pantalla(dependiendo que haya elegido en el 1er paso). 
  
  -Si cuando es su turno toca una ficha que esta en la recta final y no se puede mover ( debido a que su posicion + movmiento > 6 ), perdera el turno. Procurar tocar la ficha que desea mover.
  
