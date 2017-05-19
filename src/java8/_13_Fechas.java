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
        //test.medirTiempo(8);
        //test.periodoEntreFechas(8);
        try{
            test.convertir(8);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    private void verificar(int version){
        if(version == 7){
            Calendar fecha1 = Calendar.getInstance();
            Calendar fecha2 = Calendar.getInstance();
            
            fecha1.set(1991, 0, 21);
            System.out.println(fecha1.after(fecha2));
        }else if(version == 8){
            // Fechas
            LocalDate fecha1 = LocalDate.of(1991, 1, 21);
            LocalDate fecha2 = LocalDate.now();
            
            System.out.println(fecha1.isAfter(fecha2));
            System.out.println(fecha1.isBefore(fecha2));
            
            // Tiempos
            LocalTime tiempo1 = LocalTime.of(22, 30, 50);
            LocalTime tiempo2 = LocalTime.now();
            
            System.out.println(tiempo1.isAfter(tiempo2));
            System.out.println(tiempo1.isBefore(tiempo2));
            
            // DateTime
            LocalDateTime fechatiempo1 = LocalDateTime.of(1991, 1, 21, 22, 30, 50);
            LocalDateTime fechatiempo2 = LocalDateTime.now();
            
            System.out.println(fechatiempo1.isAfter(fechatiempo2));
            System.out.println(fechatiempo1.isBefore(fechatiempo2));
        }
    }
    
    private void medirTiempo(int version)throws InterruptedException{
        if(version == 7){
            long ini = System.currentTimeMillis();
            Thread.sleep(1000);
            long fin = System.currentTimeMillis();
            System.out.println(fin - ini);
        }else if(version == 8){
            Instant ini = Instant.now();
            Thread.sleep(1000);
            Instant fin = Instant.now();
            
            System.out.println(Duration.between(fin, ini));
            System.out.println(Duration.between(fin, ini));
        }
    }
    
    private void periodoEntreFechas(int version){
        if(version == 7){
            Calendar nacimiento = Calendar.getInstance();
            Calendar actual = Calendar.getInstance();
            
            nacimiento.set(1988, 7, 8);
            actual.set(2017, 1, 20);
            
            int anios = 0;
            
            while(nacimiento.before(actual)){
                nacimiento.add(Calendar.YEAR, 1);
                if(nacimiento.before(actual)){
                    anios++;
                }
            }
            
            System.out.println(anios);
        }else if(version == 8){
            LocalDate nacimiento = LocalDate.of(2016, 9, 1);
            LocalDate actual = LocalDate.now();
            
            Period periodo = Period.between(nacimiento, actual);
            System.out.println("Han transcurrido " + periodo.getYears() + " años, " + periodo.getMonths() + " meses y " + periodo.getDays() + " dias, desde " + nacimiento + " hasta " + actual);
        }
    }
    
    private void convertir(int version) throws ParseException{
        String fecha = "08/08/1988";
        
        if(version == 7){
            DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaConvertida = formateador.parse(fecha);
            System.out.println(fechaConvertida);
            
            Date fechaActual = Calendar.getInstance().getTime();
            formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
            String fechaCadena = formateador.format(fechaActual);
            System.out.println(fechaCadena);
        }else if(version == 8){
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaLocal = LocalDate.parse(fecha, formateador);
            System.out.println(fechaLocal);
            System.out.println(formateador.format(fechaLocal));
        }
    }
}
