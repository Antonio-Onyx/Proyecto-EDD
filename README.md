# Proyecto-EDD
Desarrollo de una aplicación usando todo lo visto en el curso

# Descripcion de la aplicacion
Este proyecto tiene como prop ́osito el desarrollo de un programa interactivo en el que se toman
decisiones sobre la forma de establecer comunicaciones telef ́onicas, de acuerdo a la informaci ́on
de una empresa telef ́onica que posee una red de n estaciones de conmutaci ́on, conectadas por m
enlaces de comunicaci ́on de alta velocidad. El tel ́efono de cada cliente est ́a conectado directamente
con una estaci ́on correspondiente a su  ́area de conexi ́on.

La informacion a almacenar para cada estacion es la siguiente:
  1. **Nombre de la estacion**
  2. **Codigo identificador de area(numero unico)**
  3. **Los clientes cuyo numero esta conectado a la estacion, por cada cliente los datos relevantes son:**
     - *Nombre*
     - *Telefono*
       
La empresa, adem ́as de proporcionar la comunicaci ́on tradicional por audio entre dos clientes,
proporciona un sistema denominado video-fono que permite que dos clientes se vean entre s ́ı durante
una llamada telef ́onica. Sin embargo, para tener una calidad de imagen y audio aceptable en este
sistema entre dos tel ́efonos que se comunican, las estaciones de conmutaci ́on correspondientes deben
estar a distancia no mayor a 6 unidades, por cuestiones de interferencia. La comunicaci ́on entre
dos tel ́efonos debe ser en ambas direcciones, independientemente de que se encuentren conectados
a la misma estaci ́on o a estaciones diferentes y de que se trate de una comunicaci ́on tradicional o
por video-fono.

# 2 Operaciones del programa
Una vez puesto en ejecuci ́on el programa, deber ́a ejecutar la validaci ́on y extracci ́on de informaci ́on
de un archivo con extensi ́on .xml para construir la gr ́afica que modela la red de la empresa. Adem ́as,
deber ́a mostrar un men ́u principal con estas opciones:
  1. Determinar, dados dos tel ́efonos que el usuario introduce, si es posible establecer la comu-
     nicaci ́on por video-fono entre los clientes que los poseen, o en su defecto, la razon especıfica
     por la cual no se puede (no hay forma de llegar de la estaci ́on de un cliente a la otra, o bien,
     la distancia es superior a 6 enlaces de conmutaci ́on). En caso de que sea posible establecer la
     comunicaci ́on, se deber ́an desplegar las estaciones que conforman alguna ruta para efectuarla,
     ya sea por video-fono, o en su defecto, de manera tradicional.
  2. Termina la ejecucion del programa
  
