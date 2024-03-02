package com.prime.washer.service;

import com.prime.washer.model.TimeSlots;
import com.prime.washer.model.Users;
import com.prime.washer.repository.TimeSlotRepository;
import com.prime.washer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public void bookTimeSlot(Long userId, Long timeSlotId){
        Optional<Users> optionalUsers = userRepository.findById(userId);
        Optional<TimeSlots> optionalTimeSlots = timeSlotRepository.findById(timeSlotId);

        if (optionalUsers.isPresent() && optionalTimeSlots.isPresent()){
            Users users = optionalUsers.get();
            TimeSlots timeSlots = optionalTimeSlots.get();

            if (!timeSlots.isBooked()) {
                users.setSelectedTimeSlot(timeSlots);
                userRepository.save(users);

                timeSlots.setBooked(true);
                timeSlotRepository.save(timeSlots);
            } else {
                throw new RuntimeException("Selected time slot is already booked");
            }
        } else {
            throw new RuntimeException("User or time slot ot found");
        }
    }
}
