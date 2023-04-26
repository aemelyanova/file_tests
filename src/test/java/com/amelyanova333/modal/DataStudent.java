package com.amelyanova333.modal;

import java.util.List;

public class DataStudent {
    private Integer id;
    private String name;
    private String surname;
    private Score score;
    private List<String> hobbies;
    private Boolean formCompleted;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Score getScore() {
        return score;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public Boolean getFormCompleted() {
        return formCompleted;
    }


    public static class Score {
        Integer mathematics, science, computer;

        public Integer getMathematics() {
            return mathematics;
        }

        public Integer getScience() {
            return science;
        }

        public Integer getComputer() {
            return computer;
        }
    }
}

