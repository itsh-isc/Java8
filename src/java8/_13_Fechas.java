package java8;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class _13_Fechas {
    public static void main(String[] args) {
        _13_Fechas test = new _13_Fechas();
        
        //test.verificar(8);
        test.periodoEntreFechas(8);
        try{
            //test.medirTiempo(8);
            //test.convertir(8);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    private void verificar(int version){
        int dia = 8;
        int mes = 8;
        int anio = 1988;
        
        int hora = 22;
        int minuto = 30;
        int segundo = 50;
        
        // En la version 7 se consideraba tedioso el uso de fechas y horas
        if(version == 7){
            Calendar fecha1 = Calendar.getInstance();
            Calendar fecha2 = Calendar.getInstance();
            
            fecha1.set(anio, mes - 1, dia);
            System.out.println(fecha1.after(fecha2));
        }else if(version == 8){
            // FECHAS
            LocalDate fecha1 = LocalDate.of(anio, mes, dia);
            LocalDate fecha2 = LocalDate.now(); // este instante de tiempo
            
            // verificamos cual fecha esta antes y despues de la otra
            System.out.println(fecha1.isAfter(fecha2));
            System.out.println(fecha1.isBefore(fecha2));
            
            // HORAS
            LocalTime tiempo1 = LocalTime.of(hora, minuto, segundo);
            LocalTime tiempo2 = LocalTime.now();
            
            System.out.println(tiempo1.isAfter(tiempo2));
            System.out.println(tiempo1.isBefore(tiempo2));
            
            // FECHA/TIEMPO (DateTime)
            LocalDateTime fechatiempo1 = LocalDateTime.of(anio, mes, dia, hora, minuto, segundo);
            LocalDateTime fechatiempo2 = LocalDateTime.now();
            
            System.out.println(fechatiempo1.isAfter(fechatiempo2));
            System.out.println(fechatiempo1.isBefore(fechatiempo2));
        }
    }
    
    private void medirTiempo(int version)throws InterruptedException{
        if(version == 7){
            // en Java 7 y anteriores, se median tiempos por medio de algunos tecnicismos
            long ini = System.currentTimeMillis();
            Thread.sleep(1000);
            
            long fin = System.currentTimeMillis();
            System.out.println(fin - ini);
        }else if(version == 8){
            // A partir de Java 8, resulta mas natural una medicion de tiempos
            Instant ini = Instant.now();
            Thread.sleep(1000);
            Instant fin = Instant.now();
            
            System.out.println(Duration.between(fin, ini));
            System.out.println(Duration.between(fin, ini).toMillis());
            System.out.println(Duration.between(fin, ini).toDays());
        }
    }
    
    private void periodoEntreFechas(int version){
        if(version == 7){
            // Para conocer el periodo entre fechas en las versiones Java 7 y anteriores
            // era necesario construir un algoritmo
            Calendar nacimiento = Calendar.getInstance();
            Calendar actual = Calendar.getInstance();
            
            nacimiento.set(1988, 7, 8);
            actual.set(2017, 6, 27);
            
            int anios = 0;
            
            while(nacimiento.before(actual)){
                nacimiento.add(Calendar.YEAR, 1);
                if(nacimiento.before(actual)){
                    anios++;
                }
            }
            
            System.out.println(anios + " años");
        }else if(version == 8){
            LocalDate nacimiento = LocalDate.of(2016, 9, 1);
            LocalDate actual = LocalDate.now();
            
            Period periodo = Period.between(nacimiento, actual);
            System.out.println("Han transcurrido " + periodo.getYears() + " años, " + periodo.getMonths() + " meses y " + periodo.getDays() + " dias, desde " + nacimiento + " hasta " + actual);
        }
    }
    
    private void convertir(int version) throws ParseException{
        String fecha = "08/08/1988";
        
        // En versiones anteriores a Java 8, para tratar fechas en formato string
        // era necesario apoyarse en una clase formateadora
        if(version == 7){
            DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaConvertida = formateador.parse(fecha);
            System.out.println(fechaConvertida);
            
            Date fechaActual = Calendar.getInstance().getTime();
            formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
            String fechaCadena = formateador.format(fechaActual);
            System.out.println(fechaCadena);
        }else if(version == 8){
            // A partir de Java 8 se tienen formateadores mas finos
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaLocal = LocalDate.parse(fecha, formateador);
            
            System.out.println(fechaLocal); // impresion sin formato
            System.out.println(formateador.format(fechaLocal)); // impresion con formato
        }
    }
}
