package cl.duoc.agenciaconnectapi.config;

import cl.duoc.agenciaconnectapi.model.*;
import cl.duoc.agenciaconnectapi.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner cargarDatosDemo(
            UsuarioRepository usuarioRepository,
            OrganizacionRepository organizacionRepository,
            ContactoRepository contactoRepository,
            EventoRepository eventoRepository,
            OportunidadRepository oportunidadRepository,
            SeguimientoRepository seguimientoRepository
    ) {
        return args -> {
            // 1. Precarga de Usuarios (4 cuentas exigidas)
            if (usuarioRepository.count() == 0) {
                usuarioRepository.saveAll(List.of(
                        new Usuario(null, "Patricia Vega (Supervisor)", "supervisor@agencia.cl", "super123", "SUPERVISOR"),
                        new Usuario(null, "Carlos Muñoz (Ejecutivo)", "carlos.comercial@agencia.cl", "eje123", "EJECUTIVO"),
                        new Usuario(null, "Marcela Rojas (Ejecutiva)", "marcela.ventas@agencia.cl", "eje123", "EJECUTIVO"),
                        new Usuario(null, "Felipe Soto (Ejecutivo)", "felipe.convenios@agencia.cl", "eje123", "EJECUTIVO")
                ));
            }

            // 2. Precarga de Organizaciones, Contactos, Eventos y Oportunidades
            if (organizacionRepository.count() == 0) {
                Organizacion org1 = organizacionRepository.save(new Organizacion(null, "Clínica Dental Sonrisa Austral", "Empresa", "Salud / Dental", "Providencia", "Metropolitana", "www.sonrisasaustral.cl", "Colaboradores y familias", "Convenio corporativo dental prioritario"));
                Organizacion org2 = organizacionRepository.save(new Organizacion(null, "Automotora Central de Servicios", "Empresa", "Automotriz", "Ñuñoa", "Metropolitana", "www.automotoracentral.cl", "Trabajadores y conductores", "Servicios de mantención y flota"));
                Organizacion org3 = organizacionRepository.save(new Organizacion(null, "Centro Veterinario Patitas Felices", "Empresa", "Veterinario", "La Florida", "Metropolitana", "www.patitasfelices.cl", "Amantes de mascotas y dueños", "Beneficios veterinarios corporativos"));
                Organizacion org4 = organizacionRepository.save(new Organizacion(null, "Municipalidad de Puente Alto", "Municipalidad", "Institución Pública", "Puente Alto", "Metropolitana", "www.puentealto.cl", "Vecinos y funcionarios municipales", "Ferias vecinales de alta afluencia"));
                Organizacion org5 = organizacionRepository.save(new Organizacion(null, "Corporación de Bienestar Bancario", "Asociación", "Financiero / Bienestar", "Santiago", "Metropolitana", "www.bienestarbancario.cl", "Asociados y cargas familiares", "Jornadas de beneficios institucionales"));

                contactoRepository.saveAll(List.of(
                        new Contacto(null, "Tamara Pérez", org1.getId(), "Jefa de Bienestar", "Recursos Humanos", "cperez@sonrisas.cl", "+56911223344", "Correo", "Muy interesada en activaciones dentales"),
                        new Contacto(null, "Esteban Gatica", org2.getId(), "Encargado de Beneficios", "Administración", "egatica@central.cl", "+56922334455", "Teléfono", "Coordina espacios en edificio corporativo"),
                        new Contacto(null, "Daniela Soto", org3.getId(), "Coordinadora de Eventos", "Marketing", "dsoto@patitas.cl", "+56933445566", "Correo", "Apoya ferias temáticas de mascotas"),
                        new Contacto(null, "Rodrigo Valenzuela", org4.getId(), "Director Dideco", "Comunicaciones", "rvalenzuela@puentealto.cl", "+56944556677", "Teléfono", "Gestiona permisos para plazas y espacios públicos"),
                        new Contacto(null, "Andrea Fuentes", org5.getId(), "Supervisora de Convenios", "Bienestar", "afuentes@bienestarbancario.cl", "+56955667788", "Correo", "Busca alianzas para socios bancarios")
                ));

                Evento ev1 = eventoRepository.save(new Evento(null, "Feria de Salud y Sonrisas", "Exposición de servicios dentales preventivos", "25082026", "Espacio Riesco", "Clínica Dental Sonrisa Austral", "android.resource://cl.duoc.agenciaconnect/drawable/imagen5"));
                Evento ev2 = eventoRepository.save(new Evento(null, "Jornada de Beneficios Automotrices", "Revisión técnica y convenios de mantención", "10092026", "Edificio Corporativo Ñuñoa", "Automotora Central de Servicios", "android.resource://cl.duoc.agenciaconnect/drawable/imagen4"));
                Evento ev3 = eventoRepository.save(new Evento(null, "Expo Mascotas y Bienestar", "Feria de salud animal y emprendedores", "15102026", "Parque Bicentenario", "Centro Veterinario Patitas Felices", "android.resource://cl.duoc.agenciaconnect/drawable/imagen3"));
                Evento ev4 = eventoRepository.save(new Evento(null, "Feria Vecinal y Servicios", "Activación municipal abierta a la comunidad", "05112026", "Plaza de Armas Puente Alto", "Municipalidad de Puente Alto", "android.resource://cl.duoc.agenciaconnect/drawable/imagen2"));
                Evento ev5 = eventoRepository.save(new Evento(null, "Encuentro Anual de Bienestar", "Jornada corporativa para asociados y familias", "20112026", "Hotel Sheraton Santiago", "Corporación de Bienestar Bancario", "android.resource://cl.duoc.agenciaconnect/drawable/imagen1"));

                Oportunidad op1 = oportunidadRepository.save(new Oportunidad(null, "Activación Módulo Dental en Feria", "Feria empresarial", org1.getId(), ev1.getId(), "Alta", "Alto", "Propuesta enviada", "Carlos Muñoz (Ejecutivo)", "Se envió presentación formal con tarifas preferenciales", "10082026"));
                oportunidadRepository.save(new Oportunidad(null, "Convenio Mantención Flota Colaboradores", "Evento corporativo", org2.getId(), ev2.getId(), "Media", "Alto", "Contacto realizado", "Marcela Rojas (Ejecutiva)", "Reunión inicial agendada para la próxima semana", "15082026"));
                oportunidadRepository.save(new Oportunidad(null, "Jornada de Vacunación y Cuidados", "Jornada de beneficios", org3.getId(), ev3.getId(), "Alta", "Medio", "Contacto pendiente", "Felipe Soto (Ejecutivo)", "Esperando validación de fechas por parte del centro", "01092026"));
                oportunidadRepository.save(new Oportunidad(null, "Stand de Beneficios en Feria Municipal", "Actividad municipal", org4.getId(), ev4.getId(), "Alta", "Alto", "Evento identificado", "Carlos Muñoz (Ejecutivo)", "Detectado aviso oficial en sitio municipal", "10092026"));
                oportunidadRepository.save(new Oportunidad(null, "Alianza de Convenios Exclusivos Socios", "Feria institucional", org5.getId(), ev5.getId(), "Media", "Alto", "En espera de respuesta", "Marcela Rojas (Ejecutiva)", "Propuesta enviada a comité de bienestar", "01102026"));

                seguimientoRepository.save(new Seguimiento(null, op1.getId(), "Carlos Muñoz (Ejecutivo)", "Envío de propuesta", "12/08/2026 10:30", "Cliente recibió dossier comercial y cotización", "Llamar el martes para confirmar stand", "Alta recepción del equipo de RRHH"));
            }
        };
    }
}
