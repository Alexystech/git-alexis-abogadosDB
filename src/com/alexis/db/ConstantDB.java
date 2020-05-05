package com.alexis.db;

/**
 * este clase me sirve para poder implementar las
 * tablas de la base de datos abogadosDB
 * notece que estan los nombres de las columnas
 * de la base de datos ya mencionada
 * **/

public class ConstantDB {
    public static final String URL      = "jdbc:mysql://localhost:3306/";
    public static final String DB       = "abogadosDB";
    public static final String USER     = "root";
    public static final String PASSWORD = "1414";

    public static final String TCLIENTE             = "cliente";
    public static final String TCLIENTE_CLIENTEDNI  = "clienteDNI";
    public static final String TCLIENTE_NOMBRE      = "nombre";
    public static final String TCLIENTE_DIRECCION   = "direccion";

    public static final String TPROCURADOR                  = "procurador";
    public static final String TPROCURADOR_PROCURADORDNI    = "procuradorDNI";
    public static final String TPROCURADOR_NOMBRE           = "nombre";
    public static final String TPROCURADOR_DIRECCION        = "direccion";

    public static final String TASUNTO                          = "asunto";
    public static final String TASUNTO_CLIENTE_CLIENTEDNI       = "cliente_clienteDNI";
    public static final String TASUNTO_PROCURADOR_PROCURADORDNI = "procurador_procuradorDNI";
    public static final String TASUNTO_FECHAINICIO              = "fechaInicio";
    public static final String TASUNTO_FECHAARCHIVO             = "fechaArchivo";
    public static final String TASUNTO_ESTADO                   = "estado";
}
