# ModelMapper

Este una ejemplo de como se crea un DTO para las clases de tipo Entity: Estundiante, Universidad, Matricula

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
