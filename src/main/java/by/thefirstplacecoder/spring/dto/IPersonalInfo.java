package by.thefirstplacecoder.spring.dto;

import java.time.LocalDate;

public interface IPersonalInfo {
    String getFirstName();
    String getLastName();
    LocalDate getBirthDate();
}