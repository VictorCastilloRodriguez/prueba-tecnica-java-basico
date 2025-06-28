package org.example.entities; // Ubicación del archivo dentro del proyecto

import jakarta.persistence.*;// Importa anotaciones de JPA para mapear la clase a la base de datos

@Entity // Indica que esta clase representa una entidad de la base de datos
@Table(name = "clientes") // El nombre de la tabla en la base de datos será "clientes"


public class Cliente {

    public enum Sexo {HOMBRE, MUJER} // Solo se permiten estos dos valores para el sexo del cliente

    @Id // Marca el atributo "id" como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El valor se genera automáticamente
    @Column(nullable = false, length = 50)
    private long id;


    String nombre;
    String primerApellido;
    String segundoApellido;
    Sexo sexo; // Guarda el enum Sexo como texto en la base de datos (por ejemplo, "HOMBRE")
    String ciudad;
    String fechaDeNacimiento;
    String telefono;
    String correoElectronico;

    public Cliente() { // Constructor vacío obligatorio para JPA
    }

    // Constructor con todos los campos excepto el id, que se genera automáticamente
    public Cliente(String nombre, String primerApellido, String segundoApellido, Sexo sexo, String ciudad, String fechaDeNacimiento, String telefono, String correoElectronico) {


        this.sexo = sexo;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.ciudad = ciudad;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }


    // Métodos getter y setter

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    // Método para mostrar un cliente de forma sencilla por consola

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", sexo='" + sexo + '\'' +
                ", fechaDeNacimiento='" + fechaDeNacimiento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }
}
