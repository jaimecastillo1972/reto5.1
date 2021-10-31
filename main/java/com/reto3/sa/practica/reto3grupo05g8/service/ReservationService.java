/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.sa.practica.reto3grupo05g8.service;
/**
 * Impotar librerias
 */
import com.reto3.sa.practica.reto3grupo05g8.entity.CountClient;
import com.reto3.sa.practica.reto3grupo05g8.entity.DescriptionAmount;
import com.reto3.sa.practica.reto3grupo05g8.entity.Reservation;
import com.reto3.sa.practica.reto3grupo05g8.repository.ReservationRepository;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Grupo8
 */
@Service
public class ReservationService {
    /**
     * llamar 
     */
    @Autowired
    private ReservationRepository repo;
    
    /**
     * 
     * @param reservation
     * @return 
     */
    public Reservation insertReservation(Reservation reservation){
        return repo.save(reservation);
    }
    
    // mostrar todos 
    /**
     * 
     * @return 
     */
    public List<Reservation> listReservation(){
        return repo.getAll();
    }
    
    // mostrar  por id
    /*
    public Reservation listReservationById(Reservation reservation){
        return repo.findById(reservation.getId()).orElse(null);
    }
    */
    // insert 
    
    
    // updt 
    /**
     * 
     * @param reservation
     * @return 
     */
    public Reservation updateReservation(Reservation reservation){
        Reservation checkIfExist = repo.findById(reservation.getIdReservation()).orElse(null);
        checkIfExist.setGame(reservation.getGame());
        checkIfExist.setClient        (reservation.getClient());
        checkIfExist.setStartDate(reservation.getStartDate());
        checkIfExist.setDevolutionDate(reservation.getDevolutionDate());  
          
        return repo.save(checkIfExist);
       
    }
    
    // eliminar 
//    public String deleteReservation(int id){
//        Optional<Reservation> r = repo.findById(id);
//        
//        return repo.deleteById(r);
//    }

    /**
     * 
     * @param id
     * @return 
     */
    public Reservation getReservationById(int id) {
        
        return null;
        
    }
    
    /**
     * 
     * @param inicio
     * @param fin
     * @return 
     */
    public List<Reservation> reportDates(Calendar inicio,Calendar fin){
        return repo.reportDates(inicio, fin);
    }

    /**
     * 
     * @return 
     */
    public DescriptionAmount reportStatus(){
        
        List<Reservation> completed=repo.getReservationByStatus("completed");
        List<Reservation> cancelled=repo.getReservationByStatus("cancelled");

        DescriptionAmount descAmt=new DescriptionAmount(completed.size(),cancelled.size());
        return descAmt;
    }
    
    /**
     * 
     * @return 
     */
    public List<CountClient> getTopClient(){
        return repo.getTopClient();
    }
}
