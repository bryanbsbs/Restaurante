package com.example.restaurante

class Orden(var entrada: String,
            var entretiempo: String,
            var platoFuerte: String,
            var bebida: String)
{
    override fun toString(): String {
        return """
            Entrada: ${entrada}
            Entretiempo: ${entretiempo}
            Plato fuerte: ${platoFuerte}
            Bebida: ${bebida}
            
        """.trimIndent()
    }
}