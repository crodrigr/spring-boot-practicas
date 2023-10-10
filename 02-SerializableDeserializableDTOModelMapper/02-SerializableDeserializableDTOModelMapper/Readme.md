# ModelMapper

Este una ejemplo de como se crea un DTO para las clases de tipo Entity: Estundiante, Universidad, Matricula

<br>
<br>

## @JsonIgnoreProperties({"hibernateLazyInitializer"})

Esta anotación evita que tengamos que usar DTO para manejar la respuesta que se están enviando en JSO

Cuando tienes una relación `@ManyToOne` o `@OneToOne` con una carga perezosa (`FetchType.LAZY`) en Hibernate, es posible que ocurran problemas de serialización circular si no se manejan correctamente. Esto se debe a que, cuando se serializa un objeto que tiene una relación con carga perezosa, Hibernate puede tratar de cargar los datos relacionados de manera perezosa en el proceso de serialización, lo que a su vez puede desencadenar la serialización de más objetos relacionados y causar un bucle infinito de serialización.

La anotación `@JsonIgnoreProperties({"hibernateLazyInitializer"})` se utiliza comúnmente en combinación con Jackson para evitar estos problemas de serialización circular al indicarle a Jackson que ignore la propiedad `hibernateLazyInitializer` durante la serialización.

En tu caso, si tienes una relación `@ManyToOne` con `FetchType.LAZY` hacia la entidad `UniversidadEntity`, es posible que desees agregar `@JsonIgnoreProperties({"hibernateLazyInitializer"})` en la definición de la propiedad `universidad` de la siguiente manera:

```java
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@JoinColumn(name = "universidad_id")    
@ManyToOne(fetch = FetchType.LAZY)
private UniversidadEntity universidad;
```

Esto asegura que cuando se serializa una instancia de la entidad que contiene esta relación, la propiedad `hibernateLazyInitializer` se ignore durante la serialización y evite problemas de serialización circular.

Sin embargo, ten en cuenta que esta anotación solo se debe agregar cuando sea necesario y cuando enfrentes problemas de serialización circular específicos. No es necesario agregarla en todas partes, y en algunos casos, podría ser preferible manejar los problemas de serialización circular de otras maneras, como a través del uso de DTO (Objetos de Transferencia de Datos) o configuraciones personalizadas de Jackson.


## 2. Implementación de ModelMapper

Se debe colocar la dependencia de **ModelMapper** en el archivo **pom.xml** como se oberva en la siguiente imagen:

![image](https://github.com/crodrigr/spring-boot-practicas/assets/31961588/f3515c79-0328-4586-bd1f-e4bf483fb365)


#### 2.1 ModelMapperConfig

En el directorio **config** se crea una clase **ModelMapper** la cual se define un **Bean** para implemetar el mapper.

![image](https://github.com/crodrigr/spring-boot-practicas/assets/31961588/71df694a-36aa-4db1-8e9f-11f5ce889320)

Se crean la clase **DTO**

![image](https://github.com/crodrigr/spring-boot-practicas/assets/31961588/aa744ccb-e11a-4540-b7ae-3a2b185f3075)

Se crea la clase **Convert**

![image](https://github.com/crodrigr/spring-boot-practicas/assets/31961588/dfc589ec-3f98-41d0-92b8-cae3858bca22)

Implementción convert Entity to DTO

![image](https://github.com/crodrigr/spring-boot-practicas/assets/31961588/826c9b13-4b54-4010-b177-1dc700c95935)




