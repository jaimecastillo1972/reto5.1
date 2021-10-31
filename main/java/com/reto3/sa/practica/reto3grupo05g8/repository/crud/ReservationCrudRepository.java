/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reto3.sa.practica.reto3grupo05g8.repository.crud;

import com.reto3.sa.practica.reto3grupo05g8.entity.Reservation;
import java.util.Calendar;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Don-Jaime
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    @Query("SELECT d FROM Reservation d WHERE startDate BETWEEN ?1 AND ?2")
    List<Reservation> reportDates(Calendar inicio, Calendar fin);
    
    public List<Reservation> findAllByStatus(String descriptionAAA);
    
    @Query("SELECT c.client, count(c.client) from Reservation as c group by c.client order by count(c.client) desc")
    public List<Object[]> countTotalClientByReservation();
}
