package com.udea.edu.co.directorio;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Hace que Spring reconozca a la clase como cada uno de los documentos en la coleccion emprendimientos
@Document(collection = "emprendimientos")
//Anotacion de Lombok que se encarga de cada uno de los metodos get y set
@Data
//Esta anotacion crea un constructor que crea cada uno de los argumentos como parametros
@AllArgsConstructor
//Esta anotacion crea un constructor que no toma ningun parametro
@NoArgsConstructor
public class Emprendimiento {

    //Spring reconoce esta propiedad como el unico identificador para cada emprendimiento
    @Id
    private ObjectId id;

    private String nombre;

    private String descripcion;

    private String formalizado;

    private String email;

    private String whatsapp;

    private String webpage;

    private String logo;

}
